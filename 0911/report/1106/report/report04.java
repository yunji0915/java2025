package appl;

class Shape{
	public void draw() {
		System.out.println("Shape");
	}
}
class Circle extends Shape{
	public void draw() {
		System.out.println("Circle");
	}
}

public class Exam_4 {
	public static void main(String[] args) {
		Shape shape = new Circle();
		shape.draw();
	}
}
