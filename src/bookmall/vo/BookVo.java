package bookmall.vo;

public class BookVo 
{
	private Long book_no;
	private String title;
	private Long price;
	private Long category_no;
	
	private String category_name;
	
	
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public String toString() {
		return "BookVo [book_no=" + book_no + ", title=" + title + ", price=" + price 
				+ ", category_name=" + category_name + "]";
	}
	
	
}
