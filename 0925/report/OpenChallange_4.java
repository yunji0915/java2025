import java.util.Scanner;

public class WordGameApp {
	Player player [];
	String word = "아버지";
	int lastIndex = word.length() - 1;
	char lastChar = word.charAt(lastIndex);
	Scanner scanner = new Scanner(System.in);
	boolean state = false;

	public void run() {
		System.out.println("끝말잇기 게임을 시작합니다...");
		System.out.print("게임에 참가하는 인원은 몇명입니까>>");
		int count = scanner.nextInt();
		player = new Player[count];
		
		for(int i=0; i<count; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			String name = scanner.next();
			player[i] = new Player(name); 
		}
		System.out.println("시작하는 단어는 " + word + "입니다");
		while(!state) {
			for(int i=0; i<count; i++) {
				checkSucces(player[i].getWordFromUser(), player[i].getName());
			}
			if(state == true) {
				break;
			}
		}
		for (int i = 0; i < count; i++) {
			player[i].closeScanner();
		}
		scanner.close();
	}
	public void checkSucces(String word, String name) {
		char firstChar = word.charAt(0);
		if(lastChar != firstChar) {
			System.out.println(name + "이 졌습니다.");
			state = true;
		}
		else {
			this.word = word;
			lastIndex = word.length()-1;
			lastChar = word.charAt(lastIndex);
		}
	}	
	
	public static void main(String[] args) {
		WordGameApp game = new WordGameApp();
		game.run();
	}
}
