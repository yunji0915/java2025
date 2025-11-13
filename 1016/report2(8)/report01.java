package chapter_8;

import java.util.Scanner;
import java.io.*;

public class report_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileWriter fout = null;
		
		System.out.println("전화번호 입력 프로그램입니다.");
		while(true) {
			
			try {
				System.out.print("이름 전화번호 >>");
				String line = scanner.nextLine();
				
				if(line.equals("그만")) {
					System.out.println("c:\\Temp\\phone.txt에 저장하였습니다.");
					break;
				}
				
			fout = new FileWriter("c:\\Temp\\phone.txt", true);
			
			
		
			fout.write(line + "\r\n");
			
			fout.close();
			}catch(IOException e) {
				System.out.println("입출력 오류");
			}
		}
		scanner.close();
	}
}
