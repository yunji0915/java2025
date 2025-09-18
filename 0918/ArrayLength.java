package Array;

import java.util.Scanner;

// 배열의 length 필드를 이용하여 배열 크기만큼 정수를 입력 받고 평균을 출력하라.
public class ArrayLength {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int intArray[]= new int[5]; // 배열의 선언과 생성
		int sum=0;
		System.out.println(intArray.length +"개의 정수를 입력하세요>>");
		
		// 키보드에서 입력받은 정수 저장
		for(int i=0; i<intArray.length;i++) {
			intArray[i] = scn.nextInt(); 
		}
		
		// 배열에 저장된 정수 값 더하기
		for(int j=0; j<intArray.length;j++) {
			sum+=intArray[j];
		}
		
		System.out.println("평균은 " + (double)sum/intArray.length);
		
	}

}
