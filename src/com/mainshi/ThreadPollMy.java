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
//				��ʾִ��
				threadpool.execute(() ->{
					System.out.println(Thread.currentThread().getName());
				}); 
		}}catch (Exception e) {
			// TODO: handle exception
		} finally {
//			����ر��̳߳�
			threadpool.shutdown();
		}
			
			
		
		
	}

}
