package Report;

public class TV {
	String name;
	int price = 0;
	int grade = 0;
	public TV(String name, int grade, int price) {
		this.name = name;
		this.price = price;
		this.grade = grade;	
	}
	public void show() {	
		System.out.println(name + "에서 만든 " + price + "만원짜리의 " + grade + "인치 TV");
	}
	
	public static void main(String[] args) {
		TV tv = new TV("Samsung", 50, 300);
		tv.show();
	}
}
