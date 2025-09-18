import java.util.Scanner;

public class P168_8 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		
		System.out.print("정수 몇 개 저장하시겠습니까>>");
		int index = sca.nextInt();
		int array[] = new int [index];
		System.out.print("랜덤한 정수들...");
		
		for(int i=0; i<array.length;i++) {
			int num = (int)(Math.random()*100+1);
			for(int j=0; j<i;j++) {
				if(array[j] == num) {
					num = (int)(Math.random()*100+1);
					j = -1;
				}
			}
			array[i] = num;
			System.out.print(array[i] + " ");
		}
		sca.close();
		}
	}
