import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

class Location{
	Scanner scanner = new Scanner(System.in);
	private String loc;
	private StringTokenizer st;
	
	public void OutPut(HashMap<String, String[]>hm, StringTokenizer st) {
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			String[] value = hm.get(key);
			System.out.printf("%s %15.1f %15.1f\n",key, Double.parseDouble(value[0]), Double.parseDouble(value[1]));
		}
		System.out.println("----------------------------------------------------");
	}
	
	public void Input(HashMap<String, String[]>hm, String loc, StringTokenizer st) {
		for(int i=0; i<4; i++) {
			System.out.print(">>");
			loc = scanner.nextLine();
			st = new StringTokenizer(loc, ", ");
			while(st.hasMoreTokens()) {
				String city = st.nextToken();
				String hardness = st.nextToken();
				String latitude = st.nextToken();
				
				hm.put(city, new String[] {hardness, latitude});
			}
		}
	}
	
	public void run() {	
		HashMap <String, String[]> hm = new HashMap<String, String[]>();
		System.out.println("도시,경도,위도를 입력하세요.");
		String city;
		Input(hm, loc, st);
		System.out.println("----------------------------------------------------");
		OutPut(hm, st);		
		while(true) {
			System.out.print("도시 이름>>");
			city = scanner.next();
			
			if(city.equals("그만")){ break; }
			LocationManager.Search(hm,city);
		}
		scanner.close();
	}	
	
}

class LocationManager{
	static String cityName;
	
	public static void Search(HashMap<String, String[]>hm, String cityName) {
		if(hm.containsKey(cityName)) {
			String [] values = hm.get(cityName);
			System.out.printf("%s %15.1f %15.1f\n", cityName, Double.parseDouble(values[0]), Double.parseDouble(values[1]));
		}
		else {
			System.out.println(cityName + "은 없습니다.");
			return;
		}
	}
}

public class report_07_1 {
	public static void main(String[] args) {
		Location lo = new Location();
		lo.run();
	}
}
