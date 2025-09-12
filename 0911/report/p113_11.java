package javaexample0928;
import java.util.Scanner;

public class FridgeStatus {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//사용자로부터 8비트 상태 입력 받음
		System.out.print("냉장고 상태 입력>>");
		String input = scanner.next();
		
		// 2진수 문자열을 10진수 정수로 변환
		int status = Integer.parseInt(input, 2);
		
		//비트 상태 확인
		String powerStatus = (status & 1) !=0? "전원 켜져 있음": "전원 꺼져 있음";
		String doorStatus = (status & 2) !=0? "문 닫혀 있음": "문 열려 있음";
		String lightStatus = (status & 4) !=0? "전구 정상 작동": "전구 손상됨";
		String temperatureStatus = (status & 8) !=0? "냉장고 온도 3도 미만": "냉장고 온도 3도 이상";
		
		//결과 출력
		System.out.println(powerStatus + ". " + doorStatus + ". " +lightStatus + ". " +temperatureStatus + "." );
		
		scanner.close();
		
	}
}
