package Report;

public class ArrayUtil {
	public static int [] concat(int[] a, int[] b) {
		int length = a.length + b.length;
		int array[] = new int [length];
		int index = 0;
		
		for(int i=0; i<a.length;i++) {
			array[i] = a[i];
		}
		for(int i=a.length;i<length;i++) {
			array[i] = b[index];
			index++;
		}
		return array;
	}
	public static void print(int [] a) {
		System.out.print("[ ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
	}
	public static void main(String[] args) {
		int [] array1 = {1, 5, 7, 9};
		int [] array2 = {3, 6, -1, 100, 77};
		int [] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}
}
