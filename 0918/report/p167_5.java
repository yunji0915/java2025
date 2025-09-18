import java.util.Scanner;

public class P167_5 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		int array [] = new int[10];
		
		System.out.print("양의 정수 10개 입력>>");
		for(int i=0; i<array.length;i++) {
			array[i] = sca.nextInt();
		}
		
		System.out.print("3의 배수는...");
		for(int i : array) {
			if(i % 3 == 0)
			System.out.print(i + " ");
		}
		
	
		sca.close();	
	}
}
