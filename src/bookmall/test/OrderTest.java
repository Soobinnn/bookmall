package bookmall.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;


// 5번 테스트
// 테스트 순서
// CategoryTest -> MemberTest -> BookTest -> CartTest -> OrderTest -> OrderBookTest
public class OrderTest 
{
	public static void main(String[] args) 
	{
		/* 주문리스트 1개 테스트 코드 */ 
		OrderInsert(136000L,"서울특별시 서초구 신반포로 270-134동 2402호",1L);
		OrderInsert(51400L,"서울특별시 서초구 반포동 반포자이아파트 134-2402",2L);
		
		getOrderListTest(1L);
	}
	
	// 주문  등록
	public static void OrderInsert(Long price, String address, Long member_no) 
	{
			OrderVo vo = new OrderVo();
			
			vo.setPrice(price);
			vo.setAddress(address);
			vo.setMember_no(member_no);
			
			new OrderDao().insert(vo);
			System.out.println("주문에 등록되었습니다.");
	}
	
	// 주문 리스트 
	public static void getOrderListTest(Long no) 
	{
			List<OrderVo> list = new OrderDao().getList(no);
			for(OrderVo vo : list) 
			{
				System.out.println(vo);
			}
	}	
		
}
