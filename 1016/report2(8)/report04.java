package chapter_8;

import java.io.*;
import java.util.*;

public class report_04 {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader("c:\\windows\\system.ini"));
			int c = 1;
			System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");
			
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.printf("%4d: ", c++);
				System.out.println(line);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다." + e.getMessage());
		}
		finally {
			scanner.close();
		}
	}
}
