package main;
class Book{
	protected String author;
	protected String bookName;
	protected String Buyer;
	
	public Book(String author, String bookName, String Buyer) { 
		this.author = author; this.bookName = bookName; this.Buyer = Buyer;
	}
	public String toString() { return Buyer + "이 구입한 도서: " + author + "의 " + bookName; }
}

class BookApp extends Book{
	
	public BookApp(String author, String bookName, String Buyer) {
		super(author, bookName, Buyer);
	}
	
	public boolean equals(Object obj) {
		BookApp ba = (BookApp) obj;
		if(author.equals(ba.author) && bookName.equals(ba.bookName)) return true;
		else return false;
	}
}


public class report_02 {
	public static void main(String[] args) {
		Book a = new Book("황기태", "명품자바", "김하진");
		Book b = new Book("황기태", "명품자바", "하여린");
		System.out.println(a);
		System.out.println(b);
		if(a.equals(b)) {
			System.out.println("같은 책");
		}
		else
			System.out.println("다른 책");
	}
}
