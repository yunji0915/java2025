// p321_2
package report;

public class SmartTV extends ColorTV{
	private String ip;
	
	public SmartTV(String ip, int size, int color) {super(size, color); this.ip = ip;}
	
	public void printProperty() {
		System.out.print("나의 SmartTV는 " + ip + " 주소의 ");
		super.printProperty();
	}
	public static void main(String[] args) {
		SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000000);
		
		smartTV.printProperty();
	}
}
