package Report;

public class Account {
	int won [];
	
	public Account(int won) {
		this.won = new int[1];
		this.won[0] = won;
	}
	public void deposit(int won) {
		this.won[0] += won;
	}
	public void deposit(int won[]) {
		int array = 0;
		
		for(int i=0; i<won.length; i++) {
			array += won[i];
		}
		this.won[0] += array;
	}
	public int getBalance() {
		int won = 0;
		for(int i=0; i<this.won.length; i++) {
			won += this.won[i];
		}
		return won;
	}
	public int withdraw(int won) {
		this.won[0] -= won;
		return won;
			
	}
	
	public static void main(String[] args) {
		Account a = new Account(100);
		a.deposit(5000);
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");
		
		int bulk [] = { 100, 500, 200, 700};
		a.deposit(bulk);
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");
		
		int money = 1000;
		int wMoney = a.withdraw(money);
		if (wMoney < money)
			System.out.println(wMoney + "원만 인출");
		else
			System.out.println(wMoney + "원 인출");
		
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");
	}
}
