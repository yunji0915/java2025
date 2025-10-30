package main;

import java.util.Scanner;

class Player{
	protected String name;
	
	public Player(String name) { this.name = name; }
	
	public String getName() { return name; }
}

class GameblingGame{
	static Scanner scanner = new Scanner(System.in);
	
	public static boolean randomInt() {
		int own = (int)(Math.random()*3)+1;
		int two = (int)(Math.random()*3)+1;
		int three = (int)(Math.random()*3)+1;
		
		System.out.print("   " + own + "  " + two + "  " + three + "  ");
		if(own == two && two == three) { return true; }
		else { return false; }
	}
	
	public static void run() {
		int i = 0;
		System.out.print("겜블링 게임에 참여할 선수 숫자>>");
		int count = scanner.nextInt();
		Player[] py = new Player[count];
		scanner.nextLine();
		
		for(int j=0; j<count; j++) {
			System.out.print(j+1 + "번째 선수 이름>>");
			String name = scanner.nextLine();
			py[j] = new Player(name);
		}
		while(true) {
			
			if(i==3) { i = 0; }
			
			System.out.print("[" + py[i].getName() + "]:");
			String enter = scanner.nextLine();
				
			boolean state = randomInt();
			
			if(state) {
				System.out.println(py[i].getName() + "님이 이겼습니다!");
				break;
			}
			else {
				System.out.println("아쉽군요!"); 
				i++;
			}
			
		}
	}
}
public class report_11 {
	public static void main(String[] args) {
		GameblingGame.run();
	}
}
