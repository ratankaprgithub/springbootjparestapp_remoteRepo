package com.cg.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<MyErrorDetails> handleSNFE(StudentNotFoundException exp,WebRequest wr) {
		
		MyErrorDetails err=new MyErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(exp.getMessage());
		err.setDetails(wr.getDescription(false));
		
		ResponseEntity<MyErrorDetails> re=new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
		
		return re;
	}
	

	//to handle Not found exception (wrong uri)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
			

	MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage()+" wrong uri", req.getDescription(false));

		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
					
	}
		
	
	
	
	
	
	//for any other type of exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception e,WebRequest wr)  {
		
	/*	
		MyErrorDetails err=new MyErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(wr.getDescription(false));
	*/
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		
		
		ResponseEntity<MyErrorDetails> re=new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
		return re;
		
	
	
	}

	
	
	
	
}
