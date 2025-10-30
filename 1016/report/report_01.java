package main;

class StudentApp{
	private String name;
	private int id = 0;
	
	public StudentApp(String name, int id){ this.name = name; this.id = id; }
	public String toString() { return "학번이 " + id + "인 " + name; }
	public boolean equals(Object obj) {
		StudentApp st = (StudentApp)obj;
		if(name.equals(st.name) && (id == st.id)) {
			return true;			
		}
		else return false;
	}
}


public class report_01 {
	public static void main(String[] args) {
		StudentApp a = new StudentApp("황기태", 23);
		StudentApp b = new StudentApp("황기태", 77);
		System.out.println(a);
		if(a.equals(b))
			System.out.println("같은 학생입니다.");
		else
			System.out.println("다른 학생입니다.");
	}
}
