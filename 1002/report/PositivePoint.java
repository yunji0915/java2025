// 323_6
package report;

public class PositivePoint extends Point{
	
	public PositivePoint(int x, int y) {
		super(x, y);
		if(x<0 && y<0) {
			super.move(1, 1);
		}
	}
	
	public String toString() {
		String to = "(" + super.getx() + "," + super.gety() + ")의 점";
		return to;
	}
	
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint(10, 10);
		p.move(5, 5);
		System.out.println(p.toString() + "입니다.");
		
		p.move(2, -2);
		System.out.println(p.toString() + "입니다.");
		
		PositivePoint q = new PositivePoint(-10, -10);
		
		System.out.println(q.toString() + "입니다.");
	}
}
