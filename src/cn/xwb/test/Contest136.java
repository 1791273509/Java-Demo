package cn.xwb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Contest136 {
	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<>();
		deque.offerLast(1);
		deque.offerLast(2);
		deque.offerLast(3);
		System.out.println(deque);
		System.out.println(deque.pollLast());
		System.out.println(deque);
	}
	public int[] gardenNoAdj(int N, int[][] paths) {
    
		int result[] = new int[N];
		List<List<Integer>> list = new ArrayList<>(N + 1);
		for (int i = 0; i < list.size(); i++) {
			list.add(new ArrayList<>());
		}
		
		
		for (int[] list2 : paths) {
			int min = Math.min(list2[0], list2[1]);
			int max = Math.max(list2[0], list2[1]);
			list.get(min).add(max);
		}
		
		for (int i = 1; i <= N; i++) {
			boolean tem[] = new boolean[5];
			List<Integer> temlist = list.get(i);
			for (Integer integer : temlist) {
				tem[result[integer - 1]] = false;
			}
			for (int j = 1; j <= 4; j++) {
				if(tem[j]){
					result[i - 1] = j;
					break;
				}
			}
			
			
			
		}
		
		
		return result;
    }
	
	
	
	
    public int maxSumAfterPartitioning(int[] A, int K) {
    	int result[] = new int[A.length];
    	for (int i = 0; i < A.length; i++) {
			int summax = 0;
			int curmax = A[i];
			for (int j = i; j >= 0 && i - j + 1 >= K; j--) {
				if(curmax < A[j]){
					curmax = A[i];
				}
				summax = Math.max(summax, result[j-1] + (i - j + 1) * curmax);
				System.out.println(j + " " + summax);
				
			}
			result[i] = summax;
			
		}
    	
    	System.out.println(Arrays.toString(result));
    	
    	return result[A.length - 1];
    	
    	
    	
    	
    }
	
	
	
	
}
