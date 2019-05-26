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
			System.out.println("������������Ϊ"  + date);
			value = queue.offer(date);
			if(value){
				System.out.println("����ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
			
			Thread.sleep(1000);
		}
		System.out.println("ֹͣ�̲߳�����flagΪfalse");
		
		
	}
	public void Comsumer() throws InterruptedException{
		String date = null;
		while (flag) {
//			��ʼ����
			date = queue.poll(2,TimeUnit.SECONDS);
			System.out.println("���Ѷ��е�ֵΪ" + date);
			if(date == null || date.equals("")){
				System.out.println("����������û��ȡ�������˳�");
				flag = false;
				return;
			}else
				System.out.println("ȡ���ɹ�");
			
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}	
					
				},"������"
				
				).start();
		new Thread(
				()->{
					
					try {
						shop.Comsumer();
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					
					
				},"������"
				
				).start();
		
		
		Thread.sleep(5000);
		shop.stop();
		
	}
	
	

}
