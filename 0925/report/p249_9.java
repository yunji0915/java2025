package Report;

import java.util.Scanner;

public class Player {
	Scanner scanner;
	String name [][];
	
	public Player(int count, Scanner scanner) {
		this.name = new String [count][4];
		for(int i=0; i<count; i++) {
			name[i][2] = "0";
		}
		this.scanner = scanner;
	}
	public void pushName() {
		for(int i=0; i<this.name.length; i++) {
			System.out.print("선수 이름>>");
			String name= scanner.next();
			this.name[i][0] = name;
		}
	}
	public String getName(int i) {
		return this.name[i][0];
	}
	public void pushNumber(int index, String number) {
		name[index][1] = number; 
	}
	public int getNumber(int index) {
		return Integer.parseInt(name[index][1]);
	}
	public void pushScore(int i) {
		name[i][2] = Integer.toString(Integer.parseInt(this.name[i][2])+1);
	}
	public int getScore(int i) {
		return Integer.parseInt(name[i][2]);
	}
	public void pushDiff(int i, int diff) {
		this.name[i][3] = Integer.toString(diff);
	}
	public int getDiff(int i) {
		return Integer.parseInt(this.name[i][3]);
	}
}
