import java.util.Scanner;
public class P110_4 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);	//	Scanner 객체 생성
		
		System.out.print("여행지>>");
		String Location = sca.nextLine();	//	여행지를 저장할 변수
		System.out.print("인원수>>");
		int People = sca.nextInt();			//	인원수를 저장할 변수
		System.out.print("숙박일>>");
		int Day = sca.nextInt();			//	숙박일을 저장할 변수
		System.out.print("1인당 항공료>>");
		int Airfare = sca.nextInt();		//	인당 항공료를 저장할 변수
		System.out.print("1방 숙박비>>");
		int Lodge_fee = sca.nextInt();		//	방당 숙박비를 저장할 변수
		
		int Room;							//	방을 저장할 변수
		
		if(People%2 == 0) {					//	방 하나에는 2명 까지 투숙이 가능하다
			Room = People/2;
		}
		else {								//	1명만 투숙해도 1개의 방의 비용이 지불된다
			Room = (People/2)+(People%2);
		}
		
		int sum = (People * Airfare) + (Day * Room * Lodge_fee);	//	총 경비를 저장하는 변수
		
		System.out.println(People+"명의 "+Location+" "+ Day+"박 "+(Day+1)+"일 여행에는 방이 "+Room+"개 필요하며 경비는 "+sum+"원입니다.");
		
		sca.close();	//	Scanner 객체 종료
	}
}
