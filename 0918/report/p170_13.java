import java.util.Scanner;

public class P170_13 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		String course [] = {"C", "C++", "Python", "Java", "HTML5"};
		String grade [] = {"A", "B+", "B", "A+", "D"};
		String courseName;
		
		while(true) {
				System.out.print("과목>>");
				courseName = sca.next();
				
				if(courseName.equals("그만"))
					break;
				
				for(int i=0; i<course.length; i++) {
					if(course[i].equals(courseName)) {
						System.out.println(course[i] + " 학점은 " + grade[i]);
						break;
					}
					if(i == course.length-1) {
						System.out.println(courseName + "는 없는 과목입니다.");									
					}
				}
				
		}
		sca.close();
	}
}
