import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	
	// SQLite DB 파일 경로 (프로젝트 폴더에 'tourism.db 파일 생성')
	private static final String DB_URL = "jdbc:sqlite:tourism.db";
	
	/**
	 * DB 연결 객체를 반환합니다.
	 */
	public static Connection connect() {
		Connection conn = null;
		try {
			//SQLite JDBC 드라이버 로드
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(DB_URL);
			System.out.println("DB 연결 성공.");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 오류:  " + e.getMessage());
		}
		return conn;
	}
	
	/**
	 *  시스템에 필요한 테이블들을 생성합니다.
	 *  (10,000명 이상의 유저와 예약 데이터를 시뮬레이션할 수 있는 구조)
	 */
	public static void initializeDB() {
		try (Connection conn = connect();
			Statement stmt = conn.createStatement()) {
			
			// 1. 사용자/관리자 정보 테이블 (USER_INFO)
			String sqlUser = "CREATE TABLE IF NOT EXISTS USER_INFO (" +
                    "id TEXT PRIMARY KEY," +
                    "password TEXT NOT NULL," +
                    "name TEXT NOT NULL," +
                    "role TEXT NOT NULL)"; // 'ADMIN' 또는 'USER'
			stmt.execute(sqlUser);
			
			// 2. 예약 정보 테이블 (RESERVATION) - 10000건 이상의 데이터 관리
            String sqlReservation = "CREATE TABLE IF NOT EXISTS RESERVATION (" +
                                    "res_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    "user_id TEXT NOT NULL," +
                                    "visit_date TEXT NOT NULL," +
                                    "area TEXT NOT NULL," +
                                    "headcount INTEGER NOT NULL," +
                                    "status TEXT NOT NULL)"; // 'CONFIRMED' 또는 'CANCELLED'
            stmt.execute(sqlReservation);
            
            // 초기 관리자 계정 생성 (테스트용)
            String adminInsert = "INSERT OR IGNORE INTO USER_INFO (id, password, name, role) " +
                                 "VALUES ('admin', '1234', '관리자', 'ADMIN')";
            stmt.execute(adminInsert);
            
            System.out.println("DB 초기화 및 테이블 생성 완료.");

        } catch (SQLException e) {
            System.out.println("DB 초기화 오류: " + e.getMessage());
		}
	}
}
