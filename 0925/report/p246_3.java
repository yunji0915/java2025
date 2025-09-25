package Report;

import java.util.Scanner;

public class Grade {
	 String name;
	 int Java;
	 int Web;
	 int os;
	 
	 public Grade(String name, int Java, int Web, int os){
		 this.name = name;
		 this.Java = Java;
		 this.Web = Web;
		 this.os = os;
	 }
	 public String getName() {
		 return name;
	 }
	 public int getAverage() {
		 return (Java + Web + os) / 3;
	 }
	 
	 public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
		String name = scanner.next();
		int java = scanner.nextInt();
		int web = scanner.nextInt();
		int os = scanner.nextInt();
		
		Grade grade = new Grade("박채원", java, web, os);
		System.out.print(grade.getName() + "의 평균은 " + grade.getAverage());
		
		scanner.close();
	}

}
