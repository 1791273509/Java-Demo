package cn.xwb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

public class Contest133 {
	public static void main(String[] args) {
		 Set<String > set = new HashSet<>();

		
		 String  siz = 1 + "" + 2;
		

		 set.add(siz);
		 
		 String s1iz = 1 + "" + 2;
		
		 set.add(s1iz);
		 System.out.println(set.size());
		 
	}
	 public int twoCitySchedCost(int[][] costs) {
	       int result = 0;
	       int n = costs.length;
	       int a = 0;
	       int b = 0;
	       return result;
	  
	 }
	 public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
	      
		 if(r0 <= 0 || c0 <= 0){
			 return new int[][]{{}};
		 }
		
		 List<int[]> tem = new ArrayList<>();
		 Set<String > set = new HashSet<>();
		 int s [] = {r0,c0};
		
		 tem.add(s);
		 set.add(r0 + "" + c0);
		
		 int index = 0;
		 while (true) {
			 int [] tes = new int[2];
			 if(index >= tem.size()){
				 break;
			 }
			 tes = tem.get(index ++);
			 System.out.println(Arrays.toString(tem.get(index - 1)));
			 int x = tes[0];
			 int y = tes[1];
			 if(x - 1 >= 0){
				 int gets[] = {x- 1, y};
				 String getss = (x-1) + "" + y;
				 if(!set.contains(getss)){
					 set.add(getss);
					 tem.add(gets);
				 }
			 }
			 if(y - 1 >= 0){
				 int gets[] = {x, y-1};
				 String getss = x + "" + (y-1);
				 if(!set.contains(getss)){
					 set.add(getss);
					 tem.add(gets);
				 }
				
			 }
			 if(x + 1 < R){
				 int gets[] = {x + 1, y};
				 String getss = (x + 1) + "" + (y);
				 if(!set.contains(getss)){
					 set.add(getss);
					 tem.add(gets);
				 }
			 }
			 if(y + 1 < C){
				 String getss = x + "" + (y+1);
				 int gets[] = {x, y + 1};
				 if(!set.contains(getss)){
					 set.add(getss);
					 tem.add(gets);
				 }
			 }
		}
		 int result [][] = new int[tem.size()][2];
		 for (int i = 0; i < tem.size(); i++) {
			 System.out.println(Arrays.toString(tem.get(i)));
			result[i][0] = tem.get(i)[0];
			result[i][1] = tem.get(i)[1];
			
 		}
		 
		 return result;
	   }
	 
	 
	 public int maxSumTwoNoOverlap(int[] A, int L, int M) {
	     int max = 0;
	     int tem = 0;
	     for (int i = 0; i < A.length; i++) {
	    	 for (int j = i; j < L; j++) {
	 			tem += A[i];
	 		}
		}
	     
	     return max;
	     
	  }
	
}
