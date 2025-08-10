package mylab.library.control;

import java.util.List;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Library library = new Library("�߾� ������");
		addSampleBooks(library);
		testFindBook(library,"�ڹ��� ����","Robert C. Martin");
		testCheckOut(library, "978-89-01-14077-4");
		testReturn(library, "978-89-01-14077-4");
		displayAvailableBooks(library); 
		
	}
	
	public static void addSampleBooks(Library library) {
		   library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
	        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
	        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
	        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
	        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
	        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	        System.out.println("===== �߾� ������ =====");
	        showLibraryStatus(library);
	        
	}
	public static void showLibraryStatus(Library library) {
		System.out.println("��ü ������: " + library.getTotalBooks());
		System.out.println("���� ���� ������: " + library.getAvailableBooksCount());
		System.out.println("���� ���� ������: " + library.getBorrowedBooksCount());
	}
	
	
	public static void testFindBook(Library library, String title, String author) {
		System.out.println("===== ���� �˻� �׽�Ʈ =====");
		Book book = library.findBookByTitle(title);
		if (book == null) {
			System.out.println("�ش� ������ �������� ���� �����Դϴ�.");
		}
		System.out.println(book.toString());
		System.out.println();
		Book book1 = library.findBookByAuthor(author);
		if (book1 == null) {
			System.out.println("�ش� ������ �������� ���� �����Դϴ�.");
		}
		System.out.println(book1.toString());
		
	}
	public static void testCheckOut(Library library, String isbn) {
		System.out.println("===== ���� ���� �׽�Ʈ =====");
		boolean avail = library.checkOutBook(isbn);
		if (avail == true) {
			System.out.println("���� ���� ����!!");
			System.out.println("����� ���� ����:");
			System.out.println(library.findBookByISBN(isbn).toString());
			System.out.println();
			System.out.println("������ ���� ����:");
			showLibraryStatus(library);
		}
		
	}
	public static void testReturn(Library library, String isbn) {
		System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
		boolean isReturned = library.returnBook(isbn);
		if (isReturned == true) {
			System.out.println("���� �ݳ� ����!");
			System.out.println("�ݳ��� ���� ����:");
			System.out.println(library.findBookByISBN(isbn).toString());
			System.out.println();
			System.out.println("������ ���� ����:");
			showLibraryStatus(library);
		}
	}
	
	public static void displayAvailableBooks(Library library) {
		System.out.println("===== ���� ������ ���� ��� =====");
		List<Book> availBooks = library.getAvailableBooks();
		for (Book book: availBooks) {
			System.out.println(book.toString());
			System.out.println("------------------------");
		}
		
	}
}
