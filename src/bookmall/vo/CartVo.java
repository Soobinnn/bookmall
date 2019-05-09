package bookmall.vo;

public class CartVo 
{
	private Long member_no;
	private Long book_no;
	private Long quentity;
	
	private String name;
	private String title;
	
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getQuentity() {
		return quentity;
	}
	public void setQuentity(Long quentity) {
		this.quentity = quentity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
