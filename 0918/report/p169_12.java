import java.util.Scanner;

public class P169_12 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		String gender;
		String first;
		String boyMiddleList [] = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
		String boyLastList [] = {"태", "진", "광", "혁", "우", "철", "빈", "준", "구", "호", "석"};
		String girlMiddleList [] = {"은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하"};
		String girlLastList [] = {"진", "연", "경", "서", "리", "숙", "미", "원", "린", "희", "수"};
		
		System.out.println("***** 작명 프로그램이 실행됩니다. *****");
		while(true) {
			System.out.print("남/여 선택>>");
			gender = sca.next();
			
			if(gender.equals("남")) {
				System.out.print("성 입력>>");
				first = sca.next();
				int middleIndex = (int)(Math.random()*boyMiddleList.length);
				int lastIndex = (int)(Math.random()*boyLastList.length);
				String middle = boyMiddleList[middleIndex];
				String last = boyLastList[lastIndex];
				System.out.println("추천 이름: " + first + middle + last);
			}
			else if(gender.equals("여")) {
				System.out.print("성 입력>>");
				first = sca.next();
				int middleIndex = (int)(Math.random()*girlMiddleList.length);
				int lastIndex = (int)(Math.random()*girlLastList.length);
				String middle = girlMiddleList[middleIndex];
				String last = girlLastList[lastIndex];
				System.out.println("추천 이름: " + first + middle + last);
			}
			else if(gender.equals("그만"))
				break;
			else {
				System.out.println("남/여/그만 중에서 입력하세요!");
				continue;
			}
		}
		sca.close();
	}
}
