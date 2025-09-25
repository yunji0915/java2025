package Report;

public class Cube {
	
	private int width = 0;
	private int length = 0;
	private int height = 0;
	
	public Cube(int width, int length, int height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}
	public void increase(int width, int length, int height) {
		this.width += width;
		this.length += length;
		this.height += height;
	}
	public int getVolume() {
		return width * length * height;
	}
	public boolean isZero() {
		return getVolume() == 0;
	}
	public static void main(String[] args) {
		Cube cube = new Cube(1, 2, 3);
		System.out.println("큐브의 부피는 " + cube.getVolume());
		cube.increase(1, 2, 3);
		System.out.println("큐브의 부피는 " + cube.getVolume());
		if(cube.isZero()) {
			System.out.println("큐브의 부피는 0");
		}
		else {
			System.out.println("큐브의 부피는 0이 아님");
		}
	}
}
