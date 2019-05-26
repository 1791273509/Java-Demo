package com.mainshi;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		for (int i = 1; i <= 2; i++) {
			
			new Thread(
					()->
					{
						System.out.println(Thread.currentThread().getName() + "走");
				
						countDownLatch.countDown();
					
					},CountryEnum.foreach(i)
					).start();
			
		}
//		保证这句话在最后线程执行,注意这里是await函数，不是wait函数
		
		countDownLatch.await();
		
		System.out.println(Thread.currentThread().getName() + "班长走了");
		
		
	}

}
