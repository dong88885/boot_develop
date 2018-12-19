package com.boot.develop;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

public class DataValidException extends RuntimeException {
	

	Map<String,String> msgMap;
	
	Integer status;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public DataValidException(HttpStatus status,Map<String,String> msgMap) {
			
		this.status=status.value();
		
		this.msgMap=msgMap;
	}
	
	
	public DataValidException(HttpStatus status,Errors errors) {
		
		if(errors.hasErrors()) {
			
			 if(errors.hasFieldErrors()) {
				 
				Optional.of(msgMap).orElseGet(()->{
					
					return msgMap=new HashMap<>();
									
				});		
					
				/* errors.getFieldErrors().forEach(fieldErr->{
					 
					 msgMap.put(fieldErr.getField(), fieldErr.getDefaultMessage());					 
				 });*/
				 
				 errors.getAllErrors().forEach(objErr->{					 
					 msgMap.put(objErr.getObjectName(), objErr.getDefaultMessage());	
				 });
				 
			 }
		}
		
	}
		
		
}
