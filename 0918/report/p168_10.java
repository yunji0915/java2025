import java.util.Scanner;

public class P168_10 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		int array [][] = new int [4][4];
		
			System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
			for(int i=0; i<array.length;i++) {
				for(int j=0; j<array[i].length; j++) {
					array[i][j] = (int)(Math.random()*255);
					System.out.printf("%4d", array[i][j]);
				}
				System.out.println();
			}
			System.out.print("임계값 입력>>");
			int value = sca.nextInt();
			
			for(int i=0; i<array.length; i++) {
				for(int j=0; j<array[i].length; j++) {
					if(array[i][j] <= value) {
						array[i][j] = 0;
						System.out.printf("%4d", array[i][j]);
					}
					else {
						array[i][j] = 255;
						System.out.printf("%4d", array[i][j]);
					}					
				}
				System.out.println();
			}
			sca.close();
		}
	}
