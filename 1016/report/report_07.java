package main;

import java.util.Calendar;
import java.util.Scanner;

class PrintCalendar{
	
	public static void PrintCal(Calendar cal, int year) {
		cal.set(Calendar.YEAR, year);
		for(int i=0; i<12; i++) {
			System.out.println();
			System.out.println();
			cal.set(Calendar.MONTH, i);
			int month = cal.get(Calendar.MONTH) + 1;
			System.out.println(year + "년 " + month + "월");
			
			System.out.println("일 월 화 수 목 금 토");
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			int dayOfWeek =	cal.get(Calendar.DAY_OF_WEEK);
			if(dayOfWeek == 2) { System.out.print("   "); }
			if(dayOfWeek == 3) { System.out.print("      "); }
			if(dayOfWeek == 4) { System.out.print("         "); }
			if(dayOfWeek == 5) { System.out.print("            "); }
			if(dayOfWeek == 6) { System.out.print("               "); }
			if(dayOfWeek == 7) { System.out.print("                  "); }

			for(int j=0; j<lastDay; j++) {
				cal.set(Calendar.DAY_OF_MONTH, j+1);
				int CR = cal.get(Calendar.DAY_OF_WEEK);
				System.out.printf("%-3d",j+1);
				if(CR == 7) { System.out.println();  }
			}
			System.out.println();
		}
	}
}


public class report_07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar now = Calendar.getInstance();
		while(true) {
			System.out.print("년도 입력(-1이면 종료)>>");
			int year = scanner.nextInt();
			
			if(year == -1) { break; }
			
			PrintCalendar.PrintCal(now, year);
		}
		scanner.close();
	}
	
	
}
