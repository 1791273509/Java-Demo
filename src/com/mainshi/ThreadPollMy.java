package com.mainshi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPollMy {
	public static void main(String[] args) {
//		ExecutorService threadpool = Executors.newFixedThreadPool(5);
//		ExecutorService threadpool = Executors.newSingleThreadExecutor();
		ExecutorService threadpool = Executors.newCachedThreadPool();
		
	
		
		try {
			for (int i = 1; i <= 15; i++) {
//				表示执行
				threadpool.execute(() ->{
					System.out.println(Thread.currentThread().getName());
				}); 
		}}catch (Exception e) {
			// TODO: handle exception
		} finally {
//			必须关闭线程池
			threadpool.shutdown();
		}
			
			
		
		
	}

}
