package Report;

import java.util.Scanner;

public class GuessGame {
	Scanner scanner;
	Player player;
	int count = 0;
	int result = 0;
	
	public GuessGame(Scanner scanner) {
		this.scanner = scanner;
	}
	public int randomNumber() {
		this.result = (int)(Math.random()*100+1);
		System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");
		
		return result;
	}
	public void start() {
		System.out.print("게임에 참여할 선수 수>>");
		this.count = scanner.nextInt();
		scanner.nextLine();
		this.player = new Player(count, scanner);
		player.pushName();
		
	}
	public void catchNumber() {
		for(int i=0; i<count; i++) {
			System.out.print(player.getName(i) + ">>");
			int number = scanner.nextInt();
			player.pushNumber(i, Integer.toString(number));
			scanner.nextLine();
		}
	}
	public void answer() {
		int index = 0;
		int value = 100;
		for(int i=0;i<count;i++) {
			int diff = Math.abs(result-player.getNumber(i));
			player.pushDiff(i, diff);
				if(diff<value) {
					value = diff;
					index = i;
			}
		}
		System.out.println("정답은 " + result + ". " + player.getName(index) + "이 이겼습니다. 승점 1점 확보!");
		player.pushScore(index);
	}
	public void last() {
		int index = 0;
		int score = 0;
		for(int i=0; i<count; i++) {
			System.out.print(player.getName(i) + ":" + player.getScore(i) + " ");
		}
		System.out.println();
		for(int i=0; i<count; i++) {
			if(score<player.getScore(i)) {
				score = player.getScore(i);
				index = i;
			}
		}
		System.out.println(player.getName(index) + "이 최종 승리하였습니다.");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GuessGame game = new GuessGame(scanner);
		System.out.println("*** 예측 게임을 시작합니다. ***");
		game.start();
		while(true) {
			game.randomNumber();
			game.catchNumber();
			game.answer();
			System.out.print("계속하려면 yes 입력>>");
			String state = scanner.next();
			scanner.nextLine();
			
			if(!state.equals("yes")) {
				break;
			}
		}
		game.last();
		scanner.close();
	}
}
