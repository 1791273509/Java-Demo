package comparableTest;

/**
 * @author 17912
 *
 */
public class Person implements Comparable<Person>{

	
	int age;
	String name;
	boolean ismale;
	String address;
	
	public Person(int age, String name, boolean ismale, String address) {
		super();
		this.age = age;
		this.name = name;
		this.ismale = ismale;
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isIsmale() {
		return ismale;
	}
	public void setIsmale(boolean ismale) {
		this.ismale = ismale;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", ismale=" + ismale + ", address=" + address + "]";
	}
	@Override
	public int compareTo(Person o) {
		if(this.age != o.age){
			return  this.age - o.age;
		}else {
			return this.name.compareTo(o.getName());
		}
	}
	
	
}
