import java.util.Scanner;

public class P166_3 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		int num = 0;
		
		while(num <= 0) {
			System.out.print("양의 정수 입력>>");
			num = sca.nextInt();
			if(num > 0)
				break;
		}
			for(int i=0; i<num; i++) {
				for(int j=i; j<num; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
			sca.close();
	}
}
