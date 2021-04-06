package com.example.rest;
import java.nio.charset.StandardCharsets;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import java.util.concurrent.ExecutionException;

@RestController
public class Calculation {

	GRPCClientService clientReq;

	@Autowired
	public Calculation(GRPCClientService req) {
		this.clientReq = req;
	}


	@GetMapping("/multiplyMatrix")
	public String multiplyMatrix(@RequestParam("A") MultipartFile A, @RequestParam("B") MultipartFile B, @RequestParam("deadline") String deadline) {
	    try 
        {

			String matrixA = new String(A.getBytes(), StandardCharsets.UTF_8);
			String matrixB = new String(B.getBytes(), StandardCharsets.UTF_8);
			return CalcController.fileMult(matrixA, matrixB, Long.parseLong(deadline));
            
	    } 
        catch(IOException | InvalidMatrixException | ExecutionException | InterruptedException e) 
        {
	    	e.printStackTrace();
	    	return e.getLocalizedMessage();
		}
	}
}
