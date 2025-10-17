package report;

class Circle2 implements Shape2{
	private int raidus;
	
	public Circle2 (int raidus) { this.raidus = raidus; }
	public void draw() { System.out.println("반지름이 " + raidus + "인 원"); }
	public double getArea() { return PI * raidus * raidus; }
}

class Oval implements Shape2{
	int a, b;
	
	public Oval(int a, int b) { this.a = a; this.b = b; }
	public void draw() { System.out.println(a + "x" + b +"에 내접하는 타원"); }
	public double getArea() { return a*b*PI; }
}

class Rect2 implements Shape2{
	int a, b;
	
	public Rect2(int a, int b) { this.a = a; this.b = b; }
	public void draw() { System.out.println(a + "x" + b + "크기의 사각형"); }
	public double getArea() { return a*b; }
}

public class report_15 {
	public static void main(String[] args) {
		Shape2[] list = new Shape2[3];
		
		list[0] = new Circle2(5);
		list[1] = new Oval(20, 30);
		list[2] = new Rect2(10, 40);
		
		for(int i = 0; i < list.length; i++) list[i].readraw();
		for(int i = 0; i < list.length; i++) System.out.println("면적은 " + list[i].getArea());
	}		
}
