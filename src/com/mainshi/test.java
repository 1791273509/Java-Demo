package com.mainshi;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicInteger;

class Mydate{
	private static volatile Mydate mydate = null;
	
	private Mydate(){
		System.out.println(Thread.currentThread().getName());
	}

	public synchronized static Mydate getdate(){
		if(mydate == null){
			synchronized (Mydate.class) {
				if(mydate == null){
					mydate = new Mydate();
				}
			}
		}
		return mydate;
	}
	
	
}
public class test {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i <= 559; i++) {
			new Thread(){
				public void run() {
				Mydate.getdate();
				
				}
		}.start();
		}
		
		

		
	}

}
