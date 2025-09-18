import java.util.InputMismatchException;
import java.util.Scanner;

public class P172_17 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		String coffee[] = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
		int price[] = {3000, 3500, 4000, 5000};
		
		System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");
		while(true) {
			try {
				System.out.print("주문>>");
				String order = sca.next();
				int count = sca.nextInt();
				int i = 0;
				if(order.equals("그만")) {
					break;
				}
				
				for(i=0; i<coffee.length;i++) {
					if(coffee[i].equals(order)) {
						System.out.println("가격은 " + price[i]*count + "입니다.");
						break;
					}
				}
				if(i == coffee.length) {
					System.out.println(order + "은 없는 메뉴입니다.");
				}
			}
				catch(InputMismatchException e) {
					System.out.println("잔 수는 양의 정수로 입력해주세요!");
					sca.nextLine();
				}
		}
		sca.close();
	}
	
}
