import java.util.Scanner;

public class P167_6 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		int array [] = new int[10];
		int sum = 0;
		
		System.out.print("양의 정수 10개 입력>>");
		for(int i=0;i<array.length;i++) {
			array[i] = sca.nextInt();
		}
		System.out.print("자리수의 합이 9인 것은 ...");
		for(int i=0;i<array.length;i++) {
			sum = array[i] % 10;
			
			sum += (array[i] / 10) % 10;
			sum += (array[i] / 10) / 10;
			if(sum == 9)
				System.out.print(array[i] + " ");
		}
		
		sca.close();
	}

}
