package com.example.async.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.example.async.controller.AsyncController;

@Service
public class AsyncService {

	
	@Async
	public Future<String> asyncMethodWithReturnType() {
		AsyncController.elaborationStarted = 1;
	    System.out.println("Execute method asynchronously - " 
	      + Thread.currentThread().getName());
	    try {
	    	//Perform a long operation
	        Thread.sleep(5000);
	        return new AsyncResult<String>("hello world !!!!");
	    } catch (InterruptedException e) {
	        //
	    }

	    return null;
	}
}
