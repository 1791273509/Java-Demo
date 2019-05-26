package com.mainshi;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		
		for (int i = 1; i <= 6; i++) {
			final int tem = i;
			new Thread(
					()->{
						
						try {
//						占用资源
							semaphore.acquire();
							System.out.println(tem + "占用了停车位");
							Thread.sleep(1000);
							System.out.println(tem + "离开了车位");
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}finally {
//							释放资源,一定要有，有来有回
							semaphore.release();
						}
					}
					).start();;
		}
	}
}
