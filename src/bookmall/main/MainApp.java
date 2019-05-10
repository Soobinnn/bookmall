package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderBookDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class MainApp 
{
	public static void main(String[] args) 
	{
		displayMemberList();
		displayCategoryList();
		displayBookList();
		
		// 회원번호 1의 카트리스트를 볼 수있다.
		// 예제는 회원이 2명이므로 회원번호2번까지의 카트리스트를 볼수 있음.
		displayCartList(1L);
		
		// 주문도 회원번호를 통해 볼 수 있다.
		displayOrderList(1L);
		
		// 주문번호로 주문도서내역을 확인할 수 있다.
		displayOrderBookList(1L);
		
	}
	
	// 회원리스트 - 2명
	public static void displayMemberList() 
	{	
		System.out.println("******회원 리스트*****");
		System.out.println("회원번호	 | 이름	| 전화번호		| 이메일");
		List<MemberVo> list = new MemberDao().getList();
		for(MemberVo vo : list) 
		{
			System.out.println("	"+vo.getMember_no()+"| "+vo.getName()+" | "+vo.getTel()+" | "+vo.getEmail());
		}
	}

	// 카테고리리스트 - 3개
	public static void displayCategoryList() 
	{
		System.out.println("\n******카테고리 리스트*****");
		System.out.println("카테고리번호 | 카테고리명");
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo vo : list) 
		{
			System.out.println("	"+vo.getCategory_no()+"| "+vo.getName());
		}
	}
	
	// 상품리스트(도서리스트) - 3개
	public static void displayBookList() 
	{
		System.out.println("\n******도서 리스트*****");
		System.out.println("도서번호	 |책이름		|가격	 |카테고리명");
		
		List<BookVo> list = new BookDao().getList();
		
		for(BookVo vo : list) 
		{
			System.out.println("	"+vo.getBook_no()+"| "+vo.getTitle()+"   | "+vo.getPrice()+" | "+vo.getCategory_name());
		}
	}
	
	// 카트 리스트 -2 개
	public static void displayCartList(Long no) 
	{
		System.out.println("\n******카트 리스트*****");
		System.out.println("회원이름 |책이름 		|수량");
		
		List<CartVo> list = new CartDao().getList(no);
		
		for(CartVo vo : list) 
		{
			System.out.println("  "+vo.getName()+" |"+vo.getTitle()+"	|"+vo.getQuentity());
		}
	}
	
	// 주문 리스트 - 1개
	public static void displayOrderList(Long no) 
	{
		System.out.println("\n******주문 리스트*****");
		System.out.println("주문코드 		|회원이름	|	주소 			| 가격  | 주문날짜");
		List<OrderVo> list = new OrderDao().getList(no);
		
		for(OrderVo vo : list) 
		{
			System.out.println(""+vo.getOrders_code()+"	|"+vo.getName()+"	|"+vo.getAddress()+"|"+vo.getPrice()+"|"+vo.getOrders_date());
		}
	}
	
	// 주문도서 리스트 -2개
	public static void displayOrderBookList(Long orders_no) 
	{
		System.out.println("\n******주문도서 리스트*****");
		System.out.println("주문코드		|책이름		|수량");
		List<OrderBookVo> list = new OrderBookDao().getList(orders_no);
		for(OrderBookVo vo : list) 
		{
			System.out.println(""+vo.getOrders_code()+"	|"+vo.getTitle()+"	|"+vo.getQuantity());
		}
	}	
	
}
