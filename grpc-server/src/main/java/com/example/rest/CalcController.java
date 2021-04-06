package com.example.rest;

import com.example.grpc.MultServiceGrpc;
import io.grpc.stub.StreamObserver;
import com.example.grpc.convertMatrix;
import com.example.grpc.MultServiceGrpc.MultServiceBlockingStub;
import com.example.grpc.MatrixRequest;
import com.example.grpc.MatrixResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import javax.annotation.PreDestroy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.google.common.math.IntMath.isPowerOfTwo;

@Service
public class CalcController {

	long deadline;

	@Autowired
	private Environment env;
	private int[] stubPorts = {8081,8082,8083,8084,8085,8086,8087,8088};

	@Value("${com.example.grpc.client.serverAdd}")
	private String serverAddress;

	private ManagedChannel[] channels;
	private BlockMultServiceBlockingStub[] stubs;
	private BlockingQueue<Integer> stubList = new LinkedBlockingQueue<>(stubPorts.length);

	@PostConstruct
	public void init() throws InterruptedException {
		channels = newChannels();
		stubs = newStubs();
	}

	@PreDestroy
	public void destroy() {
	    for(ManagedChannel channel : channels) {
			channel.shutdown();
		}
	}


	private ManagedChannel[] newChannels() {
		ManagedChannel[] channels = new ManagedChannel[stubPorts.length];
		
        System.out.println("Connection with server: " + serverAddress);
		for(int i =0; i < stubPorts.length; i++) {
			channels[i] = ManagedChannelBuilder.forAddress(serverAddress, stubPorts[i])
					.keepAliveWithoutCalls(true)
					.usePlaintext()
					.build();
		}
		return channels;
	}


	public String fileMult(String matA, String matB, long deadline) throws InvalidMatrixException, ExecutionException, InterruptedException {
		int[][] A = stringArrToMatrix(matA);
		int[][] B = stringArrToMatrix(matB);
		System.out.println("Matrix 1: " + convertMatrix.encodeMatrix(A));
		System.out.println("Matrix 2: " + convertMatrix.encodeMatrix(B));

		int[][] res = multiplyMatrixBlock(A, B, deadline);
		return convertMatrix.encodeMatrix(res);
	}
// ---------------------
	private static int[][] stringArrToMatrix(String matrixString) throws InvalidMatrixException {
		String[] rows = matrixString.trim().split("\n");
		String[] columns = rows[0].trim().split(" ");
		int[][] newArr = new int[rows.length][columns.length];

		if(!isPowerOfTwo(rows.length) || !isPowerOfTwo(columns.length)){
			throw new InvalidMatrixException("Error, matrix row and column size not a power of 2!");
		}

        

		if(rows.length != columns.length) {
			throw new InvalidMatrixException("Error this is not a square matrix");
		}

		if(rows.length < 1 || columns.length < 1) {
			throw new InvalidMatrixException("Error with matrix, row or columns are not well defined");
		}

		try {
			for (int i = 0; i < rows.length; i++) {
				String[] matrixValues = rows[i].trim().split(" ");
				if(matrixValues.length != columns.length) {
					throw new InvalidMatrixException("Error this is not a square matrix");
				}
				for (int j = 0; j < matrixValues.length; j++) {
					newArr[i][j] = Integer.parseInt(matrixValues[j]);
				}
			}
		} catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
			throw new InvalidMatrixException("Error processing matrix");
		}

		return newArr;
	}

	private static MatrixRequest createReq(int A[][], int B[][]) {
		String matrixA = convertMatrix.convertToString(A);
		String matrixB = convertMatrix.convertToString(B);

		MatrixRequest request = MatrixRequest.newBuilder()
				.setMatrixA(matrixA)
				.setMatrixB(matrixB)
				.build();

		return request;
	}

	private int[][] multiplyBlock(int A[][], int B[][], int stubIndex) {
		System.out.println("Server multiplyining " + (stubIndex+1));
		MatrixRequest request = createReq(A, B);
		MatrixResponse matrixMultiplyResponse = this.stubs[stubIndex].multiplication(request);
		int[][] res = convertMatrix.transformM(matrixMultiplyResponse.getMatrix());
		return res;
	}



    private int[][] addBlock(int A[][], int B[][], int stubIndex) {
		System.out.println("Server adding blocks " + (stubIndex + 1));
		MatrixRequest req = createReq(A, B);
		MatrixResponse matrixAddResponse = this.stubs[stubIndex].addition(req);
		int[][] res = convertMatrix.transformM(matrixAddResponse.getMatrix());
		return res;
	}


	private int[][] joinBlocks(int[][] A3, int[][] B3, int[][] C3, int[][] D3) {
		int length = A3.length;
		int lenB = length/2;
		int[][] res = new int[length][length];

		for (int i = 0; i < lenB; i++)
		{
			for (int j = 0; j < lenB; j++)
			{
				res[i][j]=A3[i][j];
			}
		}
		for (int i = 0; i < lenB; i++)
		{
			for (int j = lenB; j < length; j++)
			{
				res[i][j]=B3[i][j-lenB];
			}
		}
		for (int i = lenB; i < length; i++)
		{
			for (int j = 0; j < lenB; j++)
			{
				res[i][j]=C3[i-lenB][j];
			}
		}
		for (int i = lenB; i < length; i++)
		{
			for (int j = lenB; j < length; j++)
			{
				res[i][j]=D3[i-lenB][j-lenB];
			}
		}
		return res;
	}

	private int[][] multiplyMatrixBlock(int[][] A, int[][] B, long deadline) throws InterruptedException, ExecutionException {


		HashMap<String, int[][]> blocks = breakIntoChunks(A, B);
		int index = stubLists(1)[0];
		long start = System.nanoTime();
		CompletableFuture<int[][]> asyncCall = CompletableFuture.supplyAsync(() -> multiplyBlock(blocks.get("A1"), blocks.get("A2"), index));
		int[][] chunkA = asyncCall.get();
		long completed = System.nanoTime();
		long footprint= completed-start;
		long maxCall = 11L;
		int serverCount = (int) Math.ceil((float)footprint*(float)maxCall/(float)deadline);
		serverCount = serverCount <= 8 ? serverCount : 8;

		System.out.println("Amount of server calculating: "+ serverCount);
		int[] indices = stubLists(serverCount);
		BlockingQueue<Integer> indexQueue = new LinkedBlockingQueue<>((int) maxCall);

		int i = 0;
		while(indexQueue.size() != maxCall) {
		    if(indices.length == i) {
		        i = 0;
			}
			indexQueue.add(indices[i]);
			i++;
		}

		

		CompletableFuture<int[][]> D3 = CompletableFuture.supplyAsync(() -> {
			try {
				return addBlock(C1B2.get(), D1D2.get(), indexQueue.take());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		});


		CompletableFuture<int[][]> A3 = CompletableFuture.supplyAsync(() -> {
			try {
				return addBlock(chunkA, B1C2.get(), indexQueue.take());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		});

		CompletableFuture<int[][]> B1C2 = CompletableFuture.supplyAsync(() -> {
			try {
				return multiplyBlock(blocks.get("B1"), blocks.get("C2"), indexQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});

		
		CompletableFuture<int[][]> B1D2 = CompletableFuture.supplyAsync(() -> {
			try {
				return multiplyBlock(blocks.get("B1"), blocks.get("D2"), indexQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});

		CompletableFuture<int[][]> C1A2 = CompletableFuture.supplyAsync(() -> {
			try {
				return multiplyBlock(blocks.get("C1"), blocks.get("A2"), indexQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});

		

		CompletableFuture<int[][]> C1B2 = CompletableFuture.supplyAsync(() -> {
			try {
				return multiplyBlock(blocks.get("C1"), blocks.get("B1"), indexQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});

		CompletableFuture<int[][]> D1D2 = CompletableFuture.supplyAsync(() -> {
			try {
				return multiplyBlock(blocks.get("D1"), blocks.get("D2"), indexQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});

		CompletableFuture<int[][]> D1C2 = CompletableFuture.supplyAsync(() -> {
			try {
				return multiplyBlock(blocks.get("D1"), blocks.get("C2"), indexQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});

		CompletableFuture<int[][]> B3 = CompletableFuture.supplyAsync(() -> {
			try {
				return addBlock(A1B2.get(), B1D2.get(), indexQueue.take());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		});



		CompletableFuture<int[][]> C3 = CompletableFuture.supplyAsync(() -> {
			try {
				return addBlock(C1A2.get(), D1C2.get(), indexQueue.take());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		});

		CompletableFuture<int[][]> A1B2 = CompletableFuture.supplyAsync(() -> {
			try {
				return multiplyBlock(blocks.get("A1"), blocks.get("B2"), indexQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});
				

		int[][] res = joinBlocks(A3.get(), B3.get(), C3.get(), D3.get());

		System.out.println("Calculation completed");
		return res;
	}


	

	private HashMap<String,int[][]> breakIntoChunks(int[][] A, int[][] B) {

		int length = A.length;
		int lenB = length/2;

		int[][] A1 = new int[length][length];
		int[][] A2 = new int[length][length];
		int[][] B1 = new int[length][length];
		int[][] B2 = new int[length][length];
		int[][] C1 = new int[length][length];
		int[][] C2 = new int[length][length];
		int[][] D1 = new int[length][length];
		int[][] D2 = new int[length][length];

		for (int i = 0; i < lenB; i++)
		{
			for (int j = 0; j < lenB; j++)
			{
				A1[i][j]=A[i][j];
				A2[i][j]=B[i][j];
			}
		}
		for (int i = 0; i < lenB; i++)
		{
			for (int j = lenB; j < length; j++)
			{
				B1[i][j-lenB]=A[i][j];
				B2[i][j-lenB]=B[i][j];
			}
		}
		for (int i = lenB; i < length; i++)
		{
			for (int j = 0; j < lenB; j++)
			{
				C1[i-lenB][j]=A[i][j];
				C2[i-lenB][j]=B[i][j];
			}
		}
		for (int i = lenB; i < length; i++)
		{
			for (int j = lenB; j < length; j++)
			{
				D1[i-lenB][j-lenB]=A[i][j];
				D2[i-lenB][j-lenB]=B[i][j];
			}
		}

		HashMap<String, int[][]> blocks = new HashMap<>();
		blocks.put("A1", A1);
		blocks.put("A2", A2);
		blocks.put("B1", B2);
		blocks.put("B2", B2);
		blocks.put("C1", C1);
		blocks.put("C2", C2);
		blocks.put("D1", D1);
		blocks.put("D2", D2);

		return blocks;
	}


    private BlockMultServiceBlockingStub[] newStubs() {
		BlockMultServiceBlockingStub[] allStubs = new BlockMultServiceBlockingStub[stubPorts.length];

		for(int i =0; i < channels.length; i++) {
			allStubs[i] = BlockMultServiceGrpc.newBlockingStub(channels[i]);
		}

		for(int i = 0; i < stubPorts.length; i++) {
			stubList.add(i);
		}

		return allStubs;
	}


    private int[] stubLists(int num) throws InterruptedException {
		int[] pos = new int[num];
		for(int i = 0; i < num; i++) {
			pos[i] = this.stubList.take();
			this.stubList.add(pos[i]);
		}
		return pos;
	}
}
