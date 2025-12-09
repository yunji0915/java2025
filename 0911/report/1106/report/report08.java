package appl;

import java.util.Calendar;
import java.util.Scanner;

public class Exam_8 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		Calendar today = Calendar.getInstance();
				
		System.out.print("오늘은"+ today.get(Calendar.YEAR)+ "년 "
				+ (today.get(Calendar.MONTH)+1)+"월 "
				+ today.get(Calendar.DAY_OF_MONTH)+"일입니다.");
		System.out.print("생일 입력(년 월 일) >>");
		int year = scn.nextInt();
		int month = scn.nextInt();
		int day = scn.nextInt();
		
		Calendar birth = Calendar.getInstance();
		birth.set(year, month-1, day, 0, 0, 0);
		
		long millisBirth = birth.getTimeInMillis();
		long millisToday = today.getTimeInMillis();
		
		long diffMillis = millisToday - millisBirth;
		long days = diffMillis / (1000*60*60*24) + 1;
		
		System.out.println("오늘까지 " + days + "살아왔습니다.");
		
		
		scn.close();
	}
}
