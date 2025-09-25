package Report;

public class Average {
	int array [] = new int [9];
	int nextIndex = 0;
	
	public void put(int number) {
		array[nextIndex] = number;
		
		nextIndex++;
	}
	public void showAll() {
		for(int i=0; i<nextIndex; i++) {
			System.out.print(array[i] + " ");
		}
	}
	public double getAvg() {
		int sum = 0;
		for(int i=0; i<nextIndex; i++) {
			sum += array[i];
		}
		return (double)sum/nextIndex;
	}
	public static void main(String[] args) {
		Average avg = new Average();
		avg.put(10);
		avg.put(15);
		avg.put(100);
		avg.showAll();
		System.out.print("평균은 " + avg.getAvg());
	}
	
}
