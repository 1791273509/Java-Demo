package cn.xwb.test;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.xml.transform.Templates;

import net.sf.ezmorph.primitive.IntMorpher;

class MyHashSet {

    /** Initialize your data structure here. */
	int [] data = null;
    public MyHashSet() {
        data = new int[1000001];
        for (int i = 0; i < data.length; i++) {
			data[i] = -1;
		}
    }
    
    public void add(int key) {
        data[key] = key;
    }
    
    public void remove(int key) {
        data[key] = -1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[key] == -1? false : true;
    }
}
public class leet {
	Queue<Integer> stack = new LinkedList<>();
	
	
	public static void main(String[] args) {

		List<String> temStrings = new ArrayList<>();
		temStrings.add("tem");
		System.out.println(temStrings.contains("tem"));

		System.out.println("tem".substring(0,0) + "tem".substring(3,3));
	}
	
	
	
	
	public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null ){
        	return -1;

        }
        
        int min = root.val;
        
        
        return min;


    }
	
	
	
	public int longestStrChain(String[] words) {
		
		
		int dp[] = new int[words.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		for (int i = 2; i <= words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				String tem = words[j];
				int len1 = tem.length();
				if(len1 == i){
//					移出一个元素看是否找得到
					for (int k = 0; k < tem.length(); k++) {
						String get = tem.substring(0,k) +tem.substring(k+1,tem.length());
						System.out.println(get);
						for (int l = 0; l < words.length; l++) {
							
							if(words[l].equals(get)){
								dp[j] = Math.max(dp[l] + 1, dp[j]);
								System.out.println(dp[j]);
							}
						}
 					}
				}
			}
		}
		
		
		int max = 1;
		for (int i : dp) {
			if(max < i){
				max = i;
			}
		}
		
		return max;
        
    }
	
	public int get(TreeNode root){
		if(root.left == null){
			return root.left.val;
		}else {
			int min1 =  get(root.left);
			int min2 = get(root.right);
			
			return min1 < min2 ? min1 : min2;
		}
		
	}
	
	public void get(List<Integer> list,TreeNode root){
		
		if(root == null){
			return ;
		}
		list.add(root.val);
		get(list, root.left);
		get(list, root.right);
	}
	
	
	
	
	
	
//	2019年4月29日16:28:57
	 public int minPathSum(int[][] grid) {
		 int len1 = grid.length;
		 int len2 = grid[0].length;
		 int dp [][] = new int[len1][len2];
		 dp[0][0] = grid[0][0];
//		 初始化
		 for (int i = 1; i < len1; i++) {
			dp[i][0] = grid[i][0] + dp[i-1][0];
		}
		 
		 for (int i = 1; i < len2; i++) {
				dp[0][i] = grid[0][i] + dp[0][i - 1];
			}
		 System.out.println(Arrays.toString(dp[0]));
		 for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		 
		 
		 
		 
		 
		 
		 return dp[len1 - 1][len2 - 1];
	  
	 
	 
	 }
	 
	 
	 
	 
	 
	 
	 
	 public int numSquares(int n) {
		 int dp[] = new int[n + 1];
		 if(n == 1){
			 return 1;
		 }
		 if(n == 0){
			 return 0;
		 }
		 dp[0] = 1;
		 dp[1] = 1;
		 dp[2] = 2;
 	     for (int i = 3; i <= n; i++) {
 	    	 int min = Integer.MAX_VALUE;
			for (int j = 1; j * j  <= i; j++) {
				min = Math.min(min, dp[i - j * j] + 1);
			}
			dp[i] = min;
		} 
 	     System.out.println(Arrays.toString(dp));
 	     return dp[n];
	 }
	
	 public int rob(int[] nums) {
		 
		 if(nums.length == 0 ){
			 return 0;
		 }


		 if(nums.length == 1){
			 return nums[0];
		 }
		 
		 
		 int dp[] = new int[nums.length];

		 dp[0] = nums[0];
		 dp[1] = nums[1];
		 int result = dp[0] > dp[1] ? dp[0] :dp[1];
		 for (int i = 2; i < dp.length; i++) {
			 int max = 0;
			for (int j = i - 2; j >= 0; j--) {
				max = Math.max(max, dp[j]);
			}
			dp[i] = Math.max(max + nums[i], max);
			result = result > dp[i] ? result : dp[i];
		}
	  
	 
		 return result;
	 
	 }
	
	public ListNode reverseList(ListNode head) {
	     ListNode tem = head;
	     ListNode pre = null;
	    
	     
	     while (tem != null) {
			
	    	 ListNode node = tem.next;
	    	 tem.next = pre;
	    	 pre = tem;
	    	 tem = node;
	    	 
	    	 
		}
			
		
		
	       return tem;
	   
	
	}
	public TreeNode searchBST(TreeNode root, int val) {
		if(root == null){
			return null;
		}
        if(root.val < val){
        	return searchBST(root.right, val);
        }
        if(root.val > val){
        	return searchBST(root.left, val);
        }
        return root;
    }
	
	
//	2019年4月12日10:44:33
	public TreeNode increasingBST(TreeNode root) {
		List<Integer> addIntegers = new ArrayList<>();
        if(root == null){
        	return root;
        }
        ge(addIntegers, root);
        TreeNode resultNode = new TreeNode(0);
        TreeNode pre = null;
        for (int i = addIntegers.size() - 1; i >= 0; i--) {
        	TreeNode node = new TreeNode(addIntegers.get(i));
        	node.left = null;
        	node.right = pre;
        	pre = node;
		}
        System.out.println(addIntegers.toString());
        return pre;
    }
	public void ge(List<Integer> tem,TreeNode node){
		if(node == null){
			return ;
		}
		System.out.println(node.val);
		ge(tem, node.left);
		tem.add(node.val);
		ge(tem, node.right);
	}
	
	
	public boolean isUnivalTree(TreeNode root) {
		/*if (root == null) {
			return true;
		}
		Queue<TreeNode>  tem = new LinkedList<>();
		tem.offer(root);
		while (!tem.isEmpty()) {
			int size = tem.size();
			for (int i = 0; i < size; i++) {
				TreeNode sNode = tem.poll();
				if(root.val != sNode.val){
					return false;
				}
				if(sNode.left != null){
					tem.offer(sNode.left);
				}
				if(sNode.right != null){
					tem.offer(sNode.right);
				}
			}
		}
		return true;*/
		
		//使用递归来实现
		
		
		
		if(root == null){
			return true;
		}
		return false;
    }
	
	
	public boolean is(TreeNode root,int val){
		if(root == null){
			return true;
		}
		if(root.val != val){
			return false;
		}
		return is(root.left,val) && is(root.right,val);
	}
	
	public int smallestRangeI(int[] A, int K) {
		if(A.length == 0 || A.length == 1){
			return 0;
		}
		
		int min = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			int j = A[i];
			if(j > max){
				max = j;
			}
			if(j < min){
				min = j;
			}
		}
		int result = 0;
		
		if(max - min <= 2 * K){
			return 0;
		}
		else {
			result = max - min - 2 * K;
		}
		return result;
    }
	
	public static String[]  findRestaurant(String[] list1, String[] list2) {
        
		
		//考虑使用map来存储所有的东西，并且第一个表示的是字符串，第二个表示的是索引
		Map<String, Integer> map = new HashMap<>();
		int i = 1;
		for (String string : list1) {
			//记录下字符串与其对应的索引
			map.put(string, i++);
		}
		i = 1;
		for (String string : list2) {
			//取出其对应的索引
			if(map.get(string) != null){
				map.put(string, map.get(string) + i );
			}
			i++;
		}
		i = 1;
		for (String string : list1) {
			//去除list1中有的但是list2中没有的字符串
			if(map.get(string) == i){
				map.remove(string);
			}
			i ++;
		}
		System.out.println(map.toString());
		if(map.size() == 1){
			String [] result = new String[1];

			for (String string : map.keySet()) {
				result[0] = string;
				return result;
			}
		}else {
			int min = Integer.MAX_VALUE;
			for (String string : map.keySet()) {
				if(min > map.get(string)){
					min = map.get(string);
				}
			}
			List<String> temList = new ArrayList<>();
			for (String string : map.keySet()) {
				if(min == map.get(string)){
					temList.add(string);
				}
			}
			
			String[] arr = (String[])temList.toArray(new String[temList.size()]);
			
			return arr;
		}
		return new String[-1];
    }
	
	
	public boolean hasGroupsSizeX(int[] deck) {
		int result [] = new int[10001];
		for (int i : deck) {
			result[i] ++;
		}
		int min = Integer.MAX_VALUE;
		
		for (int i : result) {
			if(i != 0){
				if(min > i){
					min = i;
				}
			}
		}
		if(min < 2){
			return false;
		}
		//从2开始
		int tem = 2;
		while (tem<=min) {
			boolean flag = false;
			for (int i : result) {
				
				if(i != 0){
					if(i % tem != 0){
						tem++;
						flag = true;
						break;
					}
				}
			}
			if(! flag){
				return true;
			}
		}
		
		
		return false;
        
    }
	
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> banSet = new HashSet<>();
		String result = null;
		for (String string : banned) {
			banSet.add(string);
		}
        char [] tem = paragraph.toLowerCase().toCharArray();
        int i = 0;
     //   int cur = 0;
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        while (i < tem.length) {
        	StringBuilder sb = new StringBuilder();
        	while (tem[i] <='z' && tem[i] >= 'a'){
        		sb.append(tem[i]);
        		i ++;
        		if(i == tem.length ){
        			break;
        		}
			}
			String word = sb.toString();
			if(word.length() != 0 ){
				if(!banSet.contains(word)){
					int j = map.getOrDefault(word, 0) + 1;
					map.put(word, j);
					if(max < j){
						max = j;
						result = word;
					}
					
				}
			}
        	i ++;
        	
        	
		}
        return result;
    }
	
	
	
	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> result = new ArrayList<>();
		
		int start = 0;
		int i = 0;
		for (i = 0; i < S.length() - 1; i++) {
			if(S.charAt(start) == S.charAt(i + 1)){
				
			}else if (i - start + 1 >=3) {
				List<Integer> tem = new ArrayList<>();
				tem.add(start);
				tem.add(i);
				result.add(tem);
				start = i + 1;
			}else {
				start = i + 1;
			}
		}
		
		if(i - start + 1 >= 3){
			List<Integer> tem = new ArrayList<>();
			tem.add(start);
			tem.add(i);
			result.add(tem);
		}
		return result;
        
    }
	
	public static boolean isMonotonic(int[] A) {
		//进行优化的代码
		
		if(A.length == 1 || A.length == 0){
			return true;
		}
		//默认是没有的
		int index = 0;
		//默认是下降的
		boolean isminus = true;
		for (int i = 0; i < A.length - 1; i++) {
			int j = A[i];
			if(index == 0 && j < A[i + 1]){
				isminus = false;
				//已经在前面有了判断
				index = 1;
			}
			if(i == 0 && j > A[i + 1]){
				isminus = true;
				//已经在前面有了判断
				index = 1;
			}
			if(isminus && j < A[i + 1]){
				return false;
			}
			if(!isminus && j > A[i + 1]){
				return false;
			}
			
			
		}
		
		return true;
		
		
		
		//下面的代码是可以直接运行的
		/*if(A.length == 1 || A.length == 0){
			return true;
		}
		
		//假定默认是递减的
		boolean isminus = true;
        //判断第一个数字和第二个数字是递减还是递增
		int i;
		for (i = 0; i < A.length - 1; i++) {
			int j = A[i];
			if(j > A[i + 1]){
				break;
			}else if (j < A[i + 1]) {
				isminus = false;
				break;
			}else {
				continue;
			}
		}
		if(i == A.length - 1){
			return true;
		}
		for ( ; i < A.length; i++) {
			int j = A[i];
			if(j < A[i + 1] && isminus){
				return false;
				
			}
			if(j > A[i + 1] && !isminus){
				return false;
			}
			
		}
		return true;*/
		
    }
	
	
	public static int[] shortestToChar(String S, char C) {
		int [] result = new int[S.length()];
		List<Integer> temMap = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			char tem = S.charAt(i);
			if(tem == C){
				temMap.add(i);
				result[i] = 0;
			}
		}
		int index = 0;
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i) != C){
				if(index == 0){
					result[i] = Math.abs(temMap.get(index) - i);
				}else {
					if(index - 1 != 0){
						result[i] = Math.min(Math.abs(temMap.get(index -1) - i), 
								Math.abs(temMap.get(index) - i));
					}else {
						
					}
				}
			}else {
				index ++;
			}
			
		}
		
		
		return result;
		
		
		
    }
	
	public static int[] numberOfLines(int[] widths, String S) {
        int result[] = new int[2];
        //考虑可以直接使用数组的下标来进行对应
        //比如:'a' = 97, 那么-97
        //对S进行遍历
        int sum = 0;
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
			char j = S.charAt(i);
			if(sum + widths[j - 97] > 100){
				index ++;
				sum = widths[j-97];
				
			}else {
				sum +=widths[j - 97];
				
			}
			if(i == S.length() - 1){
				result[1] = sum;
			}
			
		}
        
        result[0] = index + 1;
        return result;
    }
	
	
	public static int pivotIndex(int[] nums) {
		if(nums.length == 0){
			return -1;
		}
		int index = 0;
		int sumA = nums[0];
		int sumB = 0;
		int end = nums.length - 1;
		for (int i : nums) {
			sumB += i;
		}
		//特殊情况，如果数组总合是零的化，根据测试用例得出的是返回0
		if(sumB == 0){
			return 0;
		}
		//初始化的是1是否是的
		sumB  = sumB - nums[0] - nums[1];
		System.out.println(sumA);
		System.out.println(sumB);
		for (int i = 1; i < nums.length -1; i++) {
			if(sumA == sumB){
				return index + 1;
			}else {
				sumA+=nums[index + 1];
				index ++;
				sumB -=nums[index + 1];
			}
		}
		return -1;
		
		
		/*
		 * 
		 * 
		 * 如果只出现的是正数可以用下面这个，但是如果出现的是负数那么可能要换种方法
		 * if(nums.length == 0){
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		int presum = nums[start];
		int endsum = nums[end];
		while (start < end) {
			if(presum > endsum){
				end--;
				endsum +=nums[end];
			}else if(presum < endsum){
				start ++;
				presum +=nums[start];
			}else {
				if(start + 1 == end - 1){
					return start +1;
				}else {
					end--;
					start++;
				}
			}
		}
        return -1;*/
    }
	
	public String[] uncommonFromSentences(String A, String B) {
		String [] temA = A.split(" ");
		String [] temB = B.split(" ");
		System.out.println(temA);
		Map<String, Integer> hashmapA = new HashMap<>();
		Map<String, Integer> hashmapB = new HashMap<>();
		//将其全部放入到hashmap中去
		for (String string : temA) {
			hashmapA.put(string, hashmapA.getOrDefault(string, 0) + 1);
		}
		
		
		for (String string : temB) {
			hashmapB.put(string, hashmapB.getOrDefault(string, 0) + 1);
			
		}
		System.out.println(hashmapA.toString());
		List<String> resu = new ArrayList<>();
		
		for (String string : hashmapA.keySet()) {
			if(hashmapA.get(string) == 1 && !hashmapB.containsKey(string)){
				resu.add(string);
			}
		}
		for (String string : hashmapB.keySet()) {
			if(hashmapB.get(string) == 1 && !hashmapA.containsKey(string)){
				resu.add(string);
			}
		}
		System.out.println(resu.toString());
		
		return  (String[])resu.toArray(new String[resu.size()]);  
        
    }
	
	
	
	
	public int[] fairCandySwap(int[] A, int[] B) {
		int resutl[] = new int[2];
		Map<Integer, Integer> hasMapA = new HashMap<>();
		Map<Integer, Integer> hasMapB = new HashMap<>();
		int j = 0;
		int sumA = 0;
		int sumB = 0;
		for (int i : A) {
			hasMapA.put(i, j++);
			sumA += i;
		}
		for (int i : B) {
			hasMapB.put(i, j++);
			sumB += i;
		}
		if(sumA == sumB){
			
			
		}else if (sumA > sumB) {
			//数组A的和大于数组B的和
			int tem = (sumA - sumB )/2;
			for (int i = 0; i < A.length; i++) {
				int k = A[i];
				if(hasMapB.containsKey(k-tem)){
					resutl[0] = k;
					resutl[1] = k - tem;
					return resutl;
				}
				
			}
		}else {
			//数组B的和大于数组A的和
			int tem = (sumB - sumA )/2;
			for (int i = 0; i < B.length; i++) {
				int k = B[i];
				if(hasMapA.containsKey(k-tem)){
					resutl[0] = k - tem;
					resutl[1] = k;
					return resutl;
				}
				
			}
		}
		
		
		return resutl;
        
    }
	
	
	
	
	public static String reverseOnlyLetters(String S) {
		char [] tem = S.toCharArray();
		int start = 0;
		int end = tem.length -1;
		while (start < end) {
			//找到对应的字母
			while(tem[start] < 65 || (tem[start] > 90 && tem[start] <97) || tem[start] > 122){
				start ++;
				if(start == tem.length || start >= end ){
					return new String(tem);
				}
			}
			
			//找到对应的字母
			while(tem[end] < 65 || (tem[end]>90 && tem[end] <97) || tem[end] > 122){
				if(end == 0 || start >= end){
					return new String(tem);
				}else {
					end --;
				}
			}
			System.out.println("交换" + start);
			System.out.println("交换后者" + end);
			char s = tem[start];
			tem [start] = tem[end];
			tem[end] = s;
			start ++;
			end --;
			
		}
		
	//	System.out.println(tem);
		return new String(tem);
    }
	public static int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int max = 0;
		for (int i : map.values()) {
			if(max < i){
				max = i;
			}
		}
		int min = nums.length;
		for (int i : map.keySet()) {
			if(map.get(i) == max){
				int start = 0;
				int end = nums.length - 1;
				while (nums[start] != i) {
					start ++;
				}
				while (nums[end] != i) {
					end --;
				}
				min = Math.min(min, end - start +1);
			}
		}
		return min;
    }
	public int dominantIndex(int[] nums) {
		if(nums.length == 1)
			return 0;
		
		int max = nums[0];
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if(max < nums[i]){
				max = nums[i];
				index = i;
			}
		}
		
		Arrays.sort(nums);
		int x = nums.length - 1;
		while (x >=0) {
			if(nums[x]  < max){
				break;
			}
			if(x == 0){
				break;
			}
			x--;
		}
		if(nums[x] == max){
			return -1;
		}
		if(max >= nums[x] * 2){
			return index;
		}
		
		
		return -1;
    }
	
	public static boolean isLongPressedName(String name, String typed) {
		if(name.equals(typed)){
			return true;
		}
		
		if(name.charAt(0) != typed.charAt(0)){
			return false;
		}
        int i = 1;
        int j = 1;
        for ( ;j < typed.length() && i < name.length(); ) {
			if(typed.charAt(j) == name.charAt(i)){
				i++;
				j++;
			}else if(typed.charAt(j) == typed.charAt(j-1)) {
				j++;
			}else {
				return false;
			}
			
		}
		if(i != name.length() ){
			return false;
		}else {
			while (j < typed.length()-1) {
				if(typed.charAt(j) != typed.charAt(j+1)){
					return false;
				}
				
			}
			return true;
		}
		
    }
	public static int repeatedStringMatch(String A, String B) {
		 StringBuilder tempS = new StringBuilder(A);
	     int count=1;
		 while(tempS.length() < B.length()){
			 tempS.append(A);
			 count++;
		 }
		 if(tempS.indexOf(B)>=0) {
			 return count;
		 }
		 tempS.append(A);
		 if(tempS.indexOf(B)>=0) {
			 return count+1;
		 }
		 return -1;

		/*int count = 0;
		String tem = A;
		if(A.indexOf(B) != -1){
			return 1;
		}
		
		
		while (tem.indexOf(B) == -1) {
			tem = tem + A;
			count ++;
			if(count >= 2 * A.length() + B.length()){
				return -1;
			}
		}
		
        System.out.println(tem);
        return count+1;*/
    }
	public  static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> resutlt = new ArrayList<>();
		
		for (int i = left; i <= right; i++) {
			int tem = i;
			System.out.println(i);
			boolean flag = true;
			while (tem != 0) {
				int j = (tem% 10);
				if(j == 0){
					flag = false;
					break;
				}
				if(i % j != 0){
					flag = false;
					break;
				}
				tem = tem/10;
			}
			
			if(flag){
				resutlt.add(i);
			}
		}
		return resutlt;
        
    }
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<>();
		Deque<TreeNode> tem = new LinkedList<>();
		tem.offer(root);
		while (!tem.isEmpty()) {
			int size = tem.size();
			long sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = tem.poll();
				sum+=node.val;
				if(node.left != null){
					tem.offer(node.left);
				}
				if(node.right != null){
					tem.offer(node.right);
				}
			}
			list.add((double)sum/size);
		}
		
		return list;
        
    }
	public boolean canPlaceFlowers(int[] flowerbed, int n){
		if(flowerbed.length == 1 && n == 1&& flowerbed[0] == 0){
			return true;
		}
		
		boolean flag = false;
		if(flowerbed.length >=3){
			if(flowerbed[0] == 0 && flowerbed[1] == 0){
				n--;
				flowerbed[0] = 1;
			}
		}
		
		for (int i = 1; i < flowerbed.length - 1; i++) {
			if(flowerbed[i-1] == 0&& flowerbed[i+1] == 0 && flowerbed[i] == 0){
				n--;
				flowerbed[i] = 1;
				
			}
			
			
			
			if(n==0){
				return true;
			}
		}
		if(flowerbed.length >= 2){
			if(flowerbed[flowerbed.length-1] == 0&& flowerbed[flowerbed.length-2]==0){
				n--;
			}
		}
		if(n <= 0){
			return true;
		}
		
		
		return flag;
		
		
        
    }
	public boolean checkPossibility(int[] nums) {
		boolean flag = false;
		int left = nums[0];
		int count = 0;
		for (int j = 1; j < nums.length - 1; j++) {
			if(left > nums[j]){
				count++;
				if(count>=2){
					return false;
				}
				if(left > nums[j+1]){
					nums[j+1] = nums[j];
				}else {
					nums[j+1] = nums[j];
				}
				
				
			}
			
		}
		return flag;
    }
	public boolean isAlienSorted(String[] words, String order) {
		for (int i = 1; i < words.length; i++) {
			if(!cmp(words[i-1], words[i], order)){
				return false;
			}
		}
		return true;
        
    }
	public static int findUnsortedSubarray(int[] nums) {
		
		int nums2[] = Arrays.copyOf(nums, nums.length);
		//对复制的nums2进行排序
		
		Arrays.sort(nums2);
		
		
		int start = 0;
		int end = nums.length -1;
		for (int i = 0; i < nums2.length -1; i++) {
			if(nums[i] == nums2[i]){
				start ++;
			}else {
				break;
			}
			
		}
		for (int i = nums2.length -1 ; i >=0; i--) {
			if(nums[i] == nums2[i]){
				end --;
				if(end<=start ){
					return 0;
				}
			}else {
				break;
			}
		}
		return end - start +1;
		
        
    }
	public static boolean cmp(String word1,String word2, String order){
		int len = Math.min(word1.length(), word2.length());
		for (int i = 0; i < len ; i++) {
			if(order.indexOf(word1.charAt(i)) < order.indexOf(word2.charAt(i))){
				return true;
			}else if (order.indexOf(word1.charAt(i)) > order.indexOf(word2.charAt(i))) {
				return false;
			}
		}
		if(word1.length() > word2.length()){
			return false;
		}else {
			return true;
		}
	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if(nums1.length == 0){
			return new int[0];
		}
		int max = nums2[0];
		for (int i = 1; i < nums2.length; i++) {
			max = Math.max(nums2[i], max);			
		}
		int tem[] = new int[max + 1];
		int re[] = new int[nums1.length];
		for (int i = 0; i < tem.length; i++) {
			tem[i] = -1;			
		}
		for (int i = 0; i < nums2.length; i++) {
			for (int j = i+1; j < nums2.length; j++) {
				if(nums2[j] > nums2[i]){
					tem[nums2[i]] = nums2[j];
					break;
				}
				
			}
			
		}
		
		for (int i = 0; i < re.length; i++) {
			re[i] = tem[nums1[i]];			
		}
		return re;
		
        
    }

	public static String[] findWords(String[] words) {
		List<String> list = new ArrayList<>();
		int size = 0;
		String tem[] = {"qwertyuiop","asdfghjkl","zxcvbnm"};
		
		for (int i = 0; i < words.length; i++) {
			//全部转成小写
			String word = words[i].toLowerCase();
			
			if(word.length() == 0){
				continue;
			}
			//判断第一个字符在哪一行中
			char start = word.charAt(0);
			int x = tem[0].indexOf(start);
			int y = tem[1].indexOf(start);
			if(x != -1){
				if(conti(0, word)){
					list.add(words[i]);
				}
			}else if ( y != -1) {
				if(conti(1, word)){
					list.add(words[i]);
				}
			}else {
				if(conti(2, word)){
					list.add(words[i]);
				}
				
			}
			
		}
		String [] result = new String[list.size()];
		for (String string : list) {
			result[size ++] = string;
		}
		System.out.println(Arrays.toString(result));;
		return result;
        
    }
	
	public static boolean conti(int i,String word){
		String tem[] = {"qwertyuiop","asdfghjkl","zxcvbnm"};
		int j = 0;
		for ( ; j < word.length(); j++) {
			if(tem[i].indexOf(word.charAt(j)) == -1){
				break;
			}
		}
		if(j == word.length())
			return true;
		else {
			return false;
		}
		
	}
	public static int[]  findMode(TreeNode root) {
		
		
		HashMap<Integer, Integer> tem = new HashMap<>();
		findMode(root,tem);	
		int max = 0;
		for (int iterable_element : tem.values()) {
			System.out.println(iterable_element);
			if(max < iterable_element){
				max = iterable_element;
			}
			
		}
		int i = 0;
		System.out.println("max" + max);
		for (int key : tem.keySet()) {
			
			if(max == tem.get(key)){
				i++;
			}
		}
		int resut[] = new int[i];
		int k = 0;
		for (int key : tem.keySet()) {
			if(max == tem.get(key)){
				resut[k++] = key;
			}
		}
		return resut;
		
		
		
		
        
    }
	
	public static  void findMode(TreeNode root,HashMap<Integer, Integer>s) {
		if(root == null){
			return ;
		}else {
			s.put(root.val, s.getOrDefault(root.val, 0) + 1);
			findMode(root.right,s);
			findMode(root.left,s);
		}
		
        
    }
	
	
	public boolean detectCapitalUse(String word) {
		if(word.length() == 1 || word.length() == 0){
			return true;
		}
		
		
		char []tem = word.toCharArray();
		if(Character.isUpperCase(tem[0])){
			//以大写开头
			if(word.length() == 2){
				return true;
			}else {
				//第二个字母是大写，那么后面都必须是大写
				if(Character.isUpperCase(tem[1])){
					for (int i = 2; i < tem.length; i++) {
					  char c = tem[i];
					  if(!Character.isUpperCase(c)){
						  return false;
						  
					  }
			     	}
					return true;
				}else {
					//如果第二个字母是小写那么后面都是小写
					for (int i = 2; i < tem.length; i++) {
						char c = tem[i];
						if(Character.isUpperCase(c)){
							  return false;
							  
						  }
				     }
					return true;
				}
			}
			
			
		}else {
			//以小写开头
			for (char c : tem) {
				if(Character.isUpperCase(c)){
					return false;
				}
			}
			return true;
			
		}
		
        
    }
	
	
	
	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		if(buckets == 1 || buckets == 0){
			return 0;
		}
		int j = 1 + minutesToTest / minutesToDie;
		System.out.println("j"+ j);
		int count = 0;
		while (buckets > Math.pow(j, count)) {
			count++;
		}
		
		
		
        return count;
    }
	
	
	public static boolean repeatedSubstringPattern(String s) {
	/*	if(s.length() == 1 || s.length() == 0)
			return false;
		
		
		int []tem = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			tem[i] = s.charAt(i) - 97;		
		}
		
		int start = 0;
		int step = 1;
		int end = 1;
		boolean flag = true;
		while(true){
			flag = true;
			end = start +step;
			for (int i = end; i < tem.length; i+=step) {
				start = 0;
				for (int j = 0; j < step; j++) {
					if(end + j >= tem.length ){
						flag = false;
						break;
					}
						
					if(tem[start] != tem[end +j ]){
						flag = false;
						break;
					}else {
						start ++;
					}
					
				}
				if(!flag){
					break;
				}else {
					
				}
			}
			if(flag){
				return true;
			}

			step ++;
			if(step == s.length()){
				break;
			}
			
			
		}
		
		
		
		
		return false;
		*/
		if(s.length() == 1 || s.length() == 0)
			return false;
		boolean result = false;
		int start = 0;
		int step = 1;
		int end = 1;
		if(s.length() % 2 == 0){
			if(s.substring(0, s.length() /2 ).equals(s.substring(s.length()/2))){
				return true;
			}
		}
		
		
		while (true) {
	//		System.out.println("step" + step);
			end = start + step;
			String tem1 = s.substring(0, end);
		//	System.out.println("前者在前面"+tem1);
			int i = end;
			result = true;
			if(tem1.equals(s.substring(i))){
				return true;
			}else {
				
			}
			if(s.length() % step ==0){

				for (i = end; i + step <= s.length(); i +=step ) {
					String tem2 = s.substring(i,i + step);
			//		System.out.println("前者"+tem1);
			//		System.out.println("后者"+tem2);
					if(!tem2.equals(tem1)){
				//		System.out.println("bud");
						result = false;
						break;
					}else {
						continue;
					}
					
				}
			
				if(result && i == s.length()){
					return true;
				}
				
				step++;
				if(step >= s.length())
					return false;
			}else {
				step++;
			}
			
		
			
		}
		
		
		
		
	
		
		
        
    }
	public  static boolean checkPerfectNumber(int num) {
		if(num == 1 || num == 0){
			return false;
		}
		if(num == 2 || num == 3 || num == 4){
			return false;
		}
		int tem = num * 2;
		for (int i = 1; i * i < num ; i++) {
			if(num % i == 0){
				int j = num / i;
				tem = tem - j - i;
				
				if(tem < 0  ){
					break;
				}
				
			}
		}
		if(tem == 0){
			return true;
		}else {
			return false; 
		}
    }
	public static int findContentChildren(int[] g, int[] s) {
		if(s.length == 0 || g.length == 0){
			return 0;
		}
		
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		int j = 0;
		for (int i = 0; i < g.length; i++) {
			if(g[i] > s[j]){
				j++;
				i--;
				if(j == s.length){
					break;
				}
			}else {
				count ++;
				j++;
				if(j == s.length){
					break;
				}
			}
			
		}
		return count;
		 
    }
	 public static String[] findRelativeRanks(int[] nums) {
		 String []result = new String[nums.length];
		 String tyemString[] = { "Gold Medal", "Silver Medal", "Bronze Medal"};
		 
		 for (int i = 0; i < nums.length; i++) {
			int string = nums[i];
			int count = nums.length;
			
			for (int j = 0; j < nums.length ; j++) {
				if(j == i){
					
				}else {
					if(string > nums[j]){
						count--;
					}
				}
			}
			if(count <= 3){
				result[i] = tyemString[count-1];
			}else {
				result[i] = (count) + "";
			}
			
		}
		 return result;
	 }
	
	public static boolean isPerfectSquare(int num) {
		
		
		int sum = 1;
		
		while (num > 0) {
			num -= sum;
			sum +=2;
			
		}
		return num == 0;
    }
	
	
	
	public static boolean canWinNim(int n) {
		
		
		return n % 4 ==0;
		
		
        
    }
	
	
	public boolean wordPattern(String pattern, String str) {
			String []s = str.split(" ");
			Map<Character, String> ha = new HashMap<>();
			if(s.length != pattern.length()){
				return false;
			}
			for (int i = 0; i < pattern.length(); i++) {
				if(ha.get(pattern.charAt(i)) == null){
					if(ha.containsValue(s[i])){
						return false;
					}
					ha.put(pattern.charAt(i), s[i]);
				}else {
					if(ha.get(pattern.charAt(i)).equals(s[i])){
						;
					}else {
						return false;
					}
				}
				
			}
			return true;
    }
	
	
	
	public void push(int x){
		int size = stack.size();
		
		stack.offer(x);
		for (int i = 0; i < size; i++) {
			int num = stack.poll();
			stack.offer(num);
			
		}
		
		
		
	}
	public int pop(){
		if(stack.isEmpty())
			return 0;
		
		return stack.poll();
	}
	public boolean ise(){
		return stack.isEmpty();
	}
	
	public int getpop(){
		if(stack.isEmpty())
			return 0;
		
		return stack.peek();
	}
	

	public static boolean containsDuplicate(int[] nums) {
		boolean flag = false;
		if(nums.length == 1 || nums.length == 0 ){
			return flag;
		}else {
			if(nums.length == 2){
				if(nums[0] == nums[1]){
					return true;
				}else {
					return flag;
				}
			}else {
				HashMap<Integer, Integer> map = new HashMap<>();
				for (int i = 0; i < nums.length; i++) {
					if(map.get(nums[i]) == null){
						map.put(nums[i], 1);
					}else {
						return true;
					}
				}
				return false;
				 /*for(int key:map.keySet()){
					 
					 if(map.get(key) >= 2){
						 return true;
					 }
				 
				 }
				 return false;
				*/
			}
		}
		
		
		
		
        
    }
	
	public static boolean isIsomorphic(String s , String t) {
		int aTob[] = new int[256];//s到t的映射
        int bToa[] = new int[256];;//t到s的映射
        int len = s.length();

        for(int i =0; i<len; ++i)
        {
            if(aTob[s.charAt(i)] == 0)
                aTob[s.charAt(i)] = t.charAt(i);//初始化aTob
            if(bToa[t.charAt(i)] == 0)
                bToa[t.charAt(i)] = s.charAt(i);//初始化bToa
            if(aTob[s.charAt(i)] != t.charAt(i) ||
               bToa[t.charAt(i)] != s.charAt(i))
                    return false;
        }
        return true;

	/*	if(s.length() != t.length()){
			return false;
		}else {
			HashMap<Character,Character> hash = new HashMap<>();
			if(s.length() == 0 || s == ""){
				return true;
			}
			
			hash.put(s.charAt(0), t.charAt(0));
			boolean fa = true;
			for (int i = 1; i < s.length(); i++) {
				if(hash.get(s.charAt(i)) ==null ){
					if(hash.containsValue(t.charAt(i))){
						fa = false;
						break;
					}else {
						hash.put(s.charAt(i), t.charAt(i));
					}
				}else  {
					if(hash.get(s.charAt(i)) !=t.charAt(i)){
						 fa = false;
						break;
					}
				}
				
			}
			return fa;
		}*/
        
    }
	
	public static int countPrimes(int n) {
		   if (n <= 1) {
	            return 0;
	        }
	        //默认为false
	        boolean[] isPrime=new boolean[n];
	        isPrime[0]=true;
	        isPrime[1]=true;
	        //从2开始
	        for (int i=2;i*i<n;i++){
	            if (!isPrime[i]) {
	            	
	            	//倍数的都不是质数
	                for (int j = i * 2; j < n; j += i) {
	                    isPrime[j] = true;
	                }
	            }
	        }

	        //统计质数个数
	        int result=0;
	        for (boolean b:isPrime){
	            if (!b){
	                result++;
	            }
	        }

	        return result;
		
		
		/*if(n == 0 || n == 1 || n == 2){
			return 0;
		}else if(n == 3){
			return 1;
		}else {
			int sum = 0;
			for (int i = 5; i < n; i+=2) {
				boolean falg = true;
				int a = (int)Math.sqrt(i);
				for(int i1 = 2; i1 <= a ; i1++){
					if(i1 % 2 == 0){
						falg =  false;
						break;
					}
					
					if(i % i1 == 0){
						falg =  false;
						break;
					}
				}
				if(falg){
				//	System.out.println("质数为："+i);
					sum ++;
					
				}
		}
			return sum+2 ;
			}
*/
		
		
        
    }
	
	
	
	
	public static void rotate(int[] nums, int k) {
		int i = k % nums.length;
		int []nums2 = new int[nums.length];
		for (int j = 0; j < nums2.length; j++) {
			nums2[j] = nums[j];
		}
		if(i == 0){
			System.out.println("fda"+Arrays.toString(nums));
			return;
		}else {
			System.out.println("==========");
			int j = nums.length-1;
			int k1 = nums.length - i- 1;			
			while (k1 >= 0) {
				int a = nums[j];
				nums[j] = nums[k1];		
				nums[k1]=a;
				j--;				
				k1--;
			}	
			System.out.println("nums2"+Arrays.toString(nums2));
			System.out.println("nums"+Arrays.toString(nums));
			for (int l = 0; l < i; l++) {
				nums[l] = nums2[nums.length-i+l];
			}
			System.out.println(Arrays.toString(nums));
		}
		 
    }
	
	
	public static int fac(int n) {
		if(n ==1){
			return 1;
		}else {
			return n*fac(n-1);
		}
	
	}
	public static int trailingZeroes(int n) {
		
		
		int sum = 0;
		while (n > 0) {
			sum += n/5;
			n/=5;
		}
		return sum;
	   
    }
	
	public static int titleToNumber(String s) {
		
	
		
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i)-'A'+1;
            sum = sum*26+temp;
		}
		return sum;	
    }
	
	
	
	public static int majorityElement(int[] nums) {
		
		
		int count = 1;
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(max == nums[i]){
				count ++;
			}else {
	
				count --;
				if(count == 0){
					max = nums[i];
					count++;
				}
			}
		}
		
		
		
		return max;
        
    }
	
	
	
	public static String convertToTitle(int n) {
		Map<Integer, String> hash = new HashMap<>();
		hash.put(1, "A");
		hash.put(2, "B");
		hash.put(3, "C");
		hash.put(4, "D");
		hash.put(5, "E");
		hash.put(6, "F");
		hash.put(7, "G");
		hash.put(8, "H");
		hash.put(9, "I");
		hash.put(10, "J");
		hash.put(11, "K");
		hash.put(12, "L");
		hash.put(13, "M");
		hash.put(14, "N");
		hash.put(15, "O");
		hash.put(16, "P");
		hash.put(17, "Q");
		hash.put(18, "R");
		hash.put(19, "S");
		hash.put(20, "T");
		hash.put(21, "U");
		hash.put(22, "V");
		hash.put(23, "W");
		hash.put(24, "X");
		hash.put(25, "Y");
		hash.put(26, "Z");
		int i = n / 26;
		int j = n % 26;
		
	
		if(j == 0){
			j = 26;
			i --;
		}
		String target = hash.get(j);
		StringBuilder tarBuilder = new StringBuilder(target);
		while (i != 0) {
			j = i % 26;
			i = i / 26;
		
			if(j == 0){
				i --;
				j = 26;
				
			}
			
			String target1 = hash.get(j);
			StringBuilder tarBuilder1 = new StringBuilder(target);
			tarBuilder.append(target1);
		}
		String s1 = tarBuilder.reverse().toString();
		
		return s1;
		
		
		
        
    }

	public static boolean hasCycle(ListNode head) {
	       ListNode head1 = head;
			ListNode head2 = head;
			while (head1 != null && head2.next != null) {
				head1 = head1.next;
				head2 = head2.next.next;
				if(head1 == head2){
					return true;
				}
	            if(head2 == null){
	                return false;
	            }
			}
			return false;
	    }
	
	public static  boolean isPalindrome(String s) {
       
        StringBuilder sb = new StringBuilder(s);
        //得到的是反转之后的
        String s1 = new String(sb.reverse());
       //去除空格
        String s3 = s1.replace(" ", "").replace(",", "").replace(".", "");
        System.out.println("反转之后  "+s3);
        String s4 = s.replace(" ", "").replace(" ", "").replace(".", "").replace(";", "");
        System.out.println("去除空格之后   "+s4);
        
        if(s3.equalsIgnoreCase(s.replace(" ", ""))){
        	return true;
        }else {
			return false;
		}
        
    }

	public static int maxProfit2(int[] prices) {
		int max = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] > prices[i-1]){
				max +=  prices[i] - prices[i-1];
			}	
		}
		return max;
	}

	public static int maxProfit(int[] prices) {
		
		int max = 0;
		
		
		if(prices == null || prices.length == 0){
			return 0;
		}else {
			int min = prices[0];
			
			for(int j = 1; j < prices.length; j++){
				if(prices[j] < min){
					min = prices[j];
				}else if(prices[j] - min > max){
					max = prices[j] - min;
				}
			
			
			}
		}
		
		return max;
		
		
		
		
		
		
		
		
     /*   int max = 0;
        for(int i = 0; i < prices.length-1; i++){
        	for (int j = i+1; j < prices.length; j++) {
				if(prices[j]- prices[i] > max){
					max = prices[j]- prices[i];
				}
			}
        }
        return max;
		*/
		
		
		
    }
	
	public static List<Integer> getRow(int rowIndex) {
        /*List<Integer> target = new ArrayList<>();
        
        
        return target;*/
		List<List<Integer>> target = new ArrayList<>();
        for(int i = 1; i <= rowIndex + 1; i++){
        	List<Integer> mid = new ArrayList<>();
        	for(int j = 1; j <= i; j++){
        		if(j == 1 || j == i){
        			mid.add(1);
        		}else {
        		
					mid.add(target.get(i-2).get(j-2)+target.get(i-2).get(j-1));
				}
        	}
        	
        	target.add(mid);	        
        }
     
        return target.get(rowIndex);
    }
	
	public static int[] get1(int []num, int target){
		
		boolean flag = false;
		int s[] = new int[2];
		for(int i = 0; i < num.length; i++){
			flag = false;
			int target1 = target - num[i];
			for(int j = 0; j < num.length; j++){
				if(j != i){
				    if(target1 == num[j]){
				    	flag = true;
				    	s[0] = i;
				    	s[1] = j;

				    }
				    	
				    	
				}
				if(flag)
					break;
			}
			if(flag)
				break;
		}
		System.out.println(s);
		return s;
		
	}
	
	public static boolean is(int x){
		
		if (x < 0 || (x != 0 && x % 10 == 0)) { //x是10的倍数一定不是回文串
            return false;
        }
        int s = 0;
        while (s <= x) {
            s = s * 10 + x % 10;
            if (s == x || s == x / 10) { //分别处理整数长度是奇数或者偶数的情况
                return true;
            }
            x /= 10;
        }
        return false;
		
		
		
		
	}

}
