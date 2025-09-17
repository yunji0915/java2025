import java.util.Scanner;

public class BirthdayCandle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("나이를 입력하세요(0 입력시 종료)>>");
            int age = sc.nextInt();
            if(age == 0) break;

            int red = age / 10;
            int blue = (age % 10) / 5;
            int yellow = (age % 5);

            int total = red + blue + yellow;
            System.out.println("빨간 초: " + red + ", 파란 초: " + blue + ", 노란 초: " + yellow + ", 총 " + total + "개 필요합니다.");
        }

        sc.close();
    }
}
