package report;
import java.util.Scanner;

class StringStack implements IStack{
	private int size;
	private int top;
	private String[] array;
	
	public StringStack(int size) { this.size = size; top = size-1; array = new String[size]; }
	public int capacity() { return size; }
	public int length() { return array.length;}
	public boolean push(String val) {
		if(top > -1) {
			array[top] = val;
			top--;
			return true;
		}
		else { return false; }
	}
	public String pop() {
		top++;
		return array[top]; 
	}
}

public class report_11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("스택 용량>>");
		int size = scanner.nextInt();
		StringStack st = new StringStack(size);
		
		while(true) {
				System.out.print("문자열 입력>>");
				String s = scanner.next();
				scanner.nextLine();
				if(s.equals("그만")) break;
				
				if(st.push(s) == false) { System.out.println("스택이 꽉 차서 "+ s + " 저장 불가"); }
		}
		System.out.print("스택에 저장된 문자열 팝 : " + st.pop() + " " + st.pop() + " " + st.pop());
		scanner.close();
	}
}
