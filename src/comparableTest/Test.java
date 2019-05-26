package comparableTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person(11, "c", false, "合肥市");
		Person p2 = new Person(12, "a", true, "宣城市");
		Person p3 = new Person(13, "王五", true, "芜湖市");
		List<Person> p = new ArrayList<Person>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		Collections.sort(p);
		System.out.println(""+ p.toString());
	}
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int index1 = o1.indexOf(" ");
				int index2 = o2.indexOf(" ");
				char c1 = o1.charAt(index1 + 1);
				char c2 = o2.charAt(index2 + 1);
				if(Character.isLetter(c1) && Character.isLetter(c2)){
					return o1.substring(index1 + 1).compareTo(o2.substring(index1 + 1));
				}else if (Character.isLetter(c1)) {
					return 1;
				}else if (Character.isLetter(c2)) {
					return -1;
				}else {
					return (c1+"").compareTo(c2 + "");
				}
				
				
			}
		});
    
		return logs;
    }
	

	

}
