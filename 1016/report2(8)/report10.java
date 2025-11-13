package chapter_8;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

class save{
	Scanner scanner = new Scanner(System.in);
	HashMap <String, String> pn = new HashMap<String, String>();
	File src = new File("C:\\temp\\phone.txt");
	
	public void hashMapPut(String[] array) {
		String name = array[0];
		String number = array[1];
		
		pn.put(name, number);
	}
	
	public String searchPhoneNumber(String name) {
		return pn.get(name);
	}
	
	public void run() {
		
		try {
			BufferedReader is = new BufferedReader(new FileReader(src));
			
			String line;
			while((line = is.readLine()) != null) {
				
				String[] phoneNum = line.split(" ");
			
				hashMapPut(phoneNum);
			}
			is.close();
			System.out.println("총 " +  pn.size() + "개의 전화번호를 읽었습니다.");
			while(true) {
				System.out.print("이름>>");
				String name = scanner.next();
				
				if(name.equals("그만")) {
					break;
				}
				String number = searchPhoneNumber(name);
				
				if(number == null) {
					System.out.println("찾는 이름이 없습니다.");
				}
				else {
					System.out.println(number);
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		catch(IOException e) {
			System.out.println("파일을 읽는 중 오류가 발생했습니다.");
		}
	}
}

public class report_10 {
	public static void main(String[] args) {
		save g = new save();
		g.run();
	}
}
