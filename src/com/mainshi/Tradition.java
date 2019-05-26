package com.mainshi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Date{
	private int date = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public void increment() throws Exception{
		lock.lock();
		while (date != 0) {
			condition.await();
		}
		date ++;
		System.out.println(date);
//		通知其他线程
		condition.signalAll();
		lock.unlock();
		
	
	}
	public void decrement() throws Exception{
		lock.lock();
		while (date == 0) {
//			多线程这里要被阻塞
			condition.await();
		}
		date --;
//		通知其他线程
		System.out.println(date);
		condition.signalAll();
		lock.unlock();
		
	
	}
	
}


public class Tradition {

	public static void main(String[] args) {
		Date date = new Date();
		new Thread(
				()->{
					for (int i = 0; i < 5; i++) {
						try {
							date.increment();
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
					
					
				}
				
				).start();
		
		new Thread(
				()->{
					for (int i = 0; i < 5; i++) {
						try {
							date.decrement();
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						
					}
				}
				
				).start();
		new Thread(
				()->{
					for (int i = 0; i < 5; i++) {
						try {
							date.increment();
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
					
					
				}
				
				).start();
		
		new Thread(
				()->{
					for (int i = 0; i < 5; i++) {
						try {
							date.decrement();
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						
					}
				}
				
				).start();
	}
}
