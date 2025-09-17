import java.util.Scanner;

public class PointCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("점 (x,y) 좌표 입력>>");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x > 10 && x < 200 && y > 10 && y < 200) {
            System.out.println("(" + x + "," + y + ")는 사각형 안에 있습니다.");
        } else if((x == 10 || x == 200) && (y >= 10 && y <= 200) ||
                  (y == 10 || y == 200) && (x >= 10 && x <= 200)) {
            System.out.println("(" + x + "," + y + ")는 사각형 위에 있습니다.");
        } else {
            System.out.println("(" + x + "," + y + ")는 사각형 밖에 있습니다.");
        }

        sc.close();
    }
}
