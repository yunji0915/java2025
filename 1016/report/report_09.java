package main;

import java.util.Scanner;
import java.util.Random;

public class report_09 {
    private final static int ROWS = 5;
    private final static int COLS = 5;
    private final static char EMPTY_CHAR = '-';
    private char[][] board = new char[ROWS][COLS];
    private Random rand = new Random();

    public report_09() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = EMPTY_CHAR;
            }
        }
    }

    private void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void placeWord(int row, int col, int direction, String word) {
        int dRow = 0, dCol = 0;
        switch (direction) {
            case 0: dRow = -1; break;
            case 1: dRow = -1; dCol = 1; break;
            case 2: dCol = 1; break;
            case 3: dRow = 1; dCol = 1; break;
            case 4: dRow = 1; break;
            case 5: dRow = 1; dCol = -1; break;
            case 6: dCol = -1; break;
            case 7: dRow = -1; dCol = -1; break;
        }

        for (int i = 0; i < word.length(); i++) {
            board[row][col] = word.charAt(i);
            row += dRow;
            col += dCol;
        }
    }

    private boolean canPlaceWord(int row, int col, int direction, int length) {
        int dRow = 0, dCol = 0;
        switch (direction) {
            case 0: dRow = -1; break;
            case 1: dRow = -1; dCol = 1; break;
            case 2: dCol = 1; break;
            case 3: dRow = 1; dCol = 1; break;
            case 4: dRow = 1; break;
            case 5: dRow = 1; dCol = -1; break;
            case 6: dCol = -1; break;
            case 7: dRow = -1; dCol = -1; break;
        }

        for (int i = 0; i < length; i++) {
            if (row < 0 || row >= ROWS || col < 0 || col >= COLS || board[row][col] != EMPTY_CHAR) {
                return false;
            }
            row += dRow;
            col += dCol;
        }
        return true;
    }

    private void randomlyPlaceWord(String word) {
        while (true) {
            int row = rand.nextInt(ROWS);
            int col = rand.nextInt(COLS);
            int[] directions = rand.ints(0, 8).distinct().limit(8).toArray();

            for (int direction : directions) {
                if (canPlaceWord(row, col, direction, word.length())) {
                    placeWord(row, col, direction, word);
                    return;
                }
            }
        }
    }

    private void fillEmptySpaces() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == EMPTY_CHAR) {
                    board[i][j] = (char) ('a' + rand.nextInt(26));
                }
            }
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("단어>>");
            String word = scanner.next();
            if (word.equals("그만")) break;
            else if (word.length() > COLS || word.length() > ROWS) {
                System.out.println("단어가 보드 크기보다 깁니다.");
                continue;
            }
            initializeBoard();
            randomlyPlaceWord(word);
            fillEmptySpaces();
            displayBoard();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        report_09 game = new report_09();
        game.startGame();
    }
}
