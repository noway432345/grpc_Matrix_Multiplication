package com.example.grpc.server;
import javax.el.MethodNotFoundException;
import java.util.Arrays;
import com.example.grpc.MultServiceGrpc;
import io.grpc.stub.StreamObserver;
import com.example.grpc.ConvertMatrix;
import com.example.grpc.MatrixRequest;
import com.example.grpc.MatrixResponse;



public class MultServiceImpl extends MultServiceGrpc.MultServiceImplBase {

	int threadAmnt;

	public MultServiceImpl(int threadAmnt) {

		this.threadAmnt = threadAmnt;
	}

	// @Override
	public void addition(MatrixRequest req, StreamObserver<MatrixResponse> responseObserver) {
//display current task
		System.out.println("server is calculating addition. \n Thread Amount is: "+ threadAmnt);
		handleReq(req, responseObserver, "add");
	}

	

    // @Override
	public void multiplication(MatrixRequest req, StreamObserver<MatrixResponse> responseObserver) {
        //display current task
		System.out.println("Server is now multiplying. \n Thread Amount is:" + threadAmnt);
		handleReq(req, responseObserver, "multiply");
	}

	
    private static int[][] multiplyMatrices(int A[][], int B[][]) {

		int arrlen = A.length;
		int newMatrix[][]= new int[arrlen][arrlen];

        for(int x=0;x<(arrlen/2);x++){
            for(int y=0;y<(arrlen/2);y++){
                for(int z=0;z<(arrlen/2);z++){

                    newMatrix[x][y]+=(A[x][z]*B[z][y]);
                }
            }
        }

        return newMatrix;
	}


	private static int[][] addMatrices(int[][] A, int[][]B) {

		int MAX = A.length;
		int[][] newMatrix = new int[MAX][MAX];

		for (int i=0; i<newMatrix.length; i++) {
			for (int a=0; a < newMatrix.length; a++) {
				newMatrix[i][a] = A[i][a] + B[i][a];
			}
		}
		return newMatrix; 
	}


	private void handleReq(MatrixRequest req, StreamObserver<MatrixResponse> responseObserver, String calcType) throws MethodNotFoundException {

		int[][] A = ConvertMatrix.transformM(req.getMatrixA());//convert to matrix
		int[][] B = ConvertMatrix.transformM(req.getMatrixB());//convert to matrix
		int[][] calcRes;

		// if calcType.equalsIgnoreCase("multiply")  {
		// 		calcRes = multiplyMatrices(A, B);
        // }
		// else if calcType.equalsIgnoreCase("add"){
        //         calcRes = addMatrices(A, B);
        // }
		// else{
		// 		throw new MethodNotFoundException("Undefined or unknown task:" + calcType);
		// }

		switch(calcType){
			case "multiply":
				calcRes = multiplyMatrices(A, B);
				break;
			case "add":
				calcRes = addMatrices(A, B);
				break;
			default:
				throw new MethodNotFoundException("Undefined or unknown task:" + calcType);

		}

		
		String convertedMatrix = ConvertMatrix.convertToString(calcRes);
		MatrixResponse response = MatrixResponse.newBuilder()
			.setMatrix(convertedMatrix)
			.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	
}
