package com.mainshi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//��֤��д��
class Mycache{
	private volatile Map<String, Object> map = new HashMap<>();
//	ʹ�ö�д��
//	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock lock = new ReentrantLock();
	public void put(String key,Object value) throws InterruptedException{
//		lock.writeLock().lock();
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "д����");
		map.put(key, value);
		Thread.sleep(100);
		System.out.println(Thread.currentThread().getName() + "д�����");
//		lock.writeLock().unlock();
		lock.unlock();
	}
	public void get(String key){
//		lock.readLock().lock();
//		lock.lock();
		System.out.println(Thread.currentThread().getName() + "��ȡ��" + key);
		Object object = map.get(key);
		System.out.println(Thread.currentThread().getName() + "��ȡ���" + object);
//		lock.readLock().unlock();
//		lock.unlock();
	}
	
}
public class ReadWriteLock {
	public static void main(String[] args) {
		Mycache cache = new Mycache();
		for (int i = 0; i < 10; i++) {
			final int tem = i;
			new Thread(
					() ->
					{
					try {
						cache.put( tem + "", tem + "");
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					}
					).start();
			
		}
		
for (int i = 0; i < 10; i++) {
			
			final int tem = i;
			new Thread(
					() ->
					{
					cache.get(tem + "");
					}
					).start();
			
		}
	}
	

}
