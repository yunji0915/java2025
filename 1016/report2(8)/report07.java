package chapter_8;

import java.io.*;

public class report_07 {
	public static void main(String[] args) {
		File src = new File("a.png");
		File dest = new File("b.png");
		
		BufferedInputStream is = null;
		BufferedOutputStream os = null;
		System.out.println("a.jpg를 b.jpg로 복사합니다.");
		System.out.println("10%마다 *를 출력합니다.");
		try {
			is = new BufferedInputStream(new FileInputStream(src));
			os = new BufferedOutputStream(new FileOutputStream(dest));
			
			
			long ten = src.length()/10;
			long count = 0;
			
			int read;
			byte[] buf = new byte[1024];
			
			while(true) {
				read = is.read(buf, 0, buf.length);
				
				if(read == -1) {
					break;
				}
				
				os.write(buf, 0, read);
				count += read;
				
				if(count >= ten) {
					System.out.print("*");
					count -= ten;
				}
			}
			is.close();
			os.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		catch(IOException e) {
			System.out.println("파일을 열 수 없습니다.");
		}
	}
}
