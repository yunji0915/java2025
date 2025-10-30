package main;

import java.util.Scanner;

class Player2{
	protected String name;
	protected int score;
	protected boolean state = true;
	protected int result;
	
	public Player2(String name) { this.name = name; }
	
	public String getName() { return name; }
	public int getScore() { return score; }
	public boolean getState () { return state; }
	public int getResult() { return result; }
	
	public void setResult(int result) { this.result = result; }
	public void setScore(int score) { this.score = score; }
	public void setState(boolean state) { this.state = state; }
	
	
	public void addScore() { score++; }
}

class NumberExpectationGame{
	static Scanner scanner = new Scanner(System.in);
	static private int min;
	static private String loserName;
	
	public static void RandomNum(int[] array) {
		
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*10)+1;
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void TestNum(int[] array, Player2[] py) {
		for(int i=0; i<py.length; i++) {
			if(py[i].getState() == true) {
				for(int j=0; j<array.length; j++) {
					if(py[i].getResult() == array[j]) {
						py[i].addScore();
					}
				}
			}
		}
	}
	
	public static void PrintResultCount(Player2[] py) {;
		for(int i=0; i<py.length; i++) {
			if(py[i].getState()==true) {
				System.out.println("[" + py[i].getName() + "] 맞춘 개수: " + py[i].getScore());
				}
		}
		MinScore(py);
	}
	
	public static void MinScore(Player2[] py) {
		min = py[0].getScore();
		for(int i=1; i<py.length-1; i++) {
			if(min > py[i].getScore()) {
				min = py[i].getScore();
			}
		}
	}
	
	public static void PrintLoser(Player2[] py) {
		for(int i=0; i<py.length; i++) {
			if(min != py[i].getScore()) { py[i].setState(false); }
		}
		System.out.print("현재 패자들 : ");
		for(int i=0; i<py.length; i++) {
			if(py[i].getState()) {
				System.out.print(py[i].getName() + " ");
			}
		}
		System.out.println();
	}
	
	public static boolean GradeLoser(Player2[] py) {
		int count = 0;
		for(int i=0; i<py.length; i++){
			if(py[i].getState()) { count++; }
		}
		
		switch(count) {
		case 0 :
			return false;
		case 1 :
			return false;
		default:
			return true;
		}
		
		
	}
	
	public static void TestState (Player2[] py) {
		for(int i=0; i<py.length; i++) {
			if(py[i].getState()) { loserName = py[i].getName(); }
		}
	}
	public static void IntContect(Player2[] py) {
		boolean contectState = false; 
		for(int i=0; i<py.length; i++) {
			if(py[i].getState()) {
				do {
					try {
						System.out.print("[" + py[i].getName() + "] 정수 선택(1~10)>>");
						int n = Integer.parseInt(scanner.nextLine());
					
						if(n > 0 && n < 11) {
							py[i].setResult(n);
							contectState = true;
						}
						else {
							System.out.println("1에서 10사이의 정수를 입력하세요.");
						}
					}
					catch(NumberFormatException e) {
						System.out.println("정수를 입력해주세요.");
					}
				}
				while(!contectState);
			}
		}
	}
	
	public static void run() {
		System.out.print("게임에 참여할 선수들 이름>>");
		String playerName = scanner.nextLine();
		String[] name = playerName.split(" ");
		Player2[] py = new Player2[name.length];
		
		int[] randomNum = new int[15];
		boolean gameState = true;
		
		for(int i=0; i<name.length; i++) { py[i] = new Player2(name[i]); }
		
		IntContect(py);
		
		while(true) {
			
			if(!gameState) {
				System.out.println();
				TestState(py);
				System.out.println("최종 패자는 " + loserName + "입니다.");
				break;
			}
			System.out.print("Enter키 입력>>");
			scanner.nextLine();
			
			RandomNum(randomNum);
			TestNum(randomNum, py);
			PrintResultCount(py);
			PrintLoser(py);
			gameState = GradeLoser(py);
		}
	}
}

public class report_12 {
	public static void main(String[] args) {
		NumberExpectationGame.run();
	}
}
