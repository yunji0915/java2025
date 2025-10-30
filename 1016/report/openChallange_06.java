package main;

import java.util.Scanner;

public class OpenChallenge_6 {
    private int charCount[] = new int[26];

    public OpenChallenge_6() {
        for (int i = 0; i < charCount.length; i++)
            charCount[i] = 0;
    }

    public void execute() {
        String inputText = getInput();
        buildHistogram(inputText);
        displayHistogram();
    }

    private void buildHistogram(String text) {
        String upperText = text.toUpperCase();
        for (int i = 0; i < upperText.length(); i++) {
            char character = upperText.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                int position = character - 'A';
                charCount[position]++;
            }
        }
    }

    private void displayHistogram() {
        for (int i = 0; i < charCount.length; i++) {
            System.out.print((char) ('A' + i));
            for (int j = 0; j < charCount[i]; j++)
                System.out.print('-');
            System.out.println();
        }
    }

    private String getInput() {
        StringBuffer buffer = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.length() == 1 && line.charAt(0) == ';')
                break;
            buffer.append(line);
        }
        scanner.close();
        return buffer.toString();
    }

    public static void main(String[] args) {
        OpenChallenge_6 app = new OpenChallenge_6();
        app.execute();
    }
}
