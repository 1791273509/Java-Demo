package com.mainshi;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
	
	AtomicReference<Thread> reference = new AtomicReference<>();
	public void mylock(){
		
		Thread thread = Thread.currentThread();
		System.out.println(Thread.currentThread().getName() +"lock ...");
		while (!reference.compareAndSet(null, thread)) {
			System.out.println("dfd");
		}
		
	}
	public void myunlock(){
		
		reference.compareAndSet(Thread.currentThread(), null);
		System.out.println(Thread.currentThread().getName() + "unlock .....");
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		SpinLock lock = new SpinLock();
		new Thread(
				() -> {
					lock.mylock();
//					先占用3秒
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					lock.myunlock();
				}
				
				,"t1").start();
		
		Thread.sleep(1000);
		
		new Thread(
				() -> {
					lock.mylock();
					
					lock.myunlock();
					
				}
				
				,"t2").start();
	}

}
