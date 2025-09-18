package control;

import java.util.Scanner;

// -1이 입력될 때까지 정수를 계속 입력받아 합을 구하고 평균을 출력하는 프로그램 출력하깅

public class Forexam02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int innum;
		int sum=0;
		int count=0;
		double avg=0;
		
		System.out.println("정수를 입력하세요. 종료하려면 -1을 입력하세요.");
		
		while(true) {
			innum = scn.nextInt(); // 반복 안에서 계속 입력 받기
			if(innum == -1) {
				break;
			}
			sum += innum;
			count ++;
		}
		
		if(count > 0) {
			avg = (double) sum / count; // int /int 방지 -> (double) 캐스팅
		}
		
		System.out.println("합: " + sum);
		System.out.println("평균: " + avg);
	}
}
