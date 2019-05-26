package cn.xwb.test;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections.ArrayStack;

public class Contest104 {
	public static void main(String[] args) {
		
		String [] ins = {"1"};
		List<String> tem = new ArrayList<>();

		tem.add("a");
//		ins = tem.toArray(new String[tem.size()]);
		System.out.println(Arrays.toString(ins));
		
		
		tem = Arrays.asList(ins);
		System.out.println(tem.toString());
	}
//	2019年4月26日17:37:55
	public String smallestEquivalentString(String A, String B, String S) {
		int []map = new int[26];
		for (int i = 0; i < A.length(); i++) {
			map[A.charAt(i) - 'a'] = A.charAt(i) - 'a';
		}
		for (int i = 0; i < B.length(); i++) {
			map[B.charAt(i) - 'a'] = B.charAt(i) - 'a';
		}
		
		for (int i = 0; i < A.length(); i++) {
			unio(map, A.charAt(i) - 'a', B.charAt(i) - 'a');
		}
		String result = "";
		for (int i = 0; i < S.length(); i++) {
			result = (char)(find(map,S.charAt(i) - 'a') + 'a') + "";
		}
		
		return result;
		
        
    }
	public int find(int []dp,int j){
		return dp[j] == j ? j : find(dp, dp[j]);
	}
	public void unio(int dp[],int i ,int j){
		int x1 = find(dp, i);
		int x2 = find(dp, j);
		if(x1 < x2){
			dp[x2] = x1;
		}else {
			dp[x1] = x2;
		}
	}
	
	public int longestRepeatingSubstring(String S) {
//        首先根据题目意思
		String tme = S;
		int result = S.length() - 1;
		if(S.subSequence(0, S.length() - 2).equals(S.subSequence(1, S.length()))){
			return result - 1;
		}
		while (true) {
			while (result -- > 0) {
				Set<String> set = new HashSet<>();
				for (int i = 0; i + result < S.length(); i++) {
					System.out.println(S.substring(i,result + i));
					if(set.contains(S.substring(i, result + i))){
						return result;
					}else {
						set.add(S.substring(i, result + i));
					}
				}
			}
			
			return result;
		}
		
		
    }
	
//	2019年4月26日10:36:09
	public boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < deck.length; i++) {
			map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
		}
        int start = 2;
        while (true) {
        	boolean flag = true;
        	for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
    			if(entry.getValue() < start){
    				return false;
    			}
    			if(entry.getValue() % start != 0){
    				start ++;
    				flag = false;
    				break;
    			}
    			
    		}
        	if(flag){
        		return true;
        	}
		}
        
    }
	public int partitionDisjoint(int[] A) {
		int result = 1;
		int max = A[0];
		int leftmax = max;
		for (int i = 1; i < A.length; i++) {
			if(max < A[i]) {
				max = A[i];
			}
			if(leftmax > A[i]){
				leftmax = max;
				result = i;
			}
		}
		if(result == A.length){
			result --;
		}
		return result;
    }
	
	public int getmax(int []A,int left,int right){
		int result = A[left];
		for (int i = left + 1; i <= right; i++) {
			result = result < A[i] ? A[i] : result;
		}
		return result;
	}
	public int getmin(int []A,int left,int right){
		int result = A[left];
		for (int i = left + 1; i <= right; i++) {
			result = result > A[i] ? A[i] : result;
			
		}
		return result;
	}
	public boolean isJiao(int[]A,int left1,int right1,int left2,int right2){
		for (int i = left1; i <= right1; i++) {
			for (int j = left2; j <= right2; j++) {
				if(A[i] == A[j]){
					return false;
				}
			}
		}
		return true;
	}
	public List<String> wordSubsets(String[] A, String[] B) {
		List<String> result = new ArrayList<>();
		
//		初始化B数组
		int [][]b = new int[B.length][26];
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[i].length(); j++) {
				b[i][B[i].charAt(j) - 'a'] ++;
			}
		}
		int [][]a = new int[A.length][26];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length(); j++) {
				a[i][A[i].charAt(j) - 'a'] ++;
			}
			boolean flag = true;
			for (int j = 0; j < b.length; j++) {
				for (int j2 = 0; j2 < 26; j2++) {
					if(b[j][j2] > a[i][j2]){
						flag = false;
						break;
					}
				}
				if(!flag){
					break;
				}
			}
			if(flag){
				result.add(A[i]);
			}
		}
		
		
		
		
		
		return result;
        
    }
	
}
