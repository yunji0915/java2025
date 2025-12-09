package appl;

class Student{
	private String name;
	private int id;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public String toString() {
		return name + " 학생의 학번은 " + id;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student other = (Student) obj;
			return this.name.equals(other.name) && this.id == other.id;//이름이 같으면 같은 학생
		}
		return false;
	}
}

public class Exam_1 {
	public static void main(String[] args) {
		Student a = new Student("황기태", 23);	//id가 23인 황기태 학생
		Student b = new Student("황기태", 77);	//id가 77인 황기태 학생
		System.out.println(a);
		if(a.equals(b))
			System.out.println("같은 학생입니다.");
		else
			System.out.println("다른 학생입니다.");
	}

}
