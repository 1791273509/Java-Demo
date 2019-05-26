package com.mainshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		
//		后面的表示时间是以秒为单位，前面的2表示2秒
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
