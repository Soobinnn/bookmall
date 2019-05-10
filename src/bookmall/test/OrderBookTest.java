package bookmall.test;

import java.util.List;

import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookVo;


// 6번 테스트
public class OrderBookTest 
{
	public static void main(String[] args) 
	{
		/* 주문도서리스트 -2개 테스트 코드 */ 
		OrderBookInsert(1L,1L,2L);
		OrderBookInsert(2L,1L,3L);
		OrderBookInsert(2L,2L,1L);
		OrderBookInsert(3L,2L,2L);
		
		getOrderBookListTest(1L);
	}
	
	// 주문도서  등록
	public static void OrderBookInsert(Long book_no, Long orders_no, Long quantity) 
	{
			OrderBookVo vo = new OrderBookVo();
			
			vo.setBook_no(book_no);
			vo.setOrders_no(orders_no);
			vo.setQuantity(quantity);
			
			new OrderBookDao().insert(vo);
			System.out.println("주문도서에 등록되었습니다.");
	}
	
	// 주문도서 리스트
	public static void getOrderBookListTest(Long orders_no) 
	{
			List<OrderBookVo> list = new OrderBookDao().getList(orders_no);
			for(OrderBookVo vo : list) 
			{
				System.out.println(vo);
			}
	}	
		
	//insert order (Ordervo)
	// insert orderBook (List)
	// 오더를 보여주고 눌렀을떄 List  getOrderList(Long MemeberNo)
	// List getOrderBookList (Long orderNo)  --> service에서 잘 조합하도록
	// 여기는 CRUD만
	// select last_insert_id(); -> 방금 넣은 것의 pk 를 찾아줌
}
