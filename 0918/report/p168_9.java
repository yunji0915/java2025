public class P168_9 {
	public static void main(String[] args) {
		int array [][] = new int [4][4];
		
		System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
		for(int i=0; i<array.length;i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] = (int)(Math.random()*255);
				System.out.printf("%4d", array[i][j]);
			}
			System.out.println();
		}
	}
}
