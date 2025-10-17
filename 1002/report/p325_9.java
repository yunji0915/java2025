package report;
import java.util.Scanner;

class BinaryArray extends BaseArray{
	private int th;
	
	public BinaryArray(int size, int th) { super(size); this.th = th; }
	public void add(int n) {
		if(n > th) super.add(1);
		else super.add(0);
	}
}

public class report_9 {
	public static void main(String[] args) {
		int threshold = 50;
		BinaryArray bArray = new BinaryArray(10, threshold);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		for(int i=0; i<bArray.length(); i++) {
			int n = scanner.nextInt();
			bArray.add(n);
		}
		bArray.print();
		scanner.close();
	}
}
