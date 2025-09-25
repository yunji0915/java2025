package Report;

import java.util.Scanner;
public class Concert {
	Scanner scanner; 
	Seat S [];
	Seat A [];
	Seat B [];
	public Concert(Scanner scanner) {
		this.scanner = scanner;
		
		this.S = new Seat[10];
		for(int i=0; i<S.length; i++) {
			S[i] = new Seat();
		}
		
		this.A = new Seat[10];
		for(int i=0; i<A.length; i++) {
			A[i] = new Seat();
		}
		
		this.B = new Seat[10];
		for(int i=0; i<B.length; i++) {
			B[i] = new Seat();
		}
	}
	public void run() {
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		while(true) {
			System.out.print("예약:1, 조회:2, 취소:3. 끝내기:4>>");
			int state = scanner.nextInt();
			scanner.nextLine();
			
			if(state == 1) {
				rsv();
			}
			if(state == 2) {
				seatAllcheck();
			}
			if(state == 3) {
				seatCancle();
			}
			if(state == 4) {
				break;
			}
		}
	}
	public void rsv() {
		System.out.print("좌석구분 S(1), A(2), B(3)>>");
		int state = scanner.nextInt();
		seatCheck(state);
		scanner.nextLine();
		
		System.out.print("이름>>");
		String name = scanner.next();
		scanner.nextLine();
		
		System.out.print("번호>>");
		int num = scanner.nextInt();
		scanner.nextLine();
		
		seatReserv(state, name, num);
	}
	public void seatCheck(int i) {
		if(i == 1) {
			System.out.print("S>>");
			for(int j=0; j<10; j++) {
				if(S[j].getSeat() == null) {
					System.out.print(" --- ");
				}
				else {
					System.out.print(S[j].getSeat());
				}
			}
			System.out.println();
		}
		if(i == 2) {
			System.out.print("A>>");
			for(int j=0; j<10; j++) {
				if(A[j].getSeat() == null) {
					System.out.print(" --- ");
				}
				else {
					System.out.print(A[j].getSeat());
				}
			}
			System.out.println();
		}
		if(i == 3) {
			System.out.print("B>>");
			for(int j=0; j<10; j++) {
				if(B[j].getSeat() == null) {
					System.out.print(" --- ");
				}
				else {
					System.out.print(B[j].getSeat());
				}
			}
			System.out.println();
		}
	}
	public void seatReserv(int state, String name, int index) {
		if(state == 1) {
			S[index-1].setSeat(name);
		}
		if(state == 2) {
			A[index-1].setSeat(name);
		}
		if(state == 3) {
			B[index-1].setSeat(name);
		}
	}
	public void seatAllcheck() {
		seatCheck(1);
		System.out.println();
		seatCheck(2);
		System.out.println();
		seatCheck(3);
		System.out.println();
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	public void seatCancle() {
		System.out.print("좌석 S:1, A:2, B:3>>");
		int state = scanner.nextInt();
		scanner.nextLine();
		seatCheck(state);
		System.out.print("이름>>");
		String name = scanner.next();
		scanner.nextLine();
		
		seatDelete(state, name);
	}
	public void seatDelete(int state, String name) {
		if(state == 1) {
			for(int i=0; i<S.length; i++) {
				if(S[i].getSeat() != null && S[i].getSeat().equals(name))
					S[i].setSeat(null);
			}
		}
		if(state == 2) {
			for(int i=0; i<A.length; i++) {
				if(A[i].getSeat() != null && A[i].getSeat().equals(name))
					A[i].setSeat(null);
			}
		}
		if(state == 3) {
			for(int i=0; i<B.length; i++) {
				if(B[i].getSeat() != null && B[i].getSeat().equals(name))
					B[i].setSeat(null);
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Concert concert = new Concert(scanner);
		
		concert.run();
		scanner.close();
	}
}
