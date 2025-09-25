package Report;

import java.util.Scanner;

public class DicApp {
	Scanner scanner;
	public DicApp(Scanner scanner) {
		this.scanner = scanner;
	}
	public void run() {
		System.out.println("한영 단어 검색 프로그램입니다.");
		while(true) {
			System.out.print("한글 단어?");
			String word = scanner.next();
			String answer = Dictionary.kor2Eng(word);
			
			if(word.equals("그만")) {
				break;
			}
			if(word == answer) {
				System.out.println(word + "는 저의 사전에 없습니다.");
			}
			else {
				System.out.println(word + "은 " + answer);
			}
			
			
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DicApp dic = new DicApp(scanner);
		
		dic.run();
		
		scanner.close();
	}
	
}
