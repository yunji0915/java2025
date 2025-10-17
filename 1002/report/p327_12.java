package report;

class Dictionary extends PairMap{
	int size;
	int index = 0;
	
	public Dictionary(int size) { keyArray = new String [(size/2)/2]; valueArray = new String [(size/2)/2]; }
	public String get(String key) {
		for(int i = 0; i < length(); i++) {
			if(keyArray[i].equals(key)) {
				return valueArray[i];
			}
		}
		return null;
	}
	public void put(String key, String value) {
		for(int i = 0; i < length(); i++) {
			if(keyArray[i]  != null && keyArray[i].equals(key)) {
				valueArray[i] = value;
				return;
			}
		}
		if(index < length()) { keyArray[index] = key; valueArray[index] = value; index++; }
	}
	public String delete(String key) {
		String value;
		for(int i = 0; i < length(); i++) {
			if(keyArray[i].equals(key)) {
				value = valueArray[i];
				valueArray[i] = null;
				return value;
			}
		}
		return null;
	}
	public int length() { return valueArray.length; }
}


public class report_12 {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 " + dic.get("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));
	}
}
