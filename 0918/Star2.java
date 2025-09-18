package control;

public class Star2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            // 공백 출력
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // 줄바꿈
            System.out.println();
        }
    }
}
