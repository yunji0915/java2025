package class11_27;

import java.sql.*;
import java.util.Scanner;

public class JDBC_Ex2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB 연결
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC&useSSL=false",
                "root",
                "1234"
            );
            System.out.println("DB 연결 완료");

            stmt = conn.createStatement();

            while (true) {
                System.out.println("\n===== 메뉴 =====");
                System.out.println("1. SELECT (전체 조회)");
                System.out.println("2. UPDATE (특정 id의 dept를 Computer로 변경)");
                System.out.println("3. INSERT (id, name, dept 입력받아 추가)");
                System.out.println("4. DELETE (dept=SW 삭제)");
                System.out.println("0. 종료");
                System.out.print("선택 >> ");
                int choice = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기

                if (choice == 0) {
                    System.out.println("프로그램 종료");
                    break;
                }

                switch (choice) {
                    case 1: // SELECT
                        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
                        while (rs.next()) {
                            System.out.println(
                                rs.getString("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("dept")
                            );
                        }
                        rs.close();
                        break;

                    case 2: // UPDATE
                        System.out.print("dept를 Computer로 바꿀 학생 id 입력 >> ");
                        String updateId = sc.nextLine();
                        int updated = stmt.executeUpdate(
                            "UPDATE student SET dept='Computer' WHERE id='" + updateId + "'"
                        );
                        System.out.println(updated + "개의 레코드가 수정되었습니다.");
                        break;

                    case 3: // INSERT
                        System.out.print("새로운 학생 id 입력 >> ");
                        String newId = sc.nextLine();
                        System.out.print("새로운 학생 이름 입력 >> ");
                        String newName = sc.nextLine();
                        System.out.print("새로운 학생 dept 입력 >> ");
                        String newDept = sc.nextLine();

                        int inserted = stmt.executeUpdate(
                            "INSERT INTO student (id, name, dept) VALUES ('" +
                            newId + "','" + newName + "','" + newDept + "')"
                        );
                        System.out.println(inserted + "개의 레코드가 추가되었습니다.");
                        break;

                    case 4: // DELETE
                        int deleted = stmt.executeUpdate("DELETE FROM student WHERE dept='SW'");
                        System.out.println(deleted + "개의 레코드가 삭제되었습니다.");
                        break;

                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("DB 연결 에러: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
