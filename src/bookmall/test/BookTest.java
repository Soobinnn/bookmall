package bookmall.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

// 3번테스트
// 테스트 순서
// CategoryTest -> MemberTest -> BookTest -> CartTest -> OrderTest -> OrderBookTest
public class BookTest 
{
	public static void main(String[] args) 
	{
		/* 상품리스트(도서리스트) - 3개 테스트 코드 */ 
		Bookinsert("GOF의 디자인패턴", 26000L, 3L);
		Bookinsert("톰캣 최종분석", 28000L, 3L);
		Bookinsert("트와일라잇", 11700L, 1L);
		getBookListTest();
	}
	
	// 상품(도서)등록
	public static void Bookinsert(String title, Long price, Long category_no) 
	{
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		
		new BookDao().insert(vo);
		System.out.println("책이 등록되었습니다.");
	}
	// 상품리스트(도서리스트)
	public static void getBookListTest() 
	{
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo : list) 
		{
			System.out.println(vo);
		}
	}
	
	
}
