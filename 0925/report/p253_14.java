package Report;

public class VArray {
	int array [];
	int volume, state = 0;
	int count = 0;
	
	public VArray(int volume) {
		this.volume = volume;
		array = new int [volume];
	}
	
	public void add(int num) {
		if(state < volume) {
			array[state] = num;
			state++;
			count++;
		}
		else {
			volume *= 2;
			int copyArray [] = new int [volume];
			
			int i = 0;
			for(i=0; i<array.length; i++) {
				copyArray[i] = array[i];
			}
			copyArray[i] = num;
			state++;
			count++;
			array = copyArray;	
		}
	}
	
	public int capacity() {
		return this.volume;
	}
	
	public int size() {
		return count;
	}
	
	public void printAll() {
		for(int i=0; i<count; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public void insert(int index, int num) {
		for (int i=count; i>index; i--) {
            array[i] = array[i-1];
        }

		array[index] = num;
		state++;
		count++;	
	}
	
	public void remove(int index) {
        for (int i = index; i<count-1; i++) {
            array[i] = array[i+1];
        }
        array[count - 1] = 0;
        count--;
        state--;
	}
	
	public static void main(String[] args) {
		VArray v = new VArray(5);
		System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
		
		for(int i=0; i<7; i++) {
			v.add(i);
		}
		System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
		v.printAll();
		
		v.insert(3, 100);
		v.insert(5, 200);
		System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
		v.printAll();
		
		v.remove(3);
		System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
		v.printAll();
		
		for(int i=50; i<55; i++) {
			v.add(i);
		}
		System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
		v.printAll();
		
	}
}
