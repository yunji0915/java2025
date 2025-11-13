package chapter_8;

import java.util.Scanner;
import java.io.*;

class file{
	static Scanner scanner = new Scanner(System.in);
	static File f = new File("C:\\");
	static String beforeFileName = null; 
	
	static void dirMove(String dirName, String fileName) {
		
		if(fileName.equals("..")) {
			beforeFileName = f.getParent();
			dirName = beforeFileName;
		}
		else {
			dirName += "\\" + fileName;
		}
		f = new File(dirName);
	}
	
	public static void putFile() {
		File[] subFiles = f.listFiles();
		
		for(int i=0; i<subFiles.length; i++) {
			File l = subFiles[i];
			String type = null;	
			
			if(l.isFile()) {
				type = "file";
			}
			else if(l.isDirectory()) {
				type = "dir";
			}
			
			System.out.printf("%s %20d바이트 %30s\n", type, l.length(), l.getName());
		}
	}
	
	public static void run() {
		
		System.out.println("***** 파일 탐색기입니다. *****");
		
		while(true) {
			String dirName = f.getPath();
			System.out.println("[" + f.getPath() + "]");
			putFile();
			
			System.out.println("-----------------------------------------------------------------");
			System.out.print(">>");
			String fileName = scanner.next();
			
			
			if(fileName.equals("그만")) {
				break;
			}
			
			dirMove(dirName, fileName);
		}
	}
}

public class report_13 {
	public static void main(String[] args) {
		file.run();
	}
}
