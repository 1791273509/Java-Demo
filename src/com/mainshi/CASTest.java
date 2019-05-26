package com.mainshi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASTest {
	public static void main(String[] args) {
		
		AtomicInteger ait = new AtomicInteger(3);
		
		System.out.println(ait.compareAndSet(3, 2019));
		
		System.out.println(ait.compareAndSet(5, 111));
		
		System.out.println(ait);
		ait.incrementAndGet();
		
		
		User user1 = new User("张三",22);
		User user2 = new User("李四",100);
		AtomicReference<User> reference = new AtomicReference<>();
		
		reference.set(user1);
		
		reference.compareAndSet(user1, user2);
		System.out.println(reference.get().toString());
		AtomicStampedReference<Integer> reference2 = new AtomicStampedReference<Integer>(100, 1);
		
		
		
		
		
	}

}


class User{
	String name;
	int id;
	public User(String name, int id) {
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
	
	
}

