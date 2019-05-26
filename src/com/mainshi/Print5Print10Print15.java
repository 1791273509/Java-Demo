package com.mainshi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareDate{
	
	private int num = 1;
	Lock lock = new ReentrantLock();
	Condition c1 = lock.newCondition(); //��ʾ����A�߳�
	Condition c2 = lock.newCondition(); //��ʾ����B�߳�
	Condition c3 = lock.newCondition(); //��ʾ����C�߳�
	
//	��ӡ5��
	public void print5() throws InterruptedException {
		lock.lock();
		while (num != 1) {
//			c1�ȴ�
			c1.await();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1);
		}
		num = 2;
//		������Ǿ�ȷ����c2�߳�
		c2.signal();
		lock.unlock();
	}
//	��ӡ10��
	public void print10() throws InterruptedException {
		lock.lock();
		while (num != 2) {
//			c1�ȴ�
			c2.await();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1);
		}
		num = 3;
//		������Ǿ�ȷ����c3�߳�
		c3.signal();
		lock.unlock();
	}
//	��ӡ15��
	public void print15() throws InterruptedException {
		lock.lock();
		while (num != 3) {
//			c1�ȴ�
			c3.await();
		}
		for (int i = 0; i < 15; i++) {
			System.out.println(i+1);
		}
		num = 1;
//		������Ǿ�ȷ����c1�߳�
		c1.signal();
		lock.unlock();
	}
}



public class Print5Print10Print15 {

	public static void main(String[] args) {
		
		ShareDate date = new ShareDate();
		new Thread(
				()->{
					for (int i = 0; i < 10; i++) {
						try {
							date.print5();
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
					}
					
					
				}
				).start();
		
		new Thread(
				()->{
					for (int i = 0; i < 10; i++) {
						try {
							date.print10();
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
					}
					
					
				}
				).start();
		
		new Thread(
				()->{
					for (int i = 0; i < 10; i++) {
						try {
							date.print15();
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
					}
				}
				).start();
		
	}
}
