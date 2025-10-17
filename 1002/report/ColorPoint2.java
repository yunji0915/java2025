// p322_4
package report;

public class ColorPoint2 extends ColorPoint{
	
	public ColorPoint2() { super(0, 0, "WHITE"); }
	public ColorPoint2(int x, int y) { super(x, y, "BLACK"); }
	public ColorPoint2(int x, int y, String color) { super(x, y, color); }
	public void set(String color) { super.setColor(color); }
	public void set(int x, int y) { super.setXY(x, y); }
	public double getDistance(ColorPoint2 cp) {
		double distance;
		int x = cp.getx() - super.getx();
		int y = cp.getx() - super.gety();
		
		distance = Math.sqrt((x * x) + (y * y));
		return distance;
	}
	
	public static void main(String[] args) {
		ColorPoint2 zeroPoint = new ColorPoint2();
		System.out.println(zeroPoint.toString() + "입니다.");
		
		ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
		
		cp.set("BLUE");
		cp.set(10, 20);
		System.out.println(cp.toString() + "입니다.");
		ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
		
		System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
	}
}
