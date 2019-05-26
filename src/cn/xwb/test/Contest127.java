package cn.xwb.test;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Contest127 {
	public static void main(String[] args) {
		 Map<String, String> map = new TreeMap<String, String>();
	        map.put("d", "ddddd");
	        map.put("b", "bbbbb");
	        map.put("a", "aaaaa");
	        map.put("c", "ccccc");
	        
	        //���ｫmap.entrySet()ת����list
	        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
	        //Ȼ��ͨ���Ƚ�����ʵ������
	        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
	        	@Override
	        	//��������
				public int compare(java.util.Map.Entry<String, String> o1, java.util.Map.Entry<String, String> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
	            
	        });
	        
	        for(Map.Entry<String,String> mapping:list){ 
	               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
	          } 
		
	}
	
	//2019��3��10��10:28:55
	 public int largestSumAfterKNegations(int[] A, int K) {
		 int sum = 0;
	       if(K == 0 ){
	    	   for (int i : A) {
				sum += i;
			    
	    	   }
	    	   return sum;
	       }
	       Arrays.sort(A);
	       //��������
	       while (K > 0) {
			A[0] = -A[0];
			Arrays.sort(A);
			K--;
		}
	       for (int i : A) {
				sum += i;
			    
	    	   }
	    	   return sum;
	 
	 }
	 //2019��3��10��10:36:35
	 public int clumsy(int N) {
	       int result = N;
	       if(N == 1){
	    	   return 1;
	       }
	       if(N == 2 || N == 3){
	    	   return 2;
	       }
	       
	       int sum = 0;
	       int tem = N + 1;
	       while (tem - 4 > 0) {
			sum += tem-4;
			System.out.println("���еļӷ�" + (tem - 4));
			tem -= 4;
		}
	       int chengfa = N * (N - 1) / (N - 2);
	       System.out.println("��һ���˷�" + chengfa);
	       sum += chengfa;
	      
	       int jianfa = 0;
	       int chushi = N - 4;
	       while (chushi - 3 >= 0) {
			jianfa += chushi*(chushi - 1)/(chushi - 2);
			chushi -= 4;
		}
	       if(chushi == 1){
	    	   jianfa += 1;
	       }else if(chushi == 2) {
			jianfa+=2;
		}
	       
	       
	       
	       return sum - jianfa;
	   
	 
	 }
	 //2019��3��10��10:55:31
	 public int minDominoRotations(int[] A, int[] B) {
	     //���A����Ķ���ȣ�ֱ�ӷ���0
		 int first = A[0];
		 boolean iseq = true;
		 for (int i : A) {
			if(i != first){
				iseq = false;
				break;
			}
		}
		 if(iseq){
			 return 0;
		 }
		 
		 //Ҫ���ҵ���С����ô������Ҫ�ҵ����ִ�����������
		 Map<Integer, Integer> map = new TreeMap<>();
		 for (int i : A) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
	  
		 
		//���ｫmap.entrySet()ת����list
	        List<Map.Entry<Integer ,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
	        //Ȼ��ͨ���Ƚ�����ʵ������
	        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
	        	@Override
	        	//��������
				public int compare(java.util.Map.Entry<Integer, Integer> o1, java.util.Map.Entry<Integer, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
	            
	        });
	       
	        int result = Integer.MAX_VALUE;
	        
	        for(java.util.Map.Entry<Integer, Integer> mapping:list){ 
	        	boolean flag = true;
	        	int min = 0;
	               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
	               for (int i = 0; i < A.length; i++) {
					if(A[i] != mapping.getKey()){
						if(B[i] != mapping.getKey()){
							flag = false;
							break;
						}else {
							min ++;
							
						}
					}
				}
	               if(flag){
	            	   if(min != 0){
	            		   result = Math.min(min, result);
	            	   }
	               }
	          } 
	        
	      
	        
	        
	        
	        
	        
	      if(result == Integer.MAX_VALUE){
	    	  return -1;
	      }
	      //��B��ֵ
	      
	      
	    //Ҫ���ҵ���С����ô������Ҫ�ҵ����ִ�����������
			 Map<Integer, Integer> mapB = new TreeMap<>();
			 for (int i : B) {
				mapB.put(i, mapB.getOrDefault(i, 0) + 1);
			}
		  
			 
			//���ｫmap.entrySet()ת����list
		        List<Map.Entry<Integer ,Integer>> listB = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
		        //Ȼ��ͨ���Ƚ�����ʵ������
		        Collections.sort(listB,new Comparator<Map.Entry<Integer,Integer>>() {
		        	@Override
		        	//��������
					public int compare(java.util.Map.Entry<Integer, Integer> o1, java.util.Map.Entry<Integer, Integer> o2) {
						return o2.getValue().compareTo(o1.getValue());
					}
		            
		        });
		       
		        int resultB = Integer.MAX_VALUE;
		        
		        for(java.util.Map.Entry<Integer, Integer> mapping:listB){ 
		        	boolean flag = true;
		        	int min = 0;
		               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
		               for (int i = 0; i < B.length; i++) {
						if(B[i] != mapping.getKey()){
							if(A[i] != mapping.getKey()){
								flag = false;
								break;
							}else {
								min ++;
								
							}
						}
					}
		               if(flag){
		            	   if(min != 0){
		            		   resultB = Math.min(min, resultB);
		            	   }
		               }
		          } 
		        
		      
		        
		        
	      
	      
	      
	      
	      
	      
		 return Math.min(result, resultB);
		 
		 
		 
		 
	 
	 }
	 
	 
	 public TreeNode bstFromPreorder(int[] preorder) {
		 
	     TreeNode root = new  TreeNode(preorder[0]);
	     if(preorder == null || preorder.length == 0){
	    	 return null;
	     }
	     
	     
	     return root;
		 
		 
	  }
	 
	 
	 
	
}
