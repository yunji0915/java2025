package report;

import java.util.Scanner;

abstract class Box {
	protected int size;
	
	public Box(int size) { this.size = size; }
	public boolean isEmpty() { return size == 0; }
	public abstract void consume(int count);
	public abstract void print();
}
class IngredientBox extends Box{
	private String name;
	
	public void getName() { System.out.print(name + " "); }
	public int getSize() { return size; }
	
	public IngredientBox(String name, int size) { super(size); this.name = name; }
	
	public void consume(int count) {
			if(count == 1 && name.equals("커피")) { this.size -= 1; }
			if(count == 1 && name.equals("프림")) { this.size -= 1; }
			if(count == 1 && name.equals("설탕")) { this.size -= 1; }
			if(count == 2 && name.equals("커피")) { this.size -= 1; }
			if(count == 2 && name.equals("설탕")) { this.size -= 1; }
			if(count == 3 && name.equals("커피")) { this.size -= 1; }
	}
	public void print() {
		for(int i=0; i<size; i++) {
			System.out.print("*");
			}
		System.out.println(size);
		}
}
public class report_8{
	public static void main(String[] args) {
		IngredientBox coffee = new IngredientBox("커피", 5);
		IngredientBox primm = new IngredientBox("프림", 5);
		IngredientBox suger = new IngredientBox("설탕", 5);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*****청춘 커피 자판기 입니다.*****");
		
		while(true) {
			coffee.getName(); coffee.print(); coffee.getSize();
			primm.getName(); primm.print(); primm.getSize();
			suger.getName(); suger.print(); suger.getSize();
			
			System.out.print("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>");
			int state = scanner.nextInt();
			
			if(state == 4) { System.out.println("청춘 커피 자판기 프로그램을 종료합니다"); break; }
			
			if(coffee.isEmpty() == true || primm.isEmpty() == true || suger.isEmpty() == true) {
				System.out.println("원료가 부족합니다.");
			}
			if(state == 1 && coffee.isEmpty() == false) { coffee.consume(state); primm.consume(state);  suger.consume(state);}
			if(state == 2 && primm.isEmpty() == false) { coffee.consume(state); suger.consume(state); }
			if(state == 3 && suger.isEmpty() == false) { coffee.consume(state); }
		}
		scanner.close();
	}
	
}

