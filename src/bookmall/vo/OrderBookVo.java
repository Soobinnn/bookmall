package bookmall.vo;

public class OrderBookVo 
{
	private Long book_no; 
	private Long orders_no; 
	private Long quantity;
	
	private String orders_code;
	private String title;
	
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getOrders_no() {
		return orders_no;
	}
	public void setOrders_no(Long orders_no) {
		this.orders_no = orders_no;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getOrders_code() {
		return orders_code;
	}
	public void setOrders_code(String orders_code) {
		this.orders_code = orders_code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "OrderBookVo [ quantity=" + quantity
				+ ", orders_code=" + orders_code + ", title=" + title + "]";
	}
	
	
	
}
