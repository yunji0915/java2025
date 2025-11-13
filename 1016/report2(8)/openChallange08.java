package chapter_8;

import java.util.*;
import java.io.*;

class WordCollection {
    private Vector<String> words = new Vector<>();

    public WordCollection(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new FileReader(fileName));
            while (fileScanner.hasNext()) {
                String word = fileScanner.nextLine();
                words.add(word);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            System.exit(0);
        }
    }

    public String getRandomWord() {
        int wordCount = words.size();
        int randomIndex = (int) (Math.random() * wordCount);
        return words.get(randomIndex);
    }
}

public class OpenChallenge_8 {
    private final int HIDDEN_LETTERS = 2;
    private StringBuffer maskedWord;
    private String selectedWord;
    private Scanner inputScanner;
    private int incorrectGuesses;

    public OpenChallenge_8() {
        inputScanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("지금부터 행맨 게임을 시작합니다.");
        WordCollection wordList = new WordCollection("words.txt");
        while (true) {
            selectedWord = wordList.getRandomWord();
            if (selectedWord == null) break;
            maskWord();
            playRound();
            System.out.print("Next(y/n)? ");
            String response = inputScanner.next();
            if (response.equals("n")) break;
        }
    }

    private void maskWord() {
        maskedWord = new StringBuffer(selectedWord);
        Random random = new Random();

        for (int i = 0; i < HIDDEN_LETTERS; i++) {
            int index = random.nextInt(selectedWord.length());
            char charToHide = selectedWord.charAt(index);
            for (int j = 0; j < selectedWord.length(); j++) {
                if (maskedWord.charAt(j) == charToHide) maskedWord.setCharAt(j, '-');
            }
        }
    }

    private void playRound() {
        incorrectGuesses = 0;
        char guess;
        do {
            if (incorrectGuesses == 5) {
                System.out.println("5번 실패 하였습니다.");
                break;
            }
            System.out.println(maskedWord);
            System.out.print(">> ");
            String userInput = inputScanner.next();
            guess = userInput.charAt(0);
        } while (!checkGuess(guess));
        System.out.println(selectedWord);
    }

    private boolean checkGuess(char guess) {
        boolean found = false;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (maskedWord.charAt(i) == '-' && selectedWord.charAt(i) == guess) {
                maskedWord.setCharAt(i, guess);
                found = true;
            }
        }
        if (!found) incorrectGuesses++;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (maskedWord.charAt(i) == '-') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        OpenChallenge_8 app = new OpenChallenge_8();
        app.startGame();
    }
}
