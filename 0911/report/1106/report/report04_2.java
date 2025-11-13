import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class report_04_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList <String> L1 = new ArrayList <String>();
		ArrayList <Integer> L2 = new ArrayList <Integer>();
		
		L1.add("고추장"); L1.add("만두"); L1.add("새우깡"); L1.add("콜라"); L1.add("참치캔"); L1.add("치약"); L1.add("연어"); L1.add("삼겹살");
		L2.add(3000); L2.add(500); L2.add(1500); L2.add(600); L2.add(2000); L2.add(1000); L2.add(2500); L2.add(2500);
		System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
		System.out.println("[고추장, 3000] [만두, 500], [새우깡, 1500] [콜라, 600] [참치캔, 2000] [치약, 1000] [연어,2500] [삼겹살, 2500]");
		
		while(true) {
			
			int price = 0;
			int count = 0;
			int sum = 0;
			boolean state = true;


			System.out.print("물건과 개수를 입력하세요>>");
			String buy = scanner.nextLine();
			
			if(buy.equals("그만")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(buy, " ");
			
			if(st.countTokens() % 2 != 0) {
				System.out.println("입력에 문제가 있습니다 !");
				state = false;
			}
			
			while(st.hasMoreTokens() && state) {
				String thing = st.nextToken();
				boolean found = false;
				
				for(int i=0; i<L1.size(); i++) {
					if(L1.get(i).equals(thing)) {
						found = true;
						count = Integer.parseInt(st.nextToken());
						price = L2.get(i) * count;
						sum += price;
						break;
					}
				}
				if(!found) {
					System.out.println(thing + "은 없는 상품입니다!");
					state = false;
					break;
				}	
			}
			if(state) {
				System.out.println("전체 비용은 " + sum + "원입니다.");
			}
		}
		scanner.close();
	}
}
