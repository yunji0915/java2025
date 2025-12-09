package appl;

class Book{
	private String writer, title, buyer;
	
	public Book(String writer, String title, String buyer) {
		this.writer = writer;
		this.title = title;
		this.buyer = buyer;
	}
	
	public String toString() {
		return buyer+"이 구입한 도서: "+writer+"의 "+title;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book other = (Book) obj;
			return this.writer.equals(other.writer)&& this.title.equals(other.title);
		}
		return false;
	}
}

public class Exam_2 {
	public static void main(String[] args) {
		Book a = new Book("황기태", "명품자바", "김하진");
		Book b = new Book("황기태", "명품자바", "하여린");
		System.out.println(a);
		System.out.println(b);
		if(a.equals(b))
			System.out.println("같은 책");
		else
			System.out.println("다른 책");
	}
}
