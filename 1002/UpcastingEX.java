package basic;
public class UpcastingEX {
	public static void main(String[] args) {
		Person p;
		Student s = new Student("장윤지");
		p = s;
		System.out.println(p.name);
	}
}

class Person {
	String name;
	String id;
	public Person(String name) {
		this.name = name;
	}
}

class Student extends Person {
	String grade;
	String department;
	
	public Student(String name) {
		super(name);
	}
}


