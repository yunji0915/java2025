import java.util.Scanner;
public class P168_11 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		int count = 0;
		while(true) {
			int numberOwn = (int)(Math.random()*9+1);
			int numberTwo = (int)(Math.random()*9+1);
			int sum = numberOwn * numberTwo;
			int result = 0;
			
			System.out.print(numberOwn + "x" + numberTwo + "=");
			result = sca.nextInt();
			
			if(result != sum) {
				count++;
				if(count != 3) {
					System.out.println(count + "번 틀렸습니다. 분발하세요.");
				}
				else {
					System.out.println(count + "번 틀렸습니다. 퀴즈 종료합니다.");
					break;
				}
			}
			else
				System.out.println("정답입니다. 잘했습니다.");
		}
		sca.close();
	}
}
