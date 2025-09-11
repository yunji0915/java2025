package basic;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		/*
		 * 사각형의 height와 width를 입력받아 면적을 출력하는 프로그램 작성
		 */
	Scanner scanner = new Scanner(System.in);
		
	System.out.println("사각형의 높이와 밑변 길이를 공백으로 분리하여 입력하라.");
	double height = scanner.nextDouble();
	double width = scanner.nextDouble();
	
	double area = height * width;
	
	System.out.println("사각형의 높이: " + height);
	System.out.println("사각형의 밑변 길이: " + width);
	System.out.println("사각형의 면적: " + area);
	
	scanner.close();
	
	}
}
