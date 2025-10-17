package report;

import java.util.Scanner;

class Add extends Calc{
	
	public void setValue(int a, int b) { this.a = a; this.b = b; }
	public int calculate() {
		errorMsg = null;
		return a + b;
	}
}

class Sub extends Calc{
	public void setValue(int a, int b) { this.a = a; this.b = b; }
	public int calculate() {
		errorMsg = null;
		return a - b;
	}
}

class Mul extends Calc{
	public void setValue(int a, int b) { this.a = a; this.b = b; }
	public int calculate() {
		errorMsg = null;
		return a * b;
	}
}

class Div extends Calc{
	public void setValue(int a, int b) { this.a = a; this.b = b; }
	public int calculate() {
		errorMsg = null;
			return a / b;
	}
}

public class report_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String op;
		int a, b;
		
		while(true) {
			int sum;
			System.out.print("두 정수와 연산자를 입력하시오>>");
			a = scanner.nextInt(); b = scanner.nextInt(); op = scanner.next();
			
			if(op.equals("+")) {
				Add add = new Add();
				add.setValue(a, b);
				sum = add.calculate(); System.out.println("계산 결과 " + sum);
			}
			else if(op.equals("-")) {
				Sub sub = new Sub();
				sub.setValue(a, b);
				sum = sub.calculate(); System.out.println("계산 결과 " + sum);
			}
			else if(op.equals("*")) {
				Mul mul = new Mul();
				mul.setValue(a, b);
				sum = mul.calculate(); System.out.println("계산 결과 " + sum);
			}
			else if(op.equals("/")) {
				Div div = new Div();
				div.setValue(a, b);
				try {
					sum = div.calculate(); System.out.println("계산 결과 " + sum);
				}
				catch(ArithmeticException e) {
					System.out.println("0으로 나눌 수 없음. 프로그램 종료");
					break;
				}	
			}
		}
		scanner.close();
	}
}
