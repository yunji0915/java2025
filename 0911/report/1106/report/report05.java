package appl;

import java.util.Scanner;

public class Exam_5 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("여러 과목의 학점을 빈칸으로 분리 입력 >>");
		String line = scn.nextLine();//한줄 입력받기
		String [] grades = line.split(" ");//빈칸 기준으로 분리
		int sum = 0;
		int count = 0;
		
		for(String grade : grades) {
			grade = grade.toUpperCase();//대소문자 구분없이 처리
			int score = 0;
			
			switch(grade) {
				case "A":score = 100; break;
				case "B": score = 90; break;
				case "C": score = 80; break;
				case "D": score = 70; break;
				case "F": score = 0; break;
				default:
					System.out.println("잘못된 학점 입력 : "+grade);
					continue;//무효한 학점은 건너뜀
			}
			sum += score;
			count++;
		}
		if(count>0) {
			double average = (double) sum/count;
			System.out.print("평균은 "+ average+"점입니다.");
		} else {
			System.out.println("유효한 학점이 없습니다.");
		}
		
		
		scn.close();
	}
}
