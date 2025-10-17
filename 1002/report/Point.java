package report;

public class Point {
	private int x, y;
	
	public Point(int x, int y) { this.x = x; this.y = y; }
	public int getx() {return x;}
	public int gety() {return y;}
	protected void move(int x, int y) { this.x = x; this.y = y;}
}
