package cn.xwb.test;

public class ListNode {
	public static void main(String[] args) {
		int i = 1;
		int k = 1;
		int l = 1;
		boolean flag = true;
		for(i = 1; i < 180; i+=6){
			if(flag){
				
				System.out.println("����    "+ k+ "ҳ��          "+i + "-" +(i+5));
				k++;
				flag = !flag;
				
			}else {
				
			/*	System.out.println("����    "+ l+ "ҳ��          "+i + "-" +(i+5));
				l++;
				flag = !flag;*/
				flag = !flag;
			}
		}
		
		for(i = 1; i < 180; i+=6){
			if(flag){
			/*	
				System.out.println("����    "+ k+ "ҳ��          "+i + "-" +(i+5));
				k++;
				flag = !flag;*/
				flag = !flag;
			}else {
				
				System.out.println("����    "+ l+ "ҳ��          "+i + "-" +(i+5));
				l++;
				flag = !flag;
			}
		}
	}
	      int val;
	     ListNode next;
	     ListNode(int x) {
	        val = x;
	         next = null;
	   }
}