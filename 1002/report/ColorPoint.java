// p321_3
package report;

public class ColorPoint extends Point{
	String color;
	
	public ColorPoint(int x, int y, String color) { super(x, y); this.color = color; }
	public void setXY(int x, int y) { super.move(x, y); }
	public void setColor(String color) { this.color = color; }
	public String toString() {
		String to = color + "색의 (" + getx() + ", " + gety() + ")의 점";
		return to;
	}
	
	public static void main(String[] args) {
		ColorPoint cp = new ColorPoint(5, 5, "RED");
		cp.setXY(10, 20);
		cp.setColor("BLUE");
		String str = cp.toString();
		System.out.println(str + "입니다.");
	}
}
