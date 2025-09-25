package intro;

class CircleEx {
    int radius;

    public CircleEx(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }
}

public class CircleArray {
    public static void main(String[] args) {
        CircleEx[] ce = new CircleEx[5];
        
        for (int i = 0; i < ce.length; i++) {
            ce[i] = new CircleEx(i + 1);  // 반지름 1~5
        }

        // 각 원의 반지름과 면적 출력
        for (int i = 0; i < ce.length; i++) {
            System.out.println("반지름: " + ce[i].radius + 
                               ", 면적: " + ce[i].getArea());
        }
    }
}
