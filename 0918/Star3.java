package control;

public class Star3 {
    public static void main(String[] args) {
        int N = 5; // 줄 수

        for (int i = 1; i <= N; i++) {
            // 공백 출력
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }
            // 별 출력 (2*i - 1개)
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            // 줄바꿈
            System.out.println();
        }
    }
}
