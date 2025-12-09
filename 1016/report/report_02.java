package generic;

import java.util.Scanner;
import java.util.Vector;

public class Exam_2 {
	private Vector<Integer> v = new Vector<Integer>();//멤버 변수

	public void read() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하세요. 0을 입력하면 종료");
		
		while(true) {
			System.out.print("입력 >> ");
			int num = scanner.nextInt();
			if(num == 0) break;
			v.add(num);
		}
		scanner.close();
	}
	public void changeToZero() {
		for(int i = 0; i<v.size(); i++) {
			if(v.get(i)<0) {
				v.set(i,0);
			}
		}
	}
	public void showAll() {
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i));
		}
		System.out.println();
	}
	public int add() {
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			if(v.get(i)>0) {
				sum+=v.get(i);
			}
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		Exam_2 sp = new Exam_2();
		sp.read();
		sp.changeToZero();
		System.out.print("음수를 0으로 바꾸면 ");
		sp.showAll();
		System.out.println("양수들의 합은 " + sp.add());
	}
}
















