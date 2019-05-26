package com.mainshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapTest {
	public static void main(String[] args) {

		
//		Map<String, String> map = new ConcurrentHashMap();
		Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
		for (int i = 0; i < 300; i++) {
			new Thread(
					() ->{
						map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
					System.out.println(map);
					}
					,String.valueOf(i)).start();
		}
		
		Lock lock = new ReentrantLock();
		
	}

}




