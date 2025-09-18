import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OpenChallenge_3 {
	
	public static void main(String[] args) {
		int min, max;
		int card;
		Random r = new Random();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			int i=0;
			min = 0; 
			max = 99;		
			card = r.nextInt(100);
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			
			while(true) {
				System.out.println(min +"-" + max);
				System.out.print(i+1+">>");
				int n=0;

					n= scanner.nextInt();
				
				if(n>max || n<min)
					System.out.println("범위를 벗어났어요");
				else {
					if(n==card) {
						System.out.println("맞았습니다.");
						break;
					}
					else if(n>card){
						System.out.println("더 낮게");
						max = n;					
					}
					else {
						System.out.println("더 높게");
						min = n;									
					}
				}
				i++;
			}
			
			System.out.print("다시하시겠습니까(y/n)>>");
			if(scanner.next().equals("n"))
				break;
		}	
		scanner.close();
	}
}
