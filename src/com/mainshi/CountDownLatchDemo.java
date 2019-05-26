package com.mainshi;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		for (int i = 1; i <= 2; i++) {
			
			new Thread(
					()->
					{
						System.out.println(Thread.currentThread().getName() + "��");
				
						countDownLatch.countDown();
					
					},CountryEnum.foreach(i)
					).start();
			
		}
//		��֤��仰������߳�ִ��,ע��������await����������wait����
		
		countDownLatch.await();
		
		System.out.println(Thread.currentThread().getName() + "�೤����");
		
		
	}

}
