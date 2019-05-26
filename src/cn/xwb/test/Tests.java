package cn.xwb.test;


public class Tests {
	public static void main(String[] args) {
		
		
		System.out.println(addBinary("111", "11"));
		
	}
	public static  int mySqrt(int x) {
		
		return (int) Math.sqrt(x);
		
	        
    }
	
	
	
	public static String addBinary(String a, String b) {
        
		StringBuilder  sum = new StringBuilder();
		int i = a.length()-1;
		int j = b.length()-1;
		int div= 0;
		int k;
		if(i >= j){
			k = j;
		}else {
			k = i;
		}
		while (k >= 0) {
			int a1 = Integer.parseInt(Character.toString(a.charAt(i--)));
			System.out.println("a1   "+a1);
			int b1 = Integer.parseInt(Character.toString(b.charAt(j--)));
			System.out.println("b1   "+b1);
			if(a1+b1+div == 3 ){
				div = 1;
				sum.append("1");
			}else if (a1+b1+div ==2 ) {
				div = 1;
				sum.append("0");
			}else {
				int x = a1 + b1 + div;
				sum.append(Integer.toBinaryString(x));
				div = 0;
			}
			k--;
		}
		i = a.length();
	    j = b.length();
		if( i == j){
			return (div == 1)?sum.append("1").reverse().toString():
				sum.reverse().toString();
		}
		
		if(i < j){
			int k1 = j - i;
			while (k1 > 0) {
				int b2 = Integer.parseInt(Character.toString(b.charAt(k1-1)));
				if ( b2+div ==2 ) {
					div = 1;
					sum.append("0");
				}else {
					int x1 = b2+ div;
					sum.append(Integer.toBinaryString(x1));
					div = 0;
				}
				k1--;
			}
			
			if(div == 1){
				sum.append("1");
				return sum.reverse().toString();
			}else {
				return sum.reverse().toString();
			}
		}else {
			int k2 = i - j;
			System.out.println("k2   "+k2);
			while (k2 > 0) {
				System.out.println("div  "+ div);
				int b2 = Integer.parseInt(Character.toString(a.charAt(k2-1)));
				if ( b2+div ==2 ) {	
					div = 1;
					sum.append("0");
				}else {
					int x1 = b2+ div;
					sum.append(Integer.toBinaryString(x1));
					div = 0;
				}
				k2--;
			}
			
			if(div == 1){
				sum.append("1");
				return sum.reverse().toString();
			}else {
				return sum.reverse().toString();
			}
		}
		
		
		
		
		
		
		
		
    }
	public static  int lengthOfLastWord(String s) {
		if(s.trim().equals(""))
			return 0;
		int j = s.length()-1;
		for(; j >= 0; j-- ){
			if(s.charAt(j) == ' '){
				
			}else {
				break;
			}
		}
		
		
		int count = 0;
		
		for(int i = j; i>=0; i--){
			if(s.charAt(i) != ' '){
				count++;
			}else {
				
				break;
			}
		}
		
		return count;
		
		/*if(s.trim().equals(""))
			return 0;
		String s2[] = s.split(" ");
        return s2[s2.length-1].length();*/
    }
	

}
