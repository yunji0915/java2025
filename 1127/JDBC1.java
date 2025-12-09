package class11_27;

import java.sql.*;

public class JDBC_Ex1 {
    public static void main(String[] args) {
        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB 연결
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sampledb",
                "root",
                "1234"
            );

            System.out.println("DB 연결 완료");

            // 연결 종료
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("DB 연결 에러: " + e.getMessage());
        }
    }
}
