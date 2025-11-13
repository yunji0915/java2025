package two;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Location{
	
	public static void OutPut(ArrayList<String>li) {
		int i = 0;
			for(; i<li.size();i++) {
				System.out.printf("%s %15.1f %15.1f\n",li.get(i), Double.parseDouble(li.get(++i)), Double.parseDouble(li.get(++i)));
			}
		System.out.println("----------------------------------------------------");
	}
	
	public static void Input(ArrayList<String>li, String loc, StringTokenizer st) {
		for(int i=0; i<4; i++) {
			System.out.print(">>");
			loc = scanner.nextLine();
			st = new StringTokenizer(loc, ", ");
			
			while(st.hasMoreTokens()) { li.add(st.nextToken()); }
		}
	}
	
	static Scanner scanner = new Scanner(System.in);
	static String loc;
	static ArrayList <String> li = new ArrayList<String> ();
	static StringTokenizer st;
	
	public static void run() {
		System.out.println("도시,경도,위도를 입력하세요.");
		String city;
		
		Input(li ,loc, st);
		System.out.println("----------------------------------------------------");
		OutPut(li);
		while(true) {
			System.out.print("도시 이름>>");
			city = scanner.next();
			
			if(city.equals("그만")){ break; }
			LocationManager.Search(li,city);
		}
	}
	
}

class LocationManager{
	static String cityName;
		
		public static void Search(ArrayList<String>li, String cityName) {
			if(li.contains(cityName)) {
				for(int i=0; i<li.size(); i++) {
					if(li.get(i).equals(cityName)) {
						System.out.printf("%s %15.1f %15.1f\n", cityName, Double.parseDouble(li.get(i+1)), Double.parseDouble(li.get(i+2)));
						break;
					}
				}
			}
			else {
				System.out.println(cityName + "은 없습니다.");
				return;
			}
		}
}
public class report_07_2 {
	public static void main(String[] args) {
		Location.run();
	}
}
