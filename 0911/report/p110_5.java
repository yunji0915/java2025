import java.util.Scanner;

public class AttendanceScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 학생 입력
        System.out.print("학생1>>");
        String name1 = sc.next();
        int late1 = sc.nextInt();
        int absent1 = sc.nextInt();

        // 두 번째 학생 입력
        System.out.print("학생2>>");
        String name2 = sc.next();
        int late2 = sc.nextInt();
        int absent2 = sc.nextInt();

        // 점수 계산
        int score1 = 100 - (late1 * 3 + absent1 * 8);
        int score2 = 100 - (late2 * 3 + absent2 * 8);

        System.out.println(name1 + "의 감점은 " + (late1 * 3 + absent1 * 8) + ", 출석 점수는 " + score1);
        System.out.println(name2 + "의 감점은 " + (late2 * 3 + absent2 * 8) + ", 출석 점수는 " + score2);

        // 비교
        if(score1 > score2) {
            System.out.println(name1 + "의 출석 점수가 더 높음.");
        } else if(score2 > score1) {
            System.out.println(name2 + "의 출석 점수가 더 높음.");
        } else {
            System.out.println("점수 동일함.");
        }

        sc.close();
    }
}
