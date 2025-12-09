package generic;
import java.util.*;

public class Exam_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> numbers = new Vector<>();
		
		System.out.println("양의 정수를 입력하세요. -1을 입력하면 종료");
		
		while(true) {
			System.out.print("입력 >> ");
			int input = scanner.nextInt();
			
			if(input == -1)
				break;
			if(input > 0)
				numbers.add(input);
			else
				System.out.println("양의 정수만 입력하세요");
		}
		if(numbers.isEmpty()) {
			System.out.println("입력된 양의 정수가 없습니다.");
		} else {
			int min = numbers.get(0);
			for(int num : numbers) {
				if(num < min) {
					min = num;
				}
			}
			System.out.println("가장 작은 수는 : " + min);
		}
		scanner.close();
	}
}









