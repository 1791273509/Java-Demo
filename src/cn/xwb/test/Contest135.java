package cn.xwb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Contest135 {
	public static void main(String[] args) {
	}
	public boolean isBoomerang(int[][] points) {
//		≈–∂œ «∑Òœ‡µ»

		
		int a1 = points[1][0] - points[0][0];
		int b1 = points[1][1] - points[0][1];
		
		int a2 = points[2][0] - points[0][0];
		int b2 = points[2][1] - points[0][1];
		if(a1 * b2 == b1 * a2){
			return false;
		}
		
		return true;
		
    }
	int tem = 0;
	public TreeNode bstToGst(TreeNode root) {
        dfs(root);
		
		
		return root;
    }
	
	
	
	
	
	public void dfs (TreeNode root){
		
		if(root.right != null){
			dfs(root.right);
		}
		tem = tem + root.val;
//		System.out.println(tem);
		root.val = tem;
		if(root.left != null){
			dfs(root.left);
		}
	}
	
	
	public int minScoreTriangulation(int[] A) {
		if(A.length == 3){
			return A[0] * A[1] * A[2];
		}
		return 0;
    }
	public int[] numMovesStonesII(int[] stones) {
		Arrays.sort(stones);
		boolean flag = true;
		for (int i = 1; i < stones.length; i++) {
			if(stones[i-1] + 1 != stones[i]){
				flag = false;
				break;
			}
		}
		if(flag){
			return new int[]{0,0};
		}
		
		return new int[]{0,0};
		
		
    }
}
