package main;

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

class PrintBirthDay{
	
	static Calendar now = Calendar.getInstance();
	
	public static String printCal(Calendar cal) {
		int day = now.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
		
		if(now.get(Calendar.YEAR) > cal.get(Calendar.YEAR)) {
			int count = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
			for(int i=0; i<count; i++) {
				day += 365; 
			}
		}
		
		if(day > 0) {
			return "오늘까지 " + day + "일 살아왔습니다.";
		}
		else {
			return (int)Math.abs(day) + "일 더 살아야 생일이 됩니다.";
		}
	}
}

public class report_08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar my = Calendar.getInstance();
		
		int year = my.get(Calendar.YEAR); int month = my.get(Calendar.MONTH)+1; int day = my.get(Calendar.DAY_OF_MONTH);
		System.out.println("오늘은 " + year + "년 " + month + "월 " + day + "일");
		while(true) {
			System.out.print("생일 입력(년 월 일)>>");
			String birthday = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(birthday, " ");
			
			if(birthday.equals("그만")) { break; }
			
			my.set(Calendar.YEAR, Integer.parseInt(st.nextToken()));
			my.set(Calendar.MONTH, Integer.parseInt(st.nextToken())-1);
			my.set(Calendar.DAY_OF_MONTH, Integer.parseInt(st.nextToken()));
			
			String result = PrintBirthDay.printCal(my);
			
			System.out.println(result);
		}
		scanner.close();
	}
}
