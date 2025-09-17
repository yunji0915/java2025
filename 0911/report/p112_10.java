import java.util.Scanner;

public class RectangleContain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("(x1,y1), (x2,y2)의 좌표 입력>>");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        // 큰 사각형 범위
        int minX = 10, minY = 10, maxX = 200, maxY = 300;

        if(x1 >= minX && y1 >= minY && x2 <= maxX && y2 <= maxY) {
            System.out.println("사각형 (" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")는 (" + minX + "," + minY + ") (" + maxX + "," + maxY + ") 사각형에 포함된다.");
        } else {
            System.out.println("사각형 (" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")는 (" + minX + "," + minY + ") (" + maxX + "," + maxY + ") 사각형에 포함되지 않는다.");
        }

        sc.close();
    }
}
