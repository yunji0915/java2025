package javaexample0928;
import java.util.Scanner;

public class CarStatus {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//사용자로부터 자동차 상태 입력 받음
		System.out.print("자동차 상태 입력>>");
		int status = scanner.nextInt(); //정수 입력

		//비트 0~5: 차내 온도 추출(온도는 0~31 범위)
		int temperature = status & 0x3F; // 0x3F는 6비트를 추출(111111)
		
		//비트 6: 에어컨 상태(0: 꺼짐 1: 켜짐)
		boolean isAirconOn = (status & 0x40) !=0; // 0x40은 6번쨰 비트 추출(01000000)
		
		//비트 7: 자동차 상태(0: 정지, 1: 달리는 상태)
		boolean isCarRunning = (status & 0x80) !=0; //0x80은 7번째 비트 추출(10000000)
		
		//자동차 상태 출력
		String carState = isCarRunning ? "달리는 상태": "정지 상태";
		String airconState = isAirconOn ? "켜진 상태": "꺼진 상태";
		
		//최종 결과 출력
		System.out.println("자동차는 " + carState + "이고 에어컨이" + airconState + "이고 온도는" + temperature + "도입니다.");
		
		scanner.close();
			
		
		
	}

}
