import java.util.ArrayList;
import java.util.Scanner;

class Duplication{
	Scanner scanner = new Scanner (System.in);
	ArrayList<String> al = new ArrayList<String>();
	
	private void copyArrayList(String input) {
		
		String[] inputArray = input.split(" ");
		

		for(int i=0; i<inputArray.length; i++) {
			al.add(inputArray[i]);
		}
		for(int i=0; i<al.size(); i++) {
			searchAndRemove(al.get(i), i+1);
		}
		
	}
	
	private void searchAndRemove(String src, int j) {
		while(j < al.size()) {
			String dest = al.get(j);
			if(src.equals(dest)) 
				al.remove(j);
			else
				j++;
		}
	}
	
	private void arrayListGet(ArrayList<String> al) {
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i) + " ");
		}
		System.out.println();
	}
	public void run() {
		
		while(true) {
			
			System.out.print("문자열들을 입력하세요>");
			String input = scanner.nextLine();
			
			if(input.equals("그만")) {
				break; 
			}
			
			copyArrayList(input);
			arrayListGet(al);
			al.clear();
	}
}

public class report_10 {
	public static void main(String[] args) {
		Duplication dd = new Duplication();
		
		dd.run();
			
			
		}
	}
}
