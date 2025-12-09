package appl;

import java.util.Random;
import java.util.Scanner;

public class Exam_10 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Random rand = new Random();
		
		String[] words = {"happy", "morning", "package", "together"};
		System.out.println("10초 안에 단어를 맞추세요!!");
		
		while(true) {
			String original = words[rand.nextInt(words.length)];
			String shuffled = shuffleWord(original, rand);
			
			System.out.println(shuffled);
			System.out.print(">>");
			
			long start = System.currentTimeMillis();
			String answer = scn.nextLine();
			long end = System.currentTimeMillis();
			
			if(answer.equalsIgnoreCase("그만")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			long elapsed = (end - start) / 1000;
			
			if(elapsed >10) {
				System.out.println("시간 초과! [" +elapsed + "초]");
			}else if(answer.equalsIgnoreCase(original)) {
				System.out.println("정답입니다. ["+ elapsed + "초]");
			}else {
				System.out.println("오답입니다. 정답은 "+original+" 입니다.");
			}
		}
		scn.close();
	}
	
	public static String shuffleWord(String word, Random rand) {
		char[] chars = word.toCharArray();
		for(int i = 0; i<chars.length; i++) {
			int j = rand.nextInt(chars.length);
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}
	
}
