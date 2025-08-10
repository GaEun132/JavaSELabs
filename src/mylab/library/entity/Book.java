package mylab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
		this.isAvailable = true;
	}
	

	public Book(String title, String author, String isbn, int publishYear) {

		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean checkOut() {
		if (this.isAvailable == true) {
			setAvailable(false);
			return true;
		} else {
			System.out.println("해당 도서는 이미 대출중입니다.");
			return false;
		}
	}
	public boolean returnBook() {
		if (this.isAvailable == true) {
			System.out.println("해당 도서는 반납이 완료된 도서입니다.");
			return false;
		} else {
			this.isAvailable = true;
			return true;
		}
		
	}

	@Override
	public String toString() {
		String avail = "대출여부";
		if (this.isAvailable == true) {
			avail = "가능";
		} else {
			avail = "대출중";
		}
		return "책 제목: " + title + "     저자: " + author + "     ISBN: " + isbn + "     출판년도: " + publishYear
				+ "     대출 가능 여부: " + avail;
	}
	
	
}
