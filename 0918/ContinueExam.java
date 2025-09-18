package control;

import java.util.Scanner;

// 5개의 정수를 입력받고 그 중 양수들만 합하여 출력하는 프로그램을 작성하라

public class ContinueExam {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("정수를 5개 입력하세요: ");
		int sum=0;
		
		for(int i=0; i<5; i++) {
			int num = scn.nextInt();
			if(num<=0) {
				continue; // 양수가 아닌 경우 다음 반복으로 진행
			}
			else
			   sum+=num; // 양수인 경우 덧셈
		}
		System.out.println("양수의 합은" + sum);
		
		scn.close();
	}
}
