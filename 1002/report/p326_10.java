package report;
import java.util.Scanner;

class SortedArray extends BaseArray{
	public SortedArray (int size) { super(size); }
	
	public void add(int n) {
		super.add(n);
		
		sort();
	}
	
	public void sort() {
		int save;
		for(int i=0; i<nextIndex - 1; i++) {
			for(int j = 0; j<nextIndex - 1; j++) {
				if(array[j] > array[j+1]) {
					save = array[j];
					array[j] = array[j+1];
					array[j+1] = save;
				}
			}
		}
	}
}

public class report_10 {
	public static void main(String[] args) {
		SortedArray sArray = new SortedArray(10);
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		
		for(int i=0; i<sArray.length(); i++) {
			int n = scanner.nextInt();
			sArray.add(n);
		}
		sArray.print();
		scanner.close();
	}
	
}
