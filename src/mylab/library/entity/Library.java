package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	private List<Book> books;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}
	public void addBook(Book book) {
		this.books.add(book);
		System.out.println("도서가 추가되었습니다:" + book.getTitle());
	}
	public Book findBookByTitle(String title) {
		System.out.println("제목으로 검색 결과: ");
		Book book1 = null;
		for (Book book: this.books) {
			if(book.getTitle().contentEquals(title)) {
				book1 = book;
			}
		}
		return book1;
	}
	
	public Book findBookByAuthor(String author) {
		System.out.println("저자로 검색 결과: ");
		Book book1 = null;
		for (Book book: this.books) {
			if(book.getAuthor().contentEquals(author)) {
				book1 = book;
			}
		}
		return book1;
	}
	
	public Book findBookByISBN(String isbn) {
		Book book1 = null;
		for (Book book: this.books) {
			if(book.getIsbn().contentEquals(isbn)) {
				book1 = book;
			}
		}
		return book1;
	}
	
	public boolean checkOutBook(String isbn) {
		Book book = this.findBookByISBN(isbn);
		return book.checkOut();

	}
	public boolean returnBook(String isbn) {
		Book book = this.findBookByISBN(isbn);
		return book.returnBook();
	}
	public List<Book> getAvailableBooks() {
		List<Book> books = new ArrayList<>();
		for (Book book: this.books) {
			if (book.isAvailable() == true) {
				books.add(book);
			}
		}
		return books;
	
	}
	public  List<Book> getAllBooks() {
		return this.books;
	}
	
	public int getTotalBooks() {
		return this.books.size();
		
	}
	public int getAvailableBooksCount() {
		int count = 0;
		for (Book book: this.books) {
			if (book.isAvailable() == true) {
				count++;
			}
		}
		return count;
	}
	
	public int getBorrowedBooksCount() {
		int count = 0;
		for (Book book: this.books) {
			if (book.isAvailable() == false) {
				count++;
			}
		}
		return count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
