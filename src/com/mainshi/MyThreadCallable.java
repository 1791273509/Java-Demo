package com.mainshi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class MyThreadCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*Integer integer = 127;
		Integer integer2 = 127;
		System.out.println(integer == integer2);*/
		
		
		
		FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
		new Thread(futureTask,"aa").start();
		new Thread(futureTask,"BB").start();
		
		System.out.println(futureTask.get());
		
		
		
		
	}

}
class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("come in callable");
		return 12777;
	}
	
	
}