import java.util.Scanner;

public class P172_16 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		int sum = 0;
		int count = 0;
		
		System.out.print("양의 정수를 입력하세요. -1은 입력 끝>>");
		String array  = sca.nextLine();
		String num [] = array.split(" ");
		
		for(int i=0; i<num.length; i++) {
			try {
				int j = Integer.parseInt(num[i]);
				
				if(j == -1) {
					break;
					}
				if(j > 0) {
					sum += j; count++;
				}
				else
					System.out.println(num[i] + " 제외");
			}
			catch(NumberFormatException e) {
				System.out.println(num[i] + " 제외");
			}
		}
		int avg = sum / count;
		System.out.println("평균은 " + avg);
		sca.close();
	}
}
