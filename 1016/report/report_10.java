package main;

import java.util.Scanner;
import java.util.Random;

class RandomUtil {
    public static int[] RandomInteger(int count) {
        int[] random = new int[count];
        
      
        for (int i = 0; i < count; i++) {
            random[i] = i;
        }
        
       
        Random rand = new Random();
        for (int i = count - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = random[i];
            random[i] = random[j];
            random[j] = temp;
        }
        
        return random;
    }
}

class GuessingGame {
    static int count;
    static String[] words;
    static Scanner scanner = new Scanner(System.in);
    
    public static void checkTime(double startTime, String question) {
    	double endTime = System.currentTimeMillis();
    	double elapsedTime = (endTime - startTime) / 1000;
    	
    	if (elapsedTime <= 10) {
    		System.out.println("성공!!! " + elapsedTime + "초 경과");
    	} else {
    		System.out.println("실패!!! " + question + " 입니다." + elapsedTime + "초 경과");
    	}
    }


    public static void wordInput() {
        System.out.print("입력할 단어의 개수: ");
        count = scanner.nextInt();
        
        words = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("단어 입력: ");
            words[i] = scanner.next();
        }    
    }
    
    public static String randomizeString(String word) {
        char[] chars = word.toCharArray();
        Random rand = new Random();
        
        for (int i = chars.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        
        return new String(chars);
    }
    
    public static void run() {
        wordInput();
        int[] randomIndex = RandomUtil.RandomInteger(count);
        int index = 0;
        System.out.println("10초 안에 단어를 맞추세요!!");
        
        while (true) {
        	String question = words[randomIndex[index++]];
            String shuffledWord = randomizeString(question);
            System.out.println("문제: " + shuffledWord);
            
            double startTime = System.currentTimeMillis();
            
            System.out.print(">> ");
            String result = scanner.next();
            if(result.equals("그만")) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (result.equals(question)) {
                checkTime(startTime, question);
            } else {
                System.out.println("실패!!! 정답은 '" + question + "' 입니다.");
            }
            
            if (index >= count) {
                System.out.println("모든 단어를 사용했습니다. 게임을 종료합니다.");
                break;
            }
        }
    }
}

public class report_10 {
    public static void main(String[] args) {
        GuessingGame.run();
    }
}
