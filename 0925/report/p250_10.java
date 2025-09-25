package Report;

import java.util.Scanner;

public class MonthDiary {
	int year, month = 0;
	Scanner scanner;
	DayDiary [] diary;
	
	public MonthDiary(int year, int month, Scanner scanner) {
		this.year = year;
		this.month = month;
		this.scanner = scanner;
		this.diary = new DayDiary [30];
		for(int i=0; i<diary.length; i++) {
			diary[i] = new DayDiary();
		}
	}
	public void run() {
		System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");
		getMenu();
	}
	public void getMenu() {
		while(true) {
			System.out.print("기록:1, 보기:2, 종료:3>>:");
			int menu = scanner.nextInt();
		
			if(menu == 1) {
				write();
			}
			if(menu == 2) {
				show();
			}
			if(menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
	public void write() {
		System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
		int index = scanner.nextInt();
		String memo = scanner.next();
		scanner.nextLine();
		diary[index-1].setMemo(memo);
	}
	public void show() {
		for(int i=0; i<30; i++) {
			if(diary[i].getMemo() == null) {
				System.out.print("...   ");
			}
			else {
				System.out.print(diary[i].getMemo() + "   ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MonthDiary monthDiary = new MonthDiary(2024, 10, scanner);
		monthDiary.run();
	}
}
