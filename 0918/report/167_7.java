public class P167_7 {
	public static void main(String[] args) {
		int array[] = new int[10];
		int sum = 0;
		
		System.out.print("랜덤한 정수들...");
		for(int i=0;i<array.length;i++) {
			int num = (int)(Math.random()*9) + 11;
			array[i] = num;
			sum += array[i];
			System.out.print(array[i] +" ");
		}
		System.out.println();
		System.out.print("평균은 " + (double)sum/array.length);
	}
}
