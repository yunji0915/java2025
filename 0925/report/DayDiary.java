package Report;

public class DayDiary {
	private String memo;
	
	public void setMemo(String memo) {
		if(memo.length() <= 4) {
			this.memo = memo;
		}
		else {
			System.out.println("4글자 이하가 아닙니다. 다시 입력하세요");
		}
	}
	public String getMemo() {
		return memo;
	}
}
