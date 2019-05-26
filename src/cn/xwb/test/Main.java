package cn.xwb.test;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		get2();
	}
	public static void get(){
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		int n = scanner.nextInt();
	
		int tem[][] = new int[n][2];
		while (n-- > 0) {
			tem[n][0] = scanner.nextInt();
			tem[n][1] = scanner.nextInt();
		}
//		System.out.println(Arrays.toString(tem[0]));
//		System.out.println(Arrays.toString(tem[1]));
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO 自动生成的方法存根
						return o1.compareTo(o2);
					}
				});
		//对tem数组进行遍历
		for (int i = 0; i < tem.length; i++) {
			boolean flag = true;
			for (int j = 0; j < tem.length; j++) {
				if(i != j){
					if(tem[i][0] <= tem[j][0] && tem[i][1] <= tem[j][1]){
						flag = false;
						break;
					}
				}
			}
			if(flag){
				map.put(tem[i][0], tem[i][1]);
			}
		}
		for (Map.Entry<Integer, Integer> is : map.entrySet()) {
			System.out.print(is.getKey() +" ");
			System.out.println(is.getValue());
			
		}
		
		
		
		
		
	}
	
	public static void get2(){
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		int n = scanner.nextInt();
		int m = n;
		int tem[] = new int[n];
		while (n-- > 0) {
			tem[n] = scanner.nextInt();
		}
		if(m == 0){
			System.out.println(0);
			return;
		}
		if(m == 1){
			System.out.println(tem[0] * tem[0]);
			return;
		}
		int max = tem[0] * tem[0];
		for (int i = 0; i < tem.length; i++) {
			for (int len = 1; len <= tem.length - i; len++) {
				max = Math.max(max, in(tem,len,i));
				
			}
		}
		System.out.println(max);
		
	}
	public static int in(int tem[],int len,int start){
		int min = tem[start];
		int sum = 0;
		for (int i = start; i < start + len; i++) {
			sum += tem[i];
			min = Math.min(min, tem[i]);
		}
		return min * sum;
	}
	
}