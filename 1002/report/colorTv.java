// p320._1
package report;

public class ColorTV extends TV{
		private int color;
		
		public ColorTV(int size, int color) {super(size); this.color = color;}
		public void printProperty() {
			System.out.println(getSize() + "인치 " + color + "컬러");
		}
		
	public static void main(String[] args) {
		ColorTV myTv = new ColorTV(65, 65536);
		myTv.printProperty();
	}
}
