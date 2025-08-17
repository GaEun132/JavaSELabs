package mylab.book.entity;

public class ReferenceBook extends Publication{

	private String field;
	
	public ReferenceBook() {
		
	}
	
	public ReferenceBook(String title, String publishDate, int page, int price, String field) {
		super(title, publishDate, page, price);
		this.field = field;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	@Override
	public String toString() {
		return  this.getTitle() + " [참고서] " +"분야:" + this.field +", "+ this.getPage() + "쪽, " + this.getPrice()+ "원, 출판일:" + this.getPublishDate();
		
	}
	
	
}
