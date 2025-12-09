import javax.swing.table.AbstractTableModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ReservationTableModel extends AbstractTableModel {
    
    // 테이블 헤더 (컬럼 이름)
    private final String[] columnNames = {"ID", "예약자", "방문일", "구역", "인원", "상태"};
    
    // 실제 데이터 리스트 (JTable에 표시될 내용)
    private List<Vector<String>> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }
    
    /**
     * DB에서 예약 데이터를 조회하여 테이블에 로드합니다.
     */
    public void loadFromDB() {
        data.clear(); // 기존 데이터 제거
        String sql = "SELECT * FROM RESERVATION ORDER BY visit_date DESC LIMIT 100"; // 최근 100건만 로드

        try (Connection conn = DBConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString("res_id"));
                row.add(rs.getString("user_id"));
                row.add(rs.getString("visit_date"));
                row.add(rs.getString("area"));
                row.add(rs.getString("headcount"));
                row.add(rs.getString("status"));
                data.add(row);
            }
            fireTableDataChanged(); // JTable에 데이터 변경을 알림
            System.out.println("총 " + data.size() + "건의 예약 데이터 로드 완료.");
            
        } catch (SQLException e) {
            System.err.println("DB 데이터 로드 오류: " + e.getMessage());
        }
    }
    
    /**
     * [성능 강조 기능] 10,000건 이상의 더미 예약 데이터를 생성하고 JDBC Batch를 사용하여 빠르게 삽입합니다.
     */
    public void generateAndLoadDummyData() {
        final int DUMMY_COUNT = 10000;
        String sql = "INSERT INTO RESERVATION (user_id, visit_date, area, headcount, status) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // AutoCommit을 false로 설정하여 트랜잭션 시작 (성능 향상)
            conn.setAutoCommit(false); 
            
            Random random = new Random();
            long startTime = System.currentTimeMillis();

            for (int i = 1; i <= DUMMY_COUNT; i++) {
                // 더미 데이터 생성
                pstmt.setString(1, "user_" + (i % 1000)); // 1000명의 가상 사용자
                pstmt.setString(2, "2025-12-" + String.format("%02d", random.nextInt(30) + 1));
                pstmt.setString(3, "Area-" + (random.nextInt(5) + 1)); // 5개 구역
                pstmt.setInt(4, random.nextInt(4) + 1); // 1~4명
                pstmt.setString(5, random.nextBoolean() ? "CONFIRMED" : "CANCELLED");

                // Batch에 추가
                pstmt.addBatch(); 

                // 1000개 단위로 Batch 실행
                if (i % 1000 == 0) {
                    pstmt.executeBatch(); 
                    conn.commit(); // 커밋
                    System.out.println(i + "건 데이터 삽입 및 커밋 완료.");
                }
            }

            // 남은 Batch 실행
            pstmt.executeBatch();
            conn.commit();
            
            long endTime = System.currentTimeMillis();
            System.out.println("⭐ " + DUMMY_COUNT + "건 데이터 삽입 완료! 소요 시간: " + (endTime - startTime) + "ms");
            
            // AutoCommit 원래대로 복구
            conn.setAutoCommit(true); 
            
        } catch (SQLException e) {
            System.err.println("더미 데이터 삽입 오류: " + e.getMessage());
        }
    }
    
    /**
     * [엑셀 출력 기능] DB의 모든 예약 데이터를 CSV 파일로 내보냅니다.
     * (Excel에서 열 수 있는 CSV 파일 형식 사용)
     * @param fileToSave 저장할 파일 객체
     * @return 성공 여부
     */
    public boolean exportToCsv(File fileToSave) {
        // DB에서 모든 데이터를 조회합니다. (테이블에 보이는 100건이 아닌, 전체 데이터)
        String sql = "SELECT res_id, user_id, visit_date, area, headcount, status FROM RESERVATION ORDER BY res_id ASC";
        
        // try-with-resources 구문으로 파일 및 DB 리소스를 자동으로 닫습니다.
        try (Connection conn = DBConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             PrintWriter pw = new PrintWriter(new FileWriter(fileToSave))) {

            // 1. 헤더 (컬럼 이름) 작성
            StringBuilder header = new StringBuilder();
            for (String colName : columnNames) {
                // CSV는 쉼표로 구분합니다.
                header.append(colName).append(","); 
            }
            // 마지막 쉼표 제거 후 파일에 씁니다.
            pw.println(header.substring(0, header.length() - 1));

            // 2. 데이터 작성
            while (rs.next()) {
                StringBuilder line = new StringBuilder();
                line.append(rs.getString("res_id")).append(",");
                line.append(rs.getString("user_id")).append(",");
                line.append(rs.getString("visit_date")).append(",");
                line.append(rs.getString("area")).append(",");
                line.append(rs.getInt("headcount")).append(",");
                line.append(rs.getString("status")); // 마지막 컬럼은 쉼표 없이
                pw.println(line.toString());
            }
            
            System.out.println("CSV 파일로 데이터 내보내기 성공: " + fileToSave.getAbsolutePath());
            return true;
            
        } catch (SQLException | IOException e) {
            System.err.println("CSV 내보내기 오류: " + e.getMessage());
            return false;
        }
    }
    
    
}
