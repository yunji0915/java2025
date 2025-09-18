import java.util.InputMismatchException;
import java.util.Scanner;


public class P171_15 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
			
		int n, m = 0;
		while(true) {
			try {
				System.out.print("곱하고자 하는 정수 2개 입력>>");
				n = sca.nextInt();
				m = sca.nextInt();
				break;
			}
			catch (InputMismatchException e){
				System.out.println("정수를 입력하세요!");
				sca.nextLine();
			}
		}
		System.out.println(n + "x" + m + "=" + n*m);			
		sca.close();
	}
}
