import java.util.Scanner;

public class P110_3 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);	//	Scanner 객체 생성
		
		System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다. ****");
		
		System.out.print("떡볶이 몇 인분>>");
		int Tteokbokki = sca.nextInt()*2000;	//	떡볶이 값을 저장할 변수
		System.out.print("김말이 몇 인분>>");
		int Gimmari =  sca.nextInt()*1000;		//	김말이 값을 저장할 변수
		System.out.print("쫄면 몇 인분>>");
		int Jjolmyeon = sca.nextInt()*3000;		//	쫄면 값을 저장할 변수
		
		int sum = Tteokbokki + Gimmari + Jjolmyeon;	//	분식 가격의 총합을 저장할 변수
		
		System.out.println("전체 금액은 "+sum+"원입니다.");
		
		sca.close();	//	Scanner 객체 종료
		
		
	}
}
