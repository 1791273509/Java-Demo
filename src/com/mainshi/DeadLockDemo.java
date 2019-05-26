package com.mainshi;

class DeadData implements Runnable{
	String lockA;
	String locaB;
	public DeadData(String lockA, String locaB) {
		super();
		this.lockA = lockA;
		this.locaB = locaB;
	}
	@Override
	public void run() {
		synchronized (lockA) {
			System.out.println(Thread.currentThread().getName() + "�Ѿ����" + lockA + "���Ի��" + locaB) ;
			synchronized (locaB) {
				System.out.println(Thread.currentThread().getName() + "���Ի��" + locaB) ;
			}
		}
	}
}

public class DeadLockDemo {
	public static void main(String[] args) {
		new Thread(new DeadData("AAA", "BBB"),"A�߳�").start();
		new Thread(new DeadData("BBB", "AAA"),"B�߳�").start();
	}
}
