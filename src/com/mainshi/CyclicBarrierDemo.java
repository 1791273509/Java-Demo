package com.mainshi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(7, new Thread(
				() -> {
					System.out.println("�ռ����߿�����");
					
				}));
		
		for (int i = 1; i < 8; i++) {
		
			new Thread(()->{
				System.out.println(Thread.currentThread().getName() + "�ռ���");
		
				try {
//					ֻ���߸��߳�ȫ����������ִ��barrier�Ǹ��̣߳��൱�����ӷ�
					
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			
			}).start();;
			
		}
	}
	
	
	
	
}
