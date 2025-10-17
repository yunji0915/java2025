package report;

interface Shape2 {
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void readraw() {
		System.out.print("--- 다시 그립니다. ");
		draw();
	}
}
