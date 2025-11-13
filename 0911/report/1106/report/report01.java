import java.util.Scanner;
import java.util.Vector;

public class report_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Vector <Integer> v = new Vector<Integer>();
		
		System.out.print("정수 입력(-1이면 입력 끝)>>");
		while(true) {
			int input = scanner.nextInt();
			
			if(input == -1) { break; }
			
			v.add(input);
		}
		
		int min = v.get(0);
		
		for(int i=1; i<v.size(); i++) {
			if(min > v.get(i)) {
				min = v.get(i);
			}
		}
		
		System.out.println("제일 작은 수는 " + min);
		
		scanner.close();
	}
}
