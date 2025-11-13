import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

class Vocabulary {
    private String englishWord;
    private String koreanWord;

    public Vocabulary(String englishWord, String koreanWord) {
        this.englishWord = englishWord;
        this.koreanWord = koreanWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getKoreanWord() {
        return koreanWord;
    }
}

public class OpenChallenge_7 {
    private String quizName;
    private Vector<Vocabulary> wordList;

    public OpenChallenge_7(String quizName) {
        this.quizName = quizName;
        wordList = new Vector<>();
        wordList.add(new Vocabulary("love", "사랑"));
        wordList.add(new Vocabulary("animal", "동물"));
        wordList.add(new Vocabulary("emotion", "감정"));
        wordList.add(new Vocabulary("human", "인간"));
        wordList.add(new Vocabulary("stock", "주식"));
        wordList.add(new Vocabulary("trade", "거래"));
        wordList.add(new Vocabulary("society", "사회"));
        wordList.add(new Vocabulary("baby", "아기"));
        wordList.add(new Vocabulary("honey", "꿀"));
        wordList.add(new Vocabulary("doll", "인형"));
        wordList.add(new Vocabulary("bear", "곰"));
        wordList.add(new Vocabulary("picture", "사진"));
        wordList.add(new Vocabulary("painting", "그림"));
        wordList.add(new Vocabulary("fault", "오류"));
        wordList.add(new Vocabulary("example", "보기"));
        wordList.add(new Vocabulary("eye", "눈"));
        wordList.add(new Vocabulary("statue", "조각상"));
    }

    private int generateOptions(int options[], int correctIndex) {
        int indices[] = {-1, -1, -1, -1};
        int randomIndex;
        for (int i = 0; i < indices.length; i++) {
            do {
                randomIndex = (int) (Math.random() * wordList.size());
            } while (randomIndex == correctIndex || isDuplicate(indices, randomIndex));
            indices[i] = randomIndex;
        }

        for (int i = 0; i < indices.length; i++)
            options[i] = indices[i];
        return (int) (Math.random() * indices.length);
    }

    private boolean isDuplicate(int indices[], int index) {
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] == index)
                return true;
        }
        return false;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\"" + quizName + "\" 퀴즈를 시작합니다. -1을 입력하면 종료됩니다.");
        System.out.println("현재 " + wordList.size() + "개의 단어가 있습니다.");
        while (true) {
            int correctIndex = (int) (Math.random() * wordList.size());
            String englishWord = wordList.get(correctIndex).getEnglishWord();

            int options[] = new int[4];
            int correctOption = generateOptions(options, correctIndex);
            options[correctOption] = correctIndex;

            System.out.println(englishWord + "?");
            for (int i = 0; i < options.length; i++)
                System.out.print("(" + (i + 1) + ")" + wordList.get(options[i]).getKoreanWord() + " ");
            System.out.print(":>");

            try {
                int userChoice = scanner.nextInt();
                if (userChoice == -1) {
                    break;
                }

                userChoice--;
                if (userChoice == correctOption)
                    System.out.println("Excellent!!");
                else
                    System.out.println("No!!");
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("숫자를 입력하세요!!");
            }
        }
        System.out.println("\"" + quizName + "\"를 종료합니다...");
        scanner.close();
    }

    public static void main(String[] args) {
        OpenChallenge_7 quiz = new OpenChallenge_7("명품영어");
        quiz.startQuiz();
    }
}
