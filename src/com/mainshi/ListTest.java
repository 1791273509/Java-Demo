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
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
	public static void main(String[] args) {

		
		List<Integer> tem1 = new ArrayList<>();
		List<Integer> tem2 = new LinkedList<>();
		tem1.size();
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		List<String> tem = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 30; i++) {
			new Thread(
					() ->{
						tem.add(UUID.randomUUID().toString().substring(0,8));
					System.out.println(tem);
					}
					
					).start();
		}
		
		
		
	}

}




