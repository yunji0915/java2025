import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class report_04_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		HashMap <String, Integer> h = new HashMap <String, Integer>();
		
		h.put("고추장", 3000); h.put("만두", 500); h.put("새우깡", 1500); h.put("콜라", 600); h.put("참치캔", 2000); h.put("치약", 1000); h.put("연어", 2500); h.put("삼겹살", 2500);
		System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
		System.out.println("[고추장, 3000] [만두, 500], [새우깡, 1500] [콜라, 600] [참치캔, 2000] [치약, 1000] [연어,2500] [삼겹살, 2500]");
		
		while(true) {
			System.out.print("물건과 개수를 입력하세요>>");
			String buy = scanner.nextLine();
			
			int price = 0;
			int count = 0;
			int sum = 0;
			boolean state = true;

			if(buy.equals("그만")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(buy, " ");
				
			int n = st.countTokens();
			if(n % 2 == 0) {
				for(int i=0; i<n/2; i++) {
					String thing = st.nextToken();
					if(h.containsKey(thing)) {
						price = h.get(thing);
						count = Integer.parseInt(st.nextToken());
						sum += price*count;	
						state = true;
					}
					else {
						System.out.println(thing + "은 없는 상품입니다!"); 
						state = false;
						}
				}
			}
			else {
				System.out.println("입력에 문제가 있습니다!");
				state = false;
			}
			if(state == true) { System.out.println("전체 비용은 " + sum + "입니다."); }
			
		}
		scanner.close();
	}
}
