package com.example.async.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.async.service.AsyncService;

@RestController
public class AsyncController {

	static int callNumber=0;
	public static int elaborationStarted=0;
	@Autowired
	AsyncService asyncService;

	@GetMapping("async")
	public String testAsyncCall() throws InterruptedException, ExecutionException 
	{
		String res="";
		Future<String> future = null;	
		System.out.println("Invoking an asynchronous method. " 
				+ Thread.currentThread().getName());
		if(elaborationStarted == 0)
			future = asyncService.asyncMethodWithReturnType();
		else
			return "Elaborazione in corso, attendere";
		while (true) {
			if (future.isDone()) {
				System.out.println("Result from asynchronous process - " + future.get());
				res = "[CALL_NUMBER] "+callNumber+"Result from asynchronous process - " + future.get();
				elaborationStarted=0;
				break;
			}
			System.out.println("Continue doing something else. ");
			Thread.sleep(1000);
		}
		return res;
	}
	
	@GetMapping("other")
	public String otherController() throws InterruptedException, ExecutionException 
	{
		return "Other controller "+(callNumber++);
	}
	
	@GetMapping("elaborationStatus")
	public Integer elaborationStatus() throws InterruptedException, ExecutionException 
	{
		return elaborationStarted;
	}
}
