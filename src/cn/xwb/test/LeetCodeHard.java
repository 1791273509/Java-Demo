
package cn.xwb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

import javax.security.auth.x500.X500Principal;

public class LeetCodeHard {
	//2019年3月25日14:09:03
	//采用二分法，当然还可以使用动态规划，这里先使用二分法来进行
	public int splitArray(int[] nums, int m) {
        long sum = 0;
        long max = nums[0];
        for (int i : nums) {
			max = i > max ? i : max;
			sum += i;
		}
        
        //先讨论的是特殊情况
        
        if(m == 1){
        	return (int) max;
        }
        if(m == nums.length){
        	return (int) sum;
        }
        
        long mid = (sum + max) >> 1;
        
        long left = max;
        long right = sum;
        while (left != right) {
			int need = 1;
			int cur = 0;
			mid = (left + right) >> 1;
			for (int i = 0; i < nums.length; i++) {
				
				if(cur + nums[i] > mid){
					cur = 0;
					need ++;
				}
				cur += nums[i];
			}
			if(need > m){
				left = mid + 1;
			}else {
				right = mid;
			}
			
		}
        return (int) left;
        
        
		
    }
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		getpostorderT(root, result);
		return result;
        
    }
	public void getpostorderT(TreeNode root,List<Integer> result){
		
		if (root == null)
			return ;
		getpostorderT(root.left, result);
		getpostorderT(root.right, result);
		result.add(root.val);
		
	}
	public void solveSudoku(char[][] board) {
		if(board == null || board.length == 0){
			return ;
		}
//		记录行中出现的重复
		boolean row [][] = new boolean[9][10];
//		记录列中出现的重复
		boolean col [][] = new boolean[9][10];
//		记录九宫格中出现的重复
		boolean block[][] = new boolean[9][10];
		
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block.length; j++) {
				if(board[i][j] != '.'){
					int num = (int)(board[i][j] - '0');
					row[i][num] = true;
					col[j][num] = true;
					block[3 * (i / 3) + j / 3][num] = true;
				}
			}
		}
		get(board, row, col, block);
        
    }
	
	public boolean get(char [][]board,boolean row[][],boolean col[][],boolean block[][]){
//		首先寻找最前面的'.'
		int x = 0;
		int y = 0;
		while (board[x][y] != '.') {
			if(y + 1 == 9){
				x ++;
				if(x == 9){
					return true ;
				}
				y = 0;
			}else {
				y++;
			}
		}
		System.out.println("最先的点坐标为"  + x);
		System.out.println("最先的点坐标为"  + y);
//		到这里就找到了最先的点x,y尝试放入1-9
		for (char c = '1'; c <= '9';c++) {
			if(testVaild(block, row, col, x, y, c)){
				board[x][y] = c;
				row[x][c - '0'] = true;
				col [y][c - '0'] = true;
				block[3 *(x / 3) + y / 3][c - '0'] = true;
//				如果上一步出现错误，则回溯
				if(!get(board, row, col, block)){
					board[x][y] = '.';
					row[x][c - '0'] = false;
					col [y][c - '0'] = false;
					block[3 *(x / 3) + y / 3][c - '0'] = false;
				}else {
//					表示这一步可以继续进行下去
					return true;
				}
			}
		}
//		尝试了所有的情况都不行的话就返回false，表示这一步不能进行下去，需要回溯，这里很重要
		return false;
	}
	public boolean testVaild(boolean block[][],boolean row[][]
			,boolean col[][],int x,int y,char c){
		if(row[x][c - '0'] || col[y][c - '0'] || block [3 *(x / 3) + y / 3][c - '0'] ){
			return false;
		}
		
		
		
		return true;
		
		
	}
	
	public String orderlyQueue(String S, int K) {
		
		if(S == null || S.length() ==0 || S.length() == 1){
			return S;
		}
		String result = S;
	    if(K == 1){	
        	for (int i = 0; i < S.length(); i++) {
        		char [] s = S.toCharArray();
				char tem0 = S.charAt(0);
				change(s, tem0);
				if(result.compareTo(new String(s)) > 0 ){
					result = new String(s);
				}
				S = new String(s);
			}
        	return result;
        }else {
			char [] tem = S.toCharArray();
			Arrays.sort(tem);
			System.out.println(Arrays.toString(tem));
			return new String(tem);
		}
    }
	public void change(char [] tem, char first){
		for (int i = 0; i < tem.length - 1; i++) {
			tem[i] = tem[i+1];
		}
		tem[tem.length - 1] = first;
	}
	//N皇后问题即任意两个皇后都不能处于同一行、同一列或同一斜线上
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 2){
        	return result;
        }
        int position[] = new int[n];
       
        get(n, 0, position, result);
        return result;
    }
	
	
	public void get(int n,int posi,int [] position,List<List<String>> result){
		if(posi == n){
			StringBuilder sBuilder = new StringBuilder();
			List<String> temList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(position[i] == j){
						sBuilder.append("Q");
					}else {
						sBuilder.append(".");
					}
					
				}
				temList.add(sBuilder.toString());
			}
			result.add(temList);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			position[posi] = i;
			if(is(posi,position)){
				get(n, posi + 1, position, result);
			}
		}
	}
	public boolean is(int row, int position[]){
		//判断之前的是否满足条件
		for (int i = 0; i < row; i++) {
			if(position[row] == position[i] || (Math.abs(position[i] - position[i]) == row - i)){
				return false;
			}
		}
		return true;
	}
}
