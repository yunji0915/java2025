package Array;

import java.util.Scanner;

// 양수 5개를 입력받아 배열에 저장하고, 제일 큰 수를 출력하는 프로그램
public class ArrayAccess {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int intArray[];
		intArray = new int[5];
		int max=0;
		System.out.println("양수 5개를 입력하세요.");
		
		for(int i=0; i<5; i++) {
			intArray[i] = scn.nextInt();
			if(intArray[i] > max)
				max = intArray[i];
		}
		System.out.println("가장 큰 수는 " + max +" 입니다.");
		
		scn.close();
	}
}
