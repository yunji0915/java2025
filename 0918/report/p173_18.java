import java.util.InputMismatchException;
import java.util.Scanner;

public class P173_18 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		int studentNumber [] = new int [10];
		int score [] = new int [10];
		
		System.out.println("10명 학생의 학번과 점수 입력");
		for(int i=0; i<studentNumber.length; i++) {
			System.out.print(i+1 + ">>");
			studentNumber[i] = sca.nextInt();
			score[i] = sca.nextInt();
		}
		
		while(true) {
			System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
			int state = sca.nextInt();
			
			if(state == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			try {
				int search = 0;
				
				
				if(state == 1) {
					System.out.print("학번>>");
					search = sca.nextInt();
					boolean exit = true;
					
					for(int i=0; i<studentNumber.length; i++) {
						if(search == studentNumber[i]) {
							System.out.println(score[i] + "점");
							exit = false;
						}
					}
					if(exit == true) {
						System.out.println(search + "의 학생은 없습니다.");
					}
				}
				
				if(state == 2) {
					int count = 0;
					int student [] = new int [score.length];
					System.out.print("점수>>");
					search = sca.nextInt();
					
					for(int i=0; i<score.length; i++) {
						if(search == score[i]) {
							student[0+count] = studentNumber[i];
							count++;
						}
					}
					if(count == 0) {
						System.out.println(search + "의 학생은 없습니다.");
					}
					else {
					System.out.print("점수가 " + search + "인 학생은 ");
					
					for(int i=0; i<count;i++) {
						System.out.print(student[i] + " ");
					}
					System.out.println("입니다.");
					}
				}
			}
			catch(InputMismatchException e) {
				System.out.println("경고!! 정수를 입력하세요.");
				sca.nextLine();
			}
			
			
			
		}
		sca.close();
	}
}
