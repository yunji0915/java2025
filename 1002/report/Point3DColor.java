// p 323_7
package report;

public class Point3DColor extends Point{
	int z;
	String color;
	public Point3DColor(int x, int y, int z, String color) {
		super(x, y); this.z = z; this.color = color;
	}
	public String toString() {
		String to = "(" + super.getx() + "," + super.gety() + "," + z + ")" + color + "점";
        return to;
	}
	public void move(Point3DColor p) {
		move(p.getx(), p.gety()); this.z = p.z;
	}
	public boolean equals(Point3DColor p) {
		if((getx() == p.getx()) && (gety() == p.gety()) && color.equals(p.color)) 
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Point3DColor p = new Point3DColor(10, 20, 30, "RED");
		System.out.println(p.toString() + "입니다.");
		
		Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
		p.move(q);
		System.out.println(p.toString() + "입니다.");
		
		Point3DColor r = new Point3DColor(1, 2, 3, "RED");
		if(p.equals(r)) { System.out.println("예. 같은 위치 같은 색깔의 점입니다.");}
		else { System.out.println("아니오"); }
	}
}
