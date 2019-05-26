package com.mainshi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	
	public static void main(String[] args) throws InterruptedException {
		
		Phone phone = new Phone();
		new Thread(
				() ->{
					phone.sendemail();
				}
				,"t1").start();
		new Thread(
				() ->{
					phone.sendemail();
				}
				,"t2").start();
		Thread.sleep(1000);
		
		Thread t3 = new Thread(phone,"t3");
		t3.start();
		
		Thread t4 = new Thread(phone,"t4");
		t4.start();
		
		
		
		
		
		
		
	}
}
class Phone implements Runnable{
	
	public synchronized void sendemail(){
		System.out.println(Thread.currentThread().getId() + "发送邮件");
		sendemsg();
	}
	
	public synchronized void sendemsg(){
		System.out.println(Thread.currentThread().getId() + "发送短信");
	}

	Lock lock = new ReentrantLock();
	@Override
	public void run() {
		get();
		
		
	}
	
	public void get(){
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "get方法");
		
		set();
		lock.unlock();
		lock.unlock();
	}
	
	public void set(){
		lock.lock();
		
		System.out.println(Thread.currentThread().getName() + "set方法");
		lock.unlock();
	}
	
}


