package cn.xwb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.sound.midi.MidiChannel;
import javax.swing.border.Border;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
import javax.xml.transform.Templates;


@SuppressWarnings("all")
class Solution {
	@SuppressWarnings("all")
	int resultid = 0;
    public int totalNQueens(int n) {
        gets(0, 0, 0, 0, 0);
    	return resultid;
    }
    
    
    
    
    
    public void gets(int row,int n,int col,int pei,int na){
    	if(row == n){
    		resultid ++;
    		return ;
    	}
    	int bits = (~(col | pei | na) & ((1 << n) - 1));
    	while (bits != 0) {
			int ges = bits & (-bits);
			gets(row + 1, n, col | ges, (pei | ges) << 1, (na | ges) >> 1);
    		
    		bits = bits & (bits - 1);
		}
    	
    }
    
}
@SuppressWarnings("all")
public class LeetMed {
	public static void main(String[] args) {
		
		System.out.println((int)('9' - '0'));
		System.out.println(Arrays.toString("1+1".split("\\+")));
	}
	
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed.length == 0 && popped.length == 0){
			return true;
		}
		if (pushed.length != popped.length) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int indexi = 0;
		int indexj = 0;
		while (true) {
			System.out.println(stack);
			if(stack.isEmpty()){
				stack.push(pushed[indexi++]);
			}else {
				if(stack.peek() == popped[indexj ++]){
					stack.pop();
				}else {
					stack.push(pushed[indexi++]);
				}
				if(indexj == pushed.length){
					return true;
				}
				if( indexi == popped.length){
					break;
				}
			}
			
		}
		
		System.out.println(stack);
		System.out.println(indexj);
		while (indexj < popped.length ) {
			if(stack.isEmpty() || popped[indexj ++] != stack.peek()){
				return false;
			}
			stack.pop();
		}
 		
		return false;
        
    }	
	
	
	
	
	
	
	
	
	public String complexNumberMultiply(String a, String b) {
		String data1[] = a.split("\\+");
		System.out.println(Arrays.toString(data1));
		String data2[] = b.split("\\+");
		System.out.println(Arrays.toString(data2));
		int datai = Integer.parseInt(data1[0]);
		int dataj = Integer.parseInt(data1[1].replace("i", ""));
	
		int dataa = Integer.parseInt(data2[0]);
		int datab = Integer.parseInt(data2[1].replace("i", ""));
		
		int i = datai * dataa - dataj * datab;
		int j = datai * datab + dataj * dataa;
 		
		
		return i + "+" + j + "i"; 
		
        
    }
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<int[] > list = new ArrayList<>();
        for (int[] is : prerequisites) {
			list.add(is);
		}
        Collections.sort(list,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] - o2[0] != 0){
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
     
        int visited[] = new int[numCourses];        
       
        for (int i = 0; i < visited.length; i++) {
			visited[i] = i;
        }
        
        for (int[] is : list) {
        	   System.out.println(Arrays.toString(is));
//        	   将暂时不能上的课表示在is
        	  visited[is[0]]  = is[1];
		}
        while (true) {
			
        	for (int i = 0; i < visited.length; i++) {
//        		说明可以上
				if(visited[i] == i){
					numCourses --;
				}else {
//					说明有前序课程
					if(isget(visited, i, visited[i])){
						visited[i] = i;
					}else {
						return false;
					}
				}
			}
        	break;
		}
        return true;
    }
//	i表示的是要完成的课程，j表示的需要在i之前的课程
	
	public boolean isget(int visited[],int i,int j){
		if(visited[j] == j){
			return true;
		}
		if(i == j){
			return false;
		}else {
			return isget(visited, i, visited[j]);
		}
	}
	 public int[] beautifulArray(int N) {
	        
	        if(N==1){
	            return new int[]{1};
	        }
	        
	        int[] even = beautifulArray(N/2);//[1-N]中的偶数构成的漂亮数组
	        int[] odd = beautifulArray((N+1)/2);//[1-N]中的奇数构成的漂亮数组
	        System.out.println(Arrays.toString(even));
	        System.out.println(Arrays.toString(odd));
	        
	        int[] beautiful = new int[N];
	        for(int i = 0;i<even.length;i++){
	            beautiful[i] = even[i]*2;
	        } 
	        for(int i = 0;i<odd.length;i++){
	            beautiful[i+even.length] = odd[i]*2-1;
	        } 
	        System.out.println(Arrays.toString(beautiful));
	        return beautiful;
	    }

	
	
	public int rand10() {
		int a = rand10();
		int b = rand10();
		while (a + (b - 1) * 7 > 40) {
			a = rand10();
			b = rand10();
		}
		return 1 + a + (b - 1) * 7 % 10;
        
    }
	
	public void Solution(int[] w) {
        
    }
    
    public int pickIndex() {
        return 0;
    }
	
	
	public int countNumbersWithUniqueDigits(int n) {
		
		
		
		
		int dp[] = new int[n + 1];
	
		dp[0] = 1;
		dp[1] = 10;
		dp[2] = 81;
		if(n >= 10){
			n = 10;
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] * (11 - i);
		}
		int sum = 0;
		for (int i : dp) {
			sum += i;
		}
        return sum;
    }
	public void calc(List<String>cunfang,int n,
			int lenght,String tem,boolean visited[]){
		if(lenght == n){
			if(tem.charAt(0) != '0' || lenght == 1){
				cunfang.add(tem);
			}
			return ;
		}
		for (int i = 0; i <= 9; i++) {
			if(!visited[i]){
				visited[i] = true;
				calc(cunfang, n + 1, lenght, tem + i + "", visited);
				visited[i] = false;
			}
		}
	}
	
	
	
	
	public int flipLights(int n, int m) {
		if(m == 0 || n == 0){
			return 1;
		}
		n = Math.min(3, n);
		if(n < 3){
			if(n == 1){
				return 2;
			}else {
//				n等于2
				if(m == 1){
					return 3;
				}else {
					return 4;
				}
			}
			
			
		}else {
			if(m == 1){
				return 4;
				
			}else if (m == 2) {
				return 7;
			}else {
				return 8;
			}
			
			
		}
        
    }
	@SuppressWarnings("all")
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
//	    使用并查集进行操作
		double map[][] = new double[26][26];
//		map表示的是i/j的值那么很明显等于j/i的倒数
		Map<String, Integer> map2 = new HashMap<>();
		double[] result = new double[queries.length];
//		记录下标
		for (int i = 0; i < equations[0].length; i++) {
			System.out.println(equations[i]);
			String t1 = equations[i][0];
			String t2 = equations[i][1];
			int index1 = Integer.valueOf(t1.charAt(0));
			int index2 = Integer.valueOf(t1.charAt(2));
			map[index1][index1] = 1;
			map[index2][index2] = 1;
			map[index1][index2] = values[i];
			map[index2][index1] = 1 / values[i];
		}
		for (double[] d : map) {
			System.out.println(Arrays.toString(d));
		}
//		合并
		
		
		return result;
	}
	
	  public int findDuplicate(int[] nums) {
		  int fast = nums[nums[0]];
		  int slow = nums[0];
		  while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if(fast == slow){
				fast = 0;
				while(fast != slow){
					fast = nums[fast];
					slow = nums[slow];
				}
				return fast;
			}
		}
		  
		  
		  
		  
	  
	   }


//		顺时针打印
		public List<Integer> spiralOrder(int[][] matrix) {
			
	        List<Integer> result = new ArrayList<>();
	        if (matrix.length == 0 ){
				return result;
			}
	        int leftup[] = {0,0};
	        int rightup[] = {0,matrix[0].length - 1}; 
	        
	        int leftdown[] = {matrix.length - 1,0};
	        int rightdown[] = {matrix.length - 1,matrix[0].length - 1}; 
	  
	        int size = matrix.length * matrix[0].length;
	        while (true) {
	            
//	          右走
	         if(leftup[1] <= rightup[1]){
	        	 for (int i = leftup[1]; i <= rightup[1]; i++) {
	       			result.add(matrix[leftup[0]][i]);
	       			
	       			}
	        	 leftup[0] ++;
	             rightup[0] ++;
	         }
	          
	          if(size == result.size()){
	        	  break;
	          }
//	          下走
	          if(rightup[0] <= rightdown[0]){
	        	  for (int i = rightup[0]; i <= rightdown[0]; i++) {
	        			result.add(matrix[i][rightdown[1]]);
	        			}
	                
	                rightup[1] --;
	                rightdown[1]--;
	          }
	          if(size == result.size()){
	        	  break;
	          }
//	          左走
	          
	        if(rightdown[1]>= leftdown[1]){
	        	
	        	for (int i = rightdown[1]; i >= leftdown[1]; i--) {
	        		result.add(matrix[leftdown[0]][i]);
	        	}
	        	leftdown[0]--;
	        	rightdown[0]--;
	        }
	        if(size == result.size()){
	      	  break;
	        }
//	        上走
	        if(leftdown[0] >= leftup[0]){
	        	
	        	for (int i = leftdown[0]; i >= leftup[0]; i--) {
	        		result.add(matrix[i][leftup[1]]);
	        	}
	        	
	        	leftup[1] ++;
	        	leftdown[1] ++;
	        }
	          if(size == result.size()){
	        	  break;
	          }
	          System.out.println(result.toString());
			}
	      
	      
	      
	        return result;
	    }
		
		
	  public int[][] generateMatrix(int n) {
	        int [][] result = new int[n][n];
	        
	        
	        int leftup[] = {0,0};
	        int rightup[] = {0,n - 1}; 
	        
	        int leftdown[] = {n - 1,0};
	        int rightdown[] = {n - 1,n - 1}; 
	  
	        int size = n * n + 1;
	        int tem = 1;
	        while (true) {
	            
//	          右走
	         if(leftup[1] <= rightup[1]){
	        	 for (int i = leftup[1]; i <= rightup[1]; i++) {
//	       			result.add(matrix[leftup[0]][i]);
	       			result[leftup[0]][i] = tem ++;
	       			
	       			}
	        	 leftup[0] ++;
	             rightup[0] ++;
	         }
	          
	          if(size == tem){
	        	  break;
	          }
//	          下走
	          if(rightup[0] <= rightdown[0]){
	        	  for (int i = rightup[0]; i <= rightdown[0]; i++) {
//	        			result.add(matrix[i][rightdown[1]]);
	        			result[i][rightdown[1]] = tem ++;
	        			}
	                
	                rightup[1] --;
	                rightdown[1]--;
	          }
	          if(size == tem){
	        	  break;
	          }
//	          左走
	          
	        if(rightdown[1]>= leftdown[1]){
	        	
	        	for (int i = rightdown[1]; i >= leftdown[1]; i--) {
//	        		result.add(matrix[leftdown[0]][i]);
	        		result[leftdown[0]][i] = tem ++;
	        	}
	        	leftdown[0]--;
	        	rightdown[0]--;
	        }
	        if(size == tem){
	      	  break;
	        }
//	        上走
	        if(leftdown[0] >= leftup[0]){
	        	
	        	for (int i = leftdown[0]; i >= leftup[0]; i--) {
//	        		result.add(matrix[i][leftup[1]]);
	        		result[i][leftup[1]] = tem ++;
	        	}
	        	
	        	leftup[1] ++;
	        	leftdown[1] ++;
	        }
	          if(size == tem){
	        	  break;
	          }
	         
			}
	        
	        
	        return result;
	    }
	
	  public int leastBricks(List<List<Integer>> wall) {
		  int max = 0;
		  List<Integer> list = wall.get(0);
			for (Integer integer : list) {
				max += integer;
			}
			if(max == 1){
				return wall.size();
			}
			
			
	     Map<Integer, Integer> dp= new HashMap<>();
	     
//	     对于每一行都进行遍历
	     for (int j = 0; j < wall.size(); j++) {
	    	 int sum = 0;
	    	for (int i = 0; i < wall.get(j).size() - 1; i++) {
				sum += wall.get(j).get(i);
				dp.put(sum, dp.getOrDefault(sum, 0) + 1);
			}
		}
	     
	
//		对于每一列都进行取出最小值
	     int min = Integer.MIN_VALUE;
	     
	     for (Entry<Integer, Integer> integer : dp.entrySet()) {
			min = Math.max(integer.getValue(), min);
		}

	     
	     
	     
	     
	   return wall.size() - min;
	  
	  
	  }
	  public void solve(char[][] board) {
		    if(board.length == 0 || board[0].length == 0){
					return ;
				}
		    int row = board.length;
		    int col = board[0].length;
		    
			for (int i = 0; i < row; i++) {
				dfsd(i, 0, board);
				dfsd(i, col - 1, board);
				
			}
			
			for (int i = 0; i < col; i++) {
				dfsd(0, i, board);
				dfsd(row - 1, i, board);
			}	
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if(board[i][j] == '-'){
						board[i][j] = 'O';
					}else if(board[i][j] == 'O'){
						board[i][j] = 'X';
					}
				}
			}
	  }
	
	public void dfsd(int row,int col,char[][] board){
		if(row >= 0 && row < board.length && col >= 0 &&
				col < board[0].length && board[row][col] == 'O'){
			board[row][col] = '-';
			dfsd(row - 1, col, board);
			dfsd(row + 1, col, board);
			dfsd(row, col + 1, board);
			dfsd(row, col - 1, board);
		}
		
		
	}
	  
	  
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int result = 0;
//        计算不使用大礼包的情况
        for (int i = 0; i < needs.size(); i++) {
			result += needs.get(i) * price.get(i);
		}
//        计算使用大礼包的情况,对于每个礼包都需要进行尝试
        
        for (List<Integer> integer : special) {
			if(isvalid(needs, integer)){
				List<Integer> newneeds = new ArrayList<>();
				for (int i = 0; i < needs.size(); i++) {
					newneeds.add(needs.get(i) - integer.get(i));
				}
				int gets = shoppingOffers(price, special, newneeds);
				result = Math.min(result, gets + integer.get(integer.size() - 1));
			}
		}
        
        return result;
        
        
		
    }
	public boolean isvalid(List<Integer> newNeeds,List<Integer> gift){

		for (int i = 0; i < newNeeds.size(); i++) {
			if(newNeeds.get(i) < gift.get(i)){
				return false;
			}
		}

		
		return true;
		
		
	}
	
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode tem = root;
		while ((tem.left != null && tem.val > val)
				|| (tem.right != null && tem.val < val)
				) {
			if(tem.val < val){
				tem = tem.right;
			}else {
				tem = tem.left;
			}
			
			
		}
		if(tem.left == null && tem.val > val){
			tem.left = new TreeNode(val);
		}
		else if(tem.right == null && tem.val < val){
			tem.right = new TreeNode(val);
		}
		return root;
        
    }
	
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null){
			return null;
		}
		
		if(head.next == null){
			return new TreeNode(head.val);
		}
		ListNode low = head;
		ListNode fast = head;
		ListNode pre = head;
		while (fast != null && fast.next != null) {
			pre = low;
			low = low.next;
			fast = fast.next.next;
		}
		pre.next = null;
		TreeNode head1 = new TreeNode(low.val);
		head1.left = sortedListToBST(head);
		head1.right = sortedListToBST(low);
		
		
		
		
		
		return head1;
        
    }
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode head1 = head;
        ListNode pre = null;
        int jianju = n - m;
        ListNode first = head;
        if(m == 1){
        	first = head;
        	pre = null;
        }else {
        	pre = head;
			while (m -- > 1) {
				first = first.next;
				if(m == 1){
					
				}else {
					pre = pre.next;
				}
			}
		}
        ListNode last = first;
        while (jianju --  > 0 ) {
			last = last.next;
		}
        
     
        ListNode lastlast = last.next;
        ListNode pre1 = null;
        ListNode pre2 = first;
        while (first != last) {
        	System.out.println(first.val);
			ListNode tem = first.next;
			first.next = pre1;
			pre1 = first;
			first = tem;
		}
        first.next = pre1;
        if(pre != null){
        	pre.next = first;
        }else {
			head1 = first;
		}
        pre2.next = lastlast;
       
        return head1;
    }
/*	public int findDuplicate(int[] nums) {
		int dp[] = new int[nums.length  +1];
		for (int i : nums) {
			dp[i] ++;
			if(dp[i] > 1){
				return i;
			}
		}
		return 0;
		
		
		Map<Integer,Integer> tem = new HashMap<>();
		for (int i : nums) {
			tem.put(i, tem.getOrDefault(i, 0) + 1);
			if(tem.get(i) > 1){
				return i;
			}
		}
		return 0;
    }*/
	
	
	
	
	@SuppressWarnings("all")
	public int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
		int maxcol = triangle.get(row - 1).size();
		
		
		int dp[] = new int[row];
		
		List<Integer> first = triangle.get(0);
		dp[0] = first.get(0);
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> tem = triangle.get(i);
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < tem.size(); j++) {
				if(j == 0) {
					min = dp[j];
				}else if(j == tem.size() - 1) {
					min = dp[j - 1];
				}else {
					min = Math.min(dp[j - 1], dp[j]);
				}
				System.out.println(min);
				dp[j] = min +tem.get(j);
			}
			
		}
		int max[] = dp;
		int result = max[0];
		for (int i : max) {
			result = Math.min(result, i);
		}
		
        return result;
    }
	
	
	public ListNode sortList(ListNode head) {
		List<ListNode> tem = new ArrayList<>();
		if(head == null || head.next == null){
			return head;
		}
		while (head != null) {
			tem.add(head);
			head = head.next;
		}
		Collections.sort(tem,new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO 自动生成的方法存根
				return o1.val - o2.val;
			}
		});
		ListNode head1 = new ListNode(-1);
		ListNode head2 = head1;
		
		for (ListNode listNode : tem) {
			ListNode tem1 = new ListNode(listNode.val);
			head1.next = tem1;
			tem1.next = null;
			head1 = tem1; 
		}
        return head2.next;
    }
	public ListNode oddEvenList(ListNode head) {
//		保存奇数节点
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		
		ListNode old = head;
		ListNode oushu = head.next;
		
		ListNode tem1 = old;
		ListNode tem2 = oushu;
		
		head = head.next.next;
		while (head != null ) {
			if(head.next == null){
				System.out.println(head.val);
				tem1.next = head;
				tem1 = head;
				break;
			}
			ListNode tem3 = head.next.next;
			tem1.next = head;
			tem2.next = head.next;
			
			tem1 = head;
			tem2 = head.next;
			
			head = tem3;
		}
		
		tem2.next = null;
		tem1.next = oushu;
	
		return old;
	        
	
	
	
	}
	
	
//	有问题的玩意
	public int coinChangeTanXin(int[] coins, int amount) {
		
		int result = 0;
		Arrays.sort(coins);
		if(result == 0){
			return 0;
		}
		for (int i = coins.length - 1; i >= 0; i--) {
			result = result + amount / coins[i];
			amount %= coins[i];
			
			
		}
		
		if(result == 0){
			return -1;
		}
		
		return result;
	}
	
	public int change2(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		Arrays.sort(coins);
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(coins[j] < i){
					dp[j] ++;
				}
			}
		}
		
		
		
		return dp[amount];
		
		
    }
//	递归会超时
	int coinsresult = 0;
	public int change(int amount, int[] coins) {
		String tem = "";
		if(amount == 0){
			return coinsresult;
		}
		Set<String> temSet = new LinkedHashSet<>();
		get(coins, amount,temSet,tem);
		return coinsresult;
    }
	public void get(int []coins,int shengyu,Set<String> set,String tem){
		if(shengyu < 0){
			return ;
		}
		if(shengyu == 0){
			char [] ges = tem.toCharArray();
			Arrays.sort(ges);
			tem = "";
			for (int i = 0; i < ges.length; i++) {
				tem += ges[i];
			}
			if (!set.contains(tem)){
				set.add(tem);
				
				coinsresult ++;
				System.out.println(tem.toString());
			}
			return;
		}
		for (int i = 0; i < coins.length; i++) {
			get(coins, shengyu - coins[i],set,tem + coins[i]);
		}
	}
	
	public int coinChange(int[] coins, int amount) {
		
//		使用动态规划
		int dp[] = new int[amount + 1];
		Arrays.sort(coins);
		if(amount == 0){
			return 0;
		}
		
		if(amount < coins[0]){
			return -1;
		}
		
		for (int i = 0; i < coins.length; i++) {
			if(coins[i] <= amount){
				dp[coins[i]] = 1;
			}else {
				break;
			}
		}
		
		if(dp[amount] != 0){
			return 1;
		}
		
		
		System.out.println(Arrays.toString(dp));
		for (int i = 1; i < dp.length; i++) {
			if(dp[i] == 0){
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < coins.length; j++) {
					if ( i - coins[j] > 0 && dp[i - coins[j]] > 0 &&  dp[i - coins[j]] != 0){
						min = Math.min(min, dp[i - coins[j]]);
					}
				}
				dp[i] = min + 1;
			}
		}
		
		System.out.println(Arrays.toString(dp));
		
		if(dp[amount] == 0 || dp[amount] == -2147483648){
			return -1;
		}else {
			return dp[amount];
		}
		
		
		
        
    }
	
	
	
	
	
	
	
	
	
	public int subarrayBitwiseORs(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
//		用一个dp[i]表示的是或之后的值
		int []dp = new int[A.length];
//		用map表示是否存在了或值，如果存在则不计数
		Map<Integer, Integer> map = new HashMap<>();
//		用result表示的计数，当然这里也可以直接返回map.size
		int result = 0;
		dp[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			int num = A[i];
			dp[i] = A[i];
			map.put(dp[i], dp[i]);
			for (int j = i - 1; j >= 0; j--) {
				int tem = dp[j] | num;
				if(tem == dp[j]){
					break;
				}
				dp[j] = tem;
				
				map.put(dp[j],dp[j]);
			}
			
			
		}
		
		
		return map.size();
        
    }
	
	
	public boolean isValidSudoku(char[][] board) {
//		记录每一行中的出现的数字
		boolean row[][] = new boolean[9][10];
//		记录每一列中出现的数字
		boolean col[][] = new boolean[9][10];
//		记录每一个九宫格中出现的数字
		boolean boar[][] = new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(board[i][j] != '.'){
					int x = (int)(board[i][j] - '0');
					if(row[i][x] || col[j][x] || boar[i / 3 * 3 + j / 3][x]){
						return false;
					}else {
						row[i][x] = true;
						col[j][x] = true;
						boar[i / 3 * 3 + j / 3][x] = true;
					}
				}
				
			}
		}
		
		
		return true;
        
    }
	public int findKthLargest(int[] nums, int k) {
//		使用优先级队列来进行操作
		Queue<Integer> tem = new PriorityQueue<>(k);
		for (int integer : nums) {
			if(tem.size() < k){
				tem.offer(integer);
			}else {
				if(tem.peek() < integer){
					tem.poll();
					tem.offer(integer);
				}
			}

			System.out.println(tem.toString());
		}
		return tem.remove();
        
    }
	
	//2019-3-29 14:32:05
	 public double myPow(double x, int n) {
	    double result = 0;
	    
	    
	    result = getsMyPow(x, Math.abs(n));
	    if(n < 0){
	    	result = (1.0) / result;
	    }
	    return result;
	 
	 
	 }
	 
	 public double getsMyPow(double x,int n){
		 if(n == 0){
			 return 1;
		 }
		 if(n == 1){
			 return x;
		 }
		 double tem = getsMyPow(x, n/2);
		 tem = tem * tem;
		 if((n & 1) == 1){
			 tem *= x;
		 }
		 System.out.println(tem);
		 return tem;
		 
		 
		 
	 }
	//2019年3月28日20:16:17
	public int sumNumbers(TreeNode root) {
		if(root == null){
			return 0;
		}
	    List<Integer> tem = new ArrayList<>();
	    
	    getSumNumbers(root, tem, 0);
	    System.out.println(tem.toString());
	    int sum = 0;
	    for (Integer integer : tem) {
			sum += integer;
		}
	    return sum;
	
	}
	public static void getSumNumbers(TreeNode root,List<Integer> tem,int tems){
		if(root.left == null && root.right == null){
			tem.add(tems);
			return ;
		}
		tems = tems * 10 + root.val;
		if(root.left != null){
			getSumNumbers(root.left, tem, tems);
		}
		if(root.right != null)
		getSumNumbers(root.right, tem, tems);
		
	}
	
	//2019年3月22日19:07:32
	public int removeStones(int[][] stones) {
        //使用并查集
		if(stones.length <= 1) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < stones.length; i++) {
			for (int j = i + 1; j < stones.length; j++) {
				if(map.get(i) == null){
					map.put(i, i);
				}
				if(map.get(j) == null){
					map.put(j, j);
				}
				if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
					Unio(j,Find(i, map),map);
				}
			}
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < stones.length; i++) {
			set.add(Find(i, map));
		}
		System.out.println(map.toString());
		return stones.length - set.size();
    }
	public static void Unio(int i,int j,Map<Integer, Integer> map){
		map.put(i, Find(j, map));
	}
	public static int Find(int i,Map<Integer, Integer> map){
		return map.get(i) == i? i:Find(map.get(i), map);
	}
	//2019年3月22日18:16:50
	public int numberOfArithmeticSlices(int[] A) {
        //思路：得到相同的长度的，然后从里面选择3,4,5,一直到其长度，
		if(A.length <= 2){
			return 0;
		}
		int chaju = A[1] - A[0];
		int jishu = 1;
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		boolean flag = false;
		for (int i = 2; i < A.length; i++) {
			if(A[i] - A[i-1] == chaju){
				jishu++;
				if(i == A.length - 1){
					flag = true;
				}
			}else {
				list.add(jishu);
				chaju = A[i] - A[i-1];
				jishu = 1;
			}
		}
		if(flag){
			list.add(jishu);
		}
		for (int integer : list) {
			if(integer >= 3){
				int get = integer - 2;  //get 等于1
				int sumtem = get * (integer + 1);// sumtem 等于4
				int tem = ((3 + integer) * get) / 2;
				sum += sumtem - tem;
			}
		}
		System.out.println(list.toString());
		return sum;
    }
	//2019年3月21日14:24:33
	public int[] nextGreaterElements(int[] nums) {
		if(nums == null ||nums.length == 0){
			return new int[]{};
		}
        int max = nums[0];
        for (int i : nums) {
			if(max < i){
				max = i;
			}
		}
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
			int index = i + 1;
			if(nums[i] == max){
				result[i] = -1;
			}else {
				while (true) {
					if(nums[index % nums.length] > nums[i]){
						result[i] = nums[index % nums.length];
						break;
					}
					index ++;
				}
			}
		}
        
        
        return result;
    }
	//2019年3月20日14:32:24
	public int[] findFrequentTreeSum(TreeNode root) {
        //首先定义一个map表示每个元素之和所代表的个数，当然要是treemap，按照
		//value进行降序
		Map<Integer, Integer> temMap = new TreeMap<Integer, Integer>();
		if(root == null){
			return new int[]{};
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tem = queue.poll();
				if(tem.left != null){
					queue.offer(tem.left);
				}
				if(tem.right != null){
					queue.offer(tem.right);
				}
				int result = gets(tem);
				temMap.put(result, temMap.getOrDefault(result, 0) + 1);
			}
		}
		//这里将map.entrySet()转换成list
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(temMap.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //升序排序
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO 自动生成的方法存根
				return -o1.getValue().compareTo(o2.getValue());
			}
            
        });
        int max = 0;
        int size = 0;
        List<Integer> temsIntegers = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mapping:list){ 
        	if(max > mapping.getValue()){
        		break;
        	}
        	temsIntegers.add(mapping.getKey());
        	max = mapping.getValue();
            System.out.println(mapping.getKey()+":"+mapping.getValue()); 
          }
      int [] result = new int[temsIntegers.size()];
    //  int[] array = (int[])temsIntegers.toArray(new int[]);
      for (int i : temsIntegers) {
		result[size ++] = i;
	}
		return result;
    }
	public static int gets(TreeNode tem){
		if(tem.left == null && tem.right == null){
			return  tem.val;
		}
		if(tem.left != null && tem.right != null){
			return tem.val + gets(tem.left) + gets(tem.right);
		}
		if(tem.left != null && tem.right == null){
			return tem.val + gets(tem.left);
		}
		
		if(tem.left == null && tem.right != null){
			return tem.val + gets(tem.right);
		}
		return 0;
	}
	
	
	public int[][] flipAndInvertImage(int[][] A) {
/*		给定一个二进制矩阵 A，我们想先水平翻转图像，
 * 然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

*
*/
	//先进行水平翻转
		for (int i = 0; i < A.length; i++) {
			int start = 0;
			int end = A[i].length - 1;
			while (start <= end) {
				int tem = A[i][start];
				A[i][start] = A[i][end];
				A[i][end] = tem;
				if(start == end){
					A[i][start] = A[i][start] == 1? 0:1;
				}else {
					A[i][start] = A[i][start] == 1? 0:1;
					A[i][end] = A[i][end] == 1? 0:1;
				}
				
						
				start ++;
				end --;
				
			}
		}
		
		
		return A;
	
		
	
	}
	public String tree2str(TreeNode t) {
		//前序遍历
		StringBuilder sBuilder = new StringBuilder();
		if( t == null){
			return new String(sBuilder);
		}
		if(t.left == null && t.right == null){
			sBuilder.append(t.val);
			return new String(sBuilder);
		}
		gets(t, sBuilder);
		
		return new String(sBuilder);
        
    }
	public void gets(TreeNode tem,StringBuilder sb){
		if(tem.left == null && tem.right == null){
			sb.append(tem.val);
			return ;
		}
		sb.append(tem.val);
		if(tem.left != null){
			gets(tem.left, sb.append("("));
			sb.append(")");
		}
        if(tem.left == null) {
			sb.append("()");
		}
	
		
		if(tem.right != null){
			gets(tem.right, sb.append("(" ));
			sb.append(")");
		}
		
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int visit[] = new int[nums.length];
		List<Integer> size = new ArrayList<>();
		Set<List<Integer>> temset= new HashSet<>();
		
		permuteinUnie(nums, size, visit, result,temset);
		return result;
	}
	
	public void permuteinUnie(int nums[],List<Integer> size,int []visit ,List<List<Integer>> result,Set<List<Integer>> temset){
		if(size.size() == nums.length){
			List<Integer> temsIntegers = new ArrayList<>(size);
			int size1 = temset.size();
			temset.add(temsIntegers);
			if( temset.size() > size1){
				result.add(temsIntegers);
				return;
			}else {
				return;
			}
			
		}
		for (int i = 0; i < nums.length; i++) {
			if(visit[i] == 0){
				visit[i] = 1;
				size.add(nums[i]);
				permuteinUnie(nums, size, visit, result,temset);
				size.remove(size.size() - 1);
				visit[i] = 0;
			}
		}
	}
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Set<Integer> tem = new LinkedHashSet<>();
        permutein(nums, tem, result);
        
        
        return result;
    }
	
	public void permutein(int nums[],Set<Integer> tem ,List<List<Integer>> result){
		if(tem.size() == nums.length){
			List<Integer> sList = new ArrayList<>();
			for (int integer : tem) {
				sList.add(integer);
			}
			result.add(sList);
			
			return ;
		}
		for (int i = 0; i < nums.length; i++) {
			int size1 = tem.size();
			tem.add(nums[i]);
			if(size1 < tem.size()){
				permutein(nums, tem, result);
				tem.remove(nums[i]);
			}
		}
	}
	//2019年3月15日15:05:28
	public int findMinDifference(List<String> timePoints) {
		List<Integer> tem = new ArrayList<>();
		for (String string : timePoints) {
			int index = string.indexOf(":");
			int hour = Integer.parseInt(string.substring(0, index));
			int min = Integer.parseInt(string.substring(index + 1));
			tem.add(hour * 60 + min);
		}
		Collections.sort(tem,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1.compareTo(o2);
			}

		});
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < tem.size() - 1; i++) {
			min = Math.min(tem.get(i + 1) - tem.get(i), min);
			if(min == 0){
				return min;
			}
		}
		int last = Math.min(tem.get(tem.size() - 1) - tem.get(0), 1440 - tem.get(tem.size() - 1) + tem.get(0));
        min = Math.min(min, last);
		System.out.println(tem.toString());
		return 0;
    }
	
	
	
	//2019年3月15日14:27:51
	public ListNode detectCycle(ListNode head) {
        if(head == null ||head.next == null){
        	return null;
        }
		ListNode tem = head;
		ListNode tem2 = head;
		while (tem != null && tem2 != null) {
			tem = tem.next;
			if(tem2.next == null){
				return null;
			}
			tem2 = tem2.next.next;
			if(tem == tem2){
				break;
			}
		}
		System.out.println("df");
		if(tem == null || tem2 == null){
			return null;
		}
		//至此证明有环
		tem2 = head;
		while (tem != tem2) {
			tem = tem.next;
			tem2 = tem2.next;
		}
		return tem;
		
		
		
		
		
        
    }
	//2019年3月13日14:25:58
	public int findMaxLength(int[] nums) {
		if(nums == null || nums.length == 1 || nums.length == 0){
			return 0;
		}
		int max = 0;
		int sum = 0;
	
		Map<Integer, Integer> temmap = new HashMap<>();
		temmap.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1){
				sum++;
			}else {
				sum--;
			}
			if(temmap.get(sum) == null){
				temmap.put(sum, i);
			}else {
				
				max = Math.max(max, temmap.get(sum) - i);
			}
		}
		
		
		return max;
        
    }
	
	
	
	
//	给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
//
//	找到所有出现两次的元素。
	
	public List<Integer> findDuplicates(int[] nums) {
		/*List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length == 0|| nums.length == 1){
			return result;
		}
		int []a = new int[nums.length + 1];
		for (int i : nums) {
			a[i] ++;
		}
		for (int i = 1; i < a.length; i++) {
			if(a[i] == 2){
				result.add(i);
			}
		}
		return result;*/
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length == 1 || nums.length == 0){
			return result;
		}
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if(nums[num - 1 ] > 0){
				nums[num - 1] *=-1;
			}else {
				result.add(-nums[num - 1]);
			}
		}
		
		return result;
        
    }
	//2019年3月10日10:15:40
	public int bulbSwitch(int n) {
		/*超时代码，垃圾
		 * int result = 0;
		int [] tem = new int[n + 1];
		//初始化为开
		for (int i = 0; i < tem.length; i++) {
			tem[i] = 1;
		}
        for (int i = 2; i <= n; i++) {
			for (int j = 1; j < tem.length; j++) {
				if(j % i == 0){
					tem[j] = tem[j] == 1? 0:1;
				}
			}
		}
        for (int i = 1; i < tem.length; i++) {
			if(tem[i] == 1)
				result++;
		}
        return result;*/
		
		return (int) Math.sqrt(n);
    }
	
	//2019年3月7日14:22:46
	public int robII(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(rob(nums, 0, nums.length - 2), 
				        rob(nums, 1, nums.length - 1));
        
    }
	//子函数，打家劫舍第一题
	public int rob(int [] nums,int start, int end){
		int dp[] = new int[end];
		dp[start] = nums[start];
		
		dp[start +1] = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i <= end; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[end - 1];
	}
	
	//2019年3月6日14:15:04
	public boolean stoneGame(int[] piles) {
		int len = piles.length;
		
		//dp[i][j]表示从piles数组的i到j选择时先手比后手多的石子的数量
		//那么dp[i][j] = Max()
        int dp[][] = new int[len][len];
        for (int i = 0; i < dp.length; i++) {
			dp[i][i] = piles[i];
		}
        for (int i = 1; i < piles.length; i++) {
			for (int j = 0; j < piles.length; j++) {
				int l = i + j;
				dp[i][l] = Math.max(piles[l] - dp[i][l - 1], piles[i] - dp[i - 1][l]);
			}
		}
        
        return dp[0][len - 1] > 0? true :false;
        		
    }
	
	
	//2019年3月5日14:25:22
	public int nthUglyNumber(int n) {
		//初始化一个一开始的数组，长度为5，一次为1,2,3,4,5
		int result[] = new int[n];

		int tem[] = new int[]{1,2,3,4,5};
		if(n == 0){
			return 0;
		}
		if(n <= 5){
			return tem[n - 1];
		}
		//初始化result数组
		for (int i = 0; i < tem.length; i++) {
			result[i] = tem[i];
		}
		//我们需要找到下一个数字大于result中最大的那个
		int dangqian = 4;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		while (dangqian < n - 1) {
			//result中的最大丑数
			int max = result[dangqian];
			//所有元素*2之后，比max大的最小
			while (result[index2] * 2 < max) {
				index2 ++;
			}
			//所有元素*3之后，比max大的最小
			while (result[index3] * 3 < max) {
				index3 ++;
			}
			int getmin = Math.min(result[index2], result[index3]);
			//所有元素*2之后，比max大的最小
			while (result[index5] * 5 < max) {
				index5 ++;
			}
			getmin = Math.min(result[index5], getmin);
			dangqian ++;
			result[dangqian + 1] = getmin;
		}
		System.out.println(Arrays.toString(result));
		return result[n - 1];
    }
	
	//2019年3月4日14:37:07
	public int totalHammingDistance(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] == nums[j])
					continue;
				result += getsubtotal(nums[i], nums[j]);
			}
		}
		
        return result;
    }
	
	
	public int getsubtotal(int a, int b){
		int j = a ^ b;
		return Integer.bitCount(j);
	}
	
	//2019年3月1日14:12:34
	public static int divide(int dividend, int divisor) {
		
	    if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isPositive = true;
        if (dividend > 0 && divisor < 0 || (dividend < 0 && divisor > 0)) {
            isPositive = false;
        }
        
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int shift = 0;
        int result = 0;
        
        while (a >= b) {
            while (a >= b << shift) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
            shift = 0;
        }
        
        return isPositive ? result : -result;
		
    }
	
	/*public static long get(long dividend,long divisor){
		long result = 0;
		while (dividend >= 0) {
			result ++;
			dividend -= divisor;
		}
		result --;
		
		return result;
	}*/
	
	
	//14点14分
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String [] tem = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String tems = "";
        if(digits == "" || digits.length() == 0){
        	return result;
        }
        add(tems, result, tem, digits, 0);
        return result;
    }
	public void add(String add,List<String> result,String [] tem,String digits,int start){
		//到达最后一个字母,加入到result中
		if(start >= digits.length()){
			result.add(add);
			return ;
		}else {
			int index = Integer.parseInt(digits.charAt(start) + "");
			for (int i = 0; i < tem[index].length(); i++) {
				add(add + tem[index].charAt(i),result,tem,digits,start+1);
			}
		}
		
	}
	
	public static String convert(String s, int numRows) {
		
		if(s.length() <= numRows){
			return s;
		}
		int row = 0;
		boolean godown = false;
		List<StringBuilder> map = new ArrayList<StringBuilder>();
		
		for (int i = 0; i < numRows; i++) {
			map.add(new StringBuilder());
		}
		for (int i = 0; i < s.length(); i++) {
			map.get(row).append(s.charAt(i));
			if(row == 0 || row == numRows - 1)
				godown = ! godown;
			if(godown){
				row ++;
			}else {
				row --;
			}
		}
		
		StringBuilder sBuilder = new StringBuilder();
		for (StringBuilder s1 : map) {
			sBuilder.append(s1);
		}
		return new String(sBuilder);
		
		
	/*	//接下来我要确定需要多少列来存储这个Z字形
		//默认是一组
		
		//一组对应的是这么多数字
		int yizu = 1 * numRows + (numRows - 2); 
		int zushu = 1;
		while (true) {
			//找到有多少组
			if(zushu * yizu < s.length()){
				zushu ++;
			}else {
				break;
			}
		}	
		System.out.println("总共有 "+zushu +"   组") ;
		int lie = 0;
		lie = zushu + (numRows - 2) * zushu;
		if(zushu * yizu == s.length()){
		
		}else {
			int j = lie;
			while (j > s.length()) {
				j --;
			}
			lie = j;
		}
		System.out.println("列为："+lie+"  个");
	  
		return s;*/
	}
	
	
	public static String longestPalindrome(String s) {
		if(s.length() == 0 || s.length() == 1){
			return s;
		}
		StringBuilder tem = new StringBuilder("#");
		for (int i = 0; i < s.length(); i++) {
			tem.append(s.charAt(i)).append("#");
		}
		System.out.println(tem);
		int start = 0;
		int end = tem.length() - 1;
		int result[] = new int[tem.length()];
		
		result[0] = 1;
		result[tem.length() - 1] = 1;
		for (int i = 1; i < tem.length() -1 ; i++) {
			start = i -1 ;
			end = i + 1;
			while (true) {
				if(start >= 0 && 
					end <= tem.length() - 1 && 
					tem.charAt(start) == tem.charAt(end) ){
					end ++;
					start --;
				}else {
					result[i] = end - start + 1;
					break;	
				}
				
			}
		}
		System.out.println(Arrays.toString(result));
		
		//寻找result数组中的最大值，并且记录其下标，注意的是我们寻找的是除了第一个和最后一个的下标
		
		int max = result[1];
		int index = 1;
		for (int i = 0; i < result.length - 1; i++) {
			int j1 = result[i];
			if(j1 > max){
				max = j1;
				index = i;
			}
		}
		//接下来得到数组中的原来元素，得到返回值
		
		//前半部分下标
		start = index - max / 2 + 1;
		
		System.out.println("star " + start);
		System.out.println("end " + end);
		//后半部分下标
		end = index + max /2 - 1 ;
		StringBuilder temBuilder = new StringBuilder();
		while (start <= end) {
			if(tem.charAt(start) == '#'){
				
			}else {
				temBuilder.append(tem.charAt(start));
			}
			start ++;
		}
		return new String(temBuilder);
        
    }
}
