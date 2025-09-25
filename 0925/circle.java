package intro;

public class circle {
	int radius;
	String name;
	
	double getArea() {
		return 3.14*radius*radius;
	}
	public static void main(String[] args) {
		circle c1 = new circle();
		c1.radius = 5;
		double c1Area = c1.getArea();
		System.out.println("원의 면적: " + c1Area);
	}
}
