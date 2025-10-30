package main;

import java.util.Scanner;

public class report_06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
		String array = scanner.nextLine();
		
		int length = array.length();
		
		for(int i=0; i<length; i++) {
			array += array.charAt(i);
			System.out.println(array.substring(i+1));
		}
		
		
		
		
		scanner.close();
	}
}
