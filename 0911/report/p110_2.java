import java.util.Scanner;

public class P110_2 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);	//	Scanner 객체 생성
				
		System.out.print("생일을 입력하세요>>");
		
		int Date = sca.nextInt();	//	입력 받은 값을 저장할 변수
		int Year = Date / 10000;	// 년도 값을 저장할 변수
		int Month = (Date % 10000) / 100;	//	월 값을 저장할 변수
		int Day = Date % 100;	//	일 값을 저장할 변수
		
		System.out.println(Year+"년 "+Month+"월 "+Day+"일 ");
		
		sca.close();	//	Scanner 객체 종료
	}

}
