package com.mainshi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ShouXieThreadPool {
	public static void main(String[] args) {
		ExecutorService pool = new ThreadPoolExecutor(2, 
				5, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
				Executors.defaultThreadFactory(),
				
				new ThreadPoolExecutor.DiscardPolicy());
		
		try {
			for (int i = 0; i < 19; i++) {
				final int tem = i;
				pool.execute(()->{
					System.out.println(Thread.currentThread().getName() +  " " + tem);
				});
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.shutdown();
		}
				
	}

}
