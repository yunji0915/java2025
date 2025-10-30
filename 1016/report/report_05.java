package main;

import java.util.Scanner;
class Average{
	static int sum; static int count;
	
	public static boolean average(String[] Array) {
		sum = 0;
		count = 0;
		
		for(int i=0; i<Array.length; i++) {
			if(Array[i].equals("A")) { sum += 100; count ++; }
			else if(Array[i].equals("B")) { sum += 90; count ++; }
			else if(Array[i].equals("C")) { sum += 80; count ++; }
			else if(Array[i].equals("D")) { sum += 70; count ++; }
			else if(Array[i].equals("F")) { sum += 0; count ++; }
			else { 
				System.out.println("입력 오류:" + Array[i]);
				return false;
			}
		}
		return true;
	}
	
	public static double getAvr() {
		return (double)sum/count;
	}
}
public class report_05 {
	public static void main(String[ ] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
			String line = scanner.nextLine();
			
			if(line.equals("그만")) { break; }
			
			String[] gradeArray = line.toUpperCase().split(" ");
			
			if(Average.average(gradeArray)) {
				System.out.println("평균은 " + Average.getAvr());				
			}

		}
		scanner.close();
	}
}
