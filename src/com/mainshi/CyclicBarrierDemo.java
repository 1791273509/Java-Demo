package com.mainshi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(7, new Thread(
				() -> {
					System.out.println("收集到七颗龙珠");
					
				}));
		
		for (int i = 1; i < 8; i++) {
		
			new Thread(()->{
				System.out.println(Thread.currentThread().getName() + "收集到");
		
				try {
//					只有七个线程全部结束才能执行barrier那个线程，相当于做加法
					
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			
			}).start();;
			
		}
	}
	
	
	
	
}
