import java.util.Scanner;

	public class P110_1 {
		public static void main(String[] args) {
			Scanner sca = new Scanner(System.in);	//	Scanner 객체 생성
			
			
			System.out.print("$1=1200원입니다. 달러를 입력하세요>>");
			
			int Dollar = sca.nextInt();	//	입력 받은 값을 저장할 변수
			
			System.out.println("$" + Dollar + "는 " + (Dollar * 1200) + "원입니다.");
			
			sca.close();	//	Scanner 객체 종료
		}
}
