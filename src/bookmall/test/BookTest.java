package bookmall.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookTest 
{
	public static void main(String[] args) 
	{
		/* 상품리스트(도서리스트) 테스트 코드 */ 
		Bookinsert("아리랑", 5500L, 2L);
		Bookinsert("디자인의 중요성", 19900L, 6L);
		
		getBookListTest();
	}
	
	// 상품리스트(도서리스트) 테스트 코드
	public static void Bookinsert(String title, Long price, Long category_no) 
	{
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		
		new BookDao().insert(vo);
		System.out.println("책이 등록되었습니다.");
	}
	
	public static void getBookListTest() 
	{
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo : list) 
		{
			System.out.println(vo);
		}
	}
	
	
}
