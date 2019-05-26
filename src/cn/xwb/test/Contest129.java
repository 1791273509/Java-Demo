package cn.xwb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class Contest129 {
	public static void main(String[] args) {
		int [] t = new int[1];
		t[0] = 1;
		int [] x = new int[2];
		x[0] = 1;
		x[1] = 2;
		x = new int[t.length];
		x = t;
		System.err.println(Arrays.toString(x));
		System.out.println((int)'a');
	}
	public List<String> commonChars(String[] A) {
		List<String> result = new ArrayList<String>();
		int [][] tem = new int [A.length][26];
		if(A.length == 0){
			return result;
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length(); j++) {
				tem[i][A[i].charAt(j) - 97] ++;
			}
		}
		for (int i = 0; i < 26; i++) {
			int min = tem[0][i];
			for (int j = 0; j < A.length; j++) {
				if(min > tem[j][i]){
					min = tem[j][i];
				}
			}
			if(min != 0){
				for (int j = 0; j < min; j++) {
					result.add((char)(97 + i) + "");
				}
			}
		}
		
		return result;
        
    }
	
	public boolean isValid(String S) {
		
		if(S.length() % 3 != 0){
			return false;
		}else {
			for (int i = 0; i < S.length() - 2; i++) {
				if(S.charAt(i) == 'a' && S.charAt(i + 1) == 'b' && S.charAt(i + 2) == 'c'){
					String tem1 = S.substring(0, i);
					String tem2 = S.substring(i + 3);
					S = tem1 + tem2;
					i = -1;
				}
			}
			if(S.length() == 0){
				return true;
			}else {
				return false;
			}
			
			
			
			
		}
		
        
    }
	
	public int mergeStones(int[] stones, int K) {
		 List<Integer> get = new ArrayList<>();

	        if(K == 1 && stones.length == 1){
				return stones[0];
			}
			if(K == 1 && stones.length != 1){
				return -1;
			}
			if(stones.length == 1){
				return stones[0];
			}
			if(stones.length < K){
				return -1;
			}
			if(stones.length == K){
				int result = 0;
				for (int i : stones) {
					result += i;
				}
				return result;
			}else {
				
				while (true) {
	                int min = 0;
				int index = 0;
				for (int i = 0; i < K; i++) {
					min += stones[i];
				}
					for (int i = 0; i < stones.length - K + 1; i++) {
						System.out.println(Arrays.toString(stones));
						int tem = 0;
						for (int x = i; x < K + i; x++) {
							tem += stones[x];
						}
						if(min > tem){
							index = i;
							min = tem;
						}				
					}
					System.out.println(index);
					int newint[] = new int[stones.length - K + 1];
					boolean isfangru = false;
					for (int j = 0; j < stones.length; j++) {
						if(j == index){
							newint[j] = min;
							j += K - 1;
							isfangru = true;
						}else {
							if(!isfangru){
								newint[j] = stones[j];
							}else {
								newint[j - (K - 1)] = stones[j];
							}
						}
					}
					stones = new int[newint.length];
					stones = newint;
					get.add(min);
	                	
					if(newint.length == 1){
						
						int res = 0;
						for (int i : get) {
							res += i;
						}
						
						return res;
					}

					if(newint.length < K){
						return -1;
					}
				}
				
				
			}
    }
	
	
}
