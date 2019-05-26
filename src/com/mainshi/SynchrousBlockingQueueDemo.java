package com.mainshi;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import org.junit.experimental.theories.Theories;

public class SynchrousBlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new SynchronousQueue<>();
		
		new Thread(() ->
				{
					try {
						queue.put("1");
						queue.put("2");
						queue.put("3");
						
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				},"AAA").start();
		
		
		new Thread(
				()->{
					try {
						Thread.sleep(1000);
						System.out.println(queue.take());
						Thread.sleep(1000);
						System.out.println(queue.take());
						Thread.sleep(1000);
						System.out.println(queue.take());
						
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
					
					
				},"BBB"
				).start();;
		
		
		
	}
}
