package com.mainshi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareDate{
	
	private int num = 1;
	Lock lock = new ReentrantLock();
	Condition c1 = lock.newCondition(); //表示的是A线程
	Condition c2 = lock.newCondition(); //表示的是B线程
	Condition c3 = lock.newCondition(); //表示的是C线程
	
//	打印5次
	public void print5() throws InterruptedException {
		lock.lock();
		while (num != 1) {
//			c1等待
			c1.await();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1);
		}
		num = 2;
//		这里就是精确唤醒c2线程
		c2.signal();
		lock.unlock();
	}
//	打印10次
	public void print10() throws InterruptedException {
		lock.lock();
		while (num != 2) {
//			c1等待
			c2.await();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1);
		}
		num = 3;
//		这里就是精确唤醒c3线程
		c3.signal();
		lock.unlock();
	}
//	打印15次
	public void print15() throws InterruptedException {
		lock.lock();
		while (num != 3) {
//			c1等待
			c3.await();
		}
		for (int i = 0; i < 15; i++) {
			System.out.println(i+1);
		}
		num = 1;
//		这里就是精确唤醒c1线程
		c1.signal();
		lock.unlock();
	}
}



public class Print5Print10Print15 {

	public static void main(String[] args) {
		
		ShareDate date = new ShareDate();
		new Thread(
				()->{
					for (int i = 0; i < 10; i++) {
						try {
							date.print5();
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
					
					
				}
				).start();
		
		new Thread(
				()->{
					for (int i = 0; i < 10; i++) {
						try {
							date.print10();
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
					
					
				}
				).start();
		
		new Thread(
				()->{
					for (int i = 0; i < 10; i++) {
						try {
							date.print15();
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				}
				).start();
		
	}
}
