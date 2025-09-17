import java.util.Scanner;

public class CalcIf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("두 수를 입력하시오>>");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.print("연산자를 입력하시오(+,-,*,/ 중 하나)>>");
        String op = sc.next();

        double result = 0;

        if(op.equals("+")) {
            result = a + b;
        } else if(op.equals("-")) {
            result = a - b;
        } else if(op.equals("*")) {
            result = a * b;
        } else if(op.equals("/")) {
            if(b != 0) result = a / b;
            else {
                System.out.println("0으로 나눌 수 없습니다.");
                sc.close();
                return;
            }
        } else {
            System.out.println("잘못된 연산자입니다.");
            sc.close();
            return;
        }

        System.out.println(a + " " + op + " " + b + " = " + result);

        sc.close();
    }
}
