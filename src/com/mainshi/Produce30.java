package com.mainshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Shop{
	private volatile boolean flag = true;
	private AtomicInteger integer = new AtomicInteger();
	private BlockingQueue<String> queue = null;
	public Shop(BlockingQueue<String> blocking){
		System.out.println(blocking.getClass().getName());
		this.queue = blocking;
	}
	
	public void Produce() throws InterruptedException{
		String date = null;
		boolean value;
		while (flag) {
			date = integer.incrementAndGet() + "";
			System.out.println("生产者生产的为"  + date);
			value = queue.offer(date);
			if(value){
				System.out.println("插入成功");
			}else {
				System.out.println("插入失败");
			}
			
			Thread.sleep(1000);
		}
		System.out.println("停止线程不生产flag为false");
		
		
	}
	public void Comsumer() throws InterruptedException{
		String date = null;
		while (flag) {
//			开始消费
			date = queue.poll(2,TimeUnit.SECONDS);
			System.out.println("消费队列的值为" + date);
			if(date == null || date.equals("")){
				System.out.println("超过两秒钟没有取到消费退出");
				flag = false;
				return;
			}else
				System.out.println("取出成功");
			
		}
		
		
	}
	
	
	public void stop(){
		this.flag = false;
		
	}
	
	
}
public class Produce30 {
	public static void main(String[] args) throws Exception {
		Shop shop = new Shop(new ArrayBlockingQueue<>(10));
		new Thread(
				()->{
					
				try {
					shop.Produce();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}	
					
				},"生产者"
				
				).start();
		new Thread(
				()->{
					
					try {
						shop.Comsumer();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
					
				},"消费者"
				
				).start();
		
		
		Thread.sleep(5000);
		shop.stop();
		
	}
	
	

}
