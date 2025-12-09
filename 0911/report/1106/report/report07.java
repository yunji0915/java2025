package appl;

import java.util.Calendar;
import java.util.Scanner;

public class Exam_7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.print("년도 입력(-1이면 종료) >> ");
			int year = scn.nextInt();
			if(year == -1) break;
			
			for(int month = 0; month < 12; month++) {
				Calendar cal = Calendar.getInstance();
				cal.set(year,  month, 1);	//해당 월의 1일로 설정
				
				int startDay = cal.get(Calendar.DAY_OF_WEEK);//시작요일
				int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				System.out.println("["+ (month+1) + "월]");
				System.out.println(" 일  월  화  수  목  금  토");
				for(int i=1; i<startDay; i++) {
					System.out.print("   ");
				}
				for(int day = 1; day <= lastDay; day++) {
					System.out.printf("%3d",day);
					if((startDay + day -1)%7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
		}
		scn.close();
	}
}
