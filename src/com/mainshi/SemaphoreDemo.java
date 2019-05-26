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
//						ռ����Դ
							semaphore.acquire();
							System.out.println(tem + "ռ����ͣ��λ");
							Thread.sleep(1000);
							System.out.println(tem + "�뿪�˳�λ");
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}finally {
//							�ͷ���Դ,һ��Ҫ�У������л�
							semaphore.release();
						}
					}
					).start();;
		}
	}
}
