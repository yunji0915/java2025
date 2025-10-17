package report;

import java.util.Scanner;

class Line extends Shape{
	public void draw() {
		System.out.println("Line");
	}
}
class Rect extends Shape{
	public void draw() {
		System.out.println("Rect");
	}
}
class Circle extends Shape{
	public void draw() {
		System.out.println("Circle");
	}
}

public class report_14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Shape head = null;
		Shape tail = null;
		
		System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			int state = scanner.nextInt();
			
			if(state == 4) { 
				System.out.println("Beauty Graphic Editor를 종료합니다.");
				break; }
			
			if(state == 1) {
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int shape = scanner.nextInt();
				
				Shape current = null;
				
				if(shape == 1) { current = new Line(); }
				if(shape == 2) { current = new Rect(); }
				if(shape == 3) { current = new Circle(); }
				
				if(head == null) {
					head = current;
					tail = current;
				}
				else {
					tail.setNext(current);
					tail = current;
				}
			}
			if(state == 2) {
				System.out.print("삭제할 도형의 위치>>");
				int deleteState = scanner.nextInt();
				
				if(deleteState == 1) { head = head.getNext(); }
				else {
					if(head.getNext() != null) {
						Shape current = head;
						Shape previous = null;
						
						for(int i = 0; i < deleteState-1; i++) {
							previous = current;
							current = current.getNext();
						}
						
						if(current != null) {
							previous.setNext(current.getNext());
						}
						else {
							System.out.println("삭제할 수 없습니다.");
						}
					}
					
				}
				
					
				
				
				
			}
				
				
			if(state == 3) {
				Shape current = head;
				while(current != null) {
				current.draw();
				current = current.getNext();
			}
			
			}
		}
	}
}
