package com.mainshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		
//		����ı�ʾʱ��������Ϊ��λ��ǰ���2��ʾ2��
		queue.offer("a", 2, TimeUnit.SECONDS);
		queue.offer("a", 2, TimeUnit.SECONDS);
		queue.offer("a", 2, TimeUnit.SECONDS);
		queue.offer("a", 2, TimeUnit.SECONDS);
		queue.poll(2, TimeUnit.SECONDS);
		queue.poll(2, TimeUnit.SECONDS);
		queue.poll(2, TimeUnit.SECONDS);
		queue.poll(2, TimeUnit.SECONDS);
		
		
	}
}
