import java.util.Scanner;

public class P170_14 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		
		System.out.println("***** 겜블링 게임을 시작합니다. *****");
		while(true) {
			String result;
			
			int Own = (int)(Math.random()*3);
			int Two = (int)(Math.random()*3);
			int Three = (int)(Math.random()*3);
			
			
			System.out.print("엔터키 입력>>");
			sca.nextLine();
			System.out.println(Own + " " + Two + " " + Three);
			
			if(Own == Two && Own == Three) {
				System.out.print("성공! 대박났어요!");
				System.out.print("계속하시겠습니까?(yes/no)>>");
				result = sca.nextLine();
					if(result.equals("no")) {
						System.out.print("게임을 종료합니다.");
						break;
					}
					else if(result.equals("yes"))
						continue;
					else {
						System.out.print("잘못된 입력입니다. 강제종료 합니다.");
						break;
					}
					
			}
			
		}
		sca.close();
	}
}
