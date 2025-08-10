package mylab.library.control;

import java.util.List;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Library library = new Library("중앙 도서관");
		addSampleBooks(library);
		testFindBook(library,"자바의 정석","Robert C. Martin");
		testCheckOut(library, "978-89-01-14077-4");
		testReturn(library, "978-89-01-14077-4");
		displayAvailableBooks(library); 
		
	}
	
	public static void addSampleBooks(Library library) {
		   library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
	        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
	        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
	        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
	        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
	        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	        System.out.println("===== 중앙 도서관 =====");
	        showLibraryStatus(library);
	        
	}
	public static void showLibraryStatus(Library library) {
		System.out.println("전체 도서수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서수: " + library.getBorrowedBooksCount());
	}
	
	
	public static void testFindBook(Library library, String title, String author) {
		System.out.println("===== 도서 검색 테스트 =====");
		Book book = library.findBookByTitle(title);
		if (book == null) {
			System.out.println("해당 도서는 도서관에 없는 도서입니다.");
		}
		System.out.println(book.toString());
		System.out.println();
		Book book1 = library.findBookByAuthor(author);
		if (book1 == null) {
			System.out.println("해당 도서는 도서관에 없는 도서입니다.");
		}
		System.out.println(book1.toString());
		
	}
	public static void testCheckOut(Library library, String isbn) {
		System.out.println("===== 도서 대출 테스트 =====");
		boolean avail = library.checkOutBook(isbn);
		if (avail == true) {
			System.out.println("도서 대출 성공!!");
			System.out.println("대출된 도서 정보:");
			System.out.println(library.findBookByISBN(isbn).toString());
			System.out.println();
			System.out.println("도서관 현재 상태:");
			showLibraryStatus(library);
		}
		
	}
	public static void testReturn(Library library, String isbn) {
		System.out.println("===== 도서 반납 테스트 =====");
		boolean isReturned = library.returnBook(isbn);
		if (isReturned == true) {
			System.out.println("도서 반납 성공!");
			System.out.println("반납된 도서 정보:");
			System.out.println(library.findBookByISBN(isbn).toString());
			System.out.println();
			System.out.println("도서관 현재 상태:");
			showLibraryStatus(library);
		}
	}
	
	public static void displayAvailableBooks(Library library) {
		System.out.println("===== 대출 가능한 도서 목록 =====");
		List<Book> availBooks = library.getAvailableBooks();
		for (Book book: availBooks) {
			System.out.println(book.toString());
			System.out.println("------------------------");
		}
		
	}
}
