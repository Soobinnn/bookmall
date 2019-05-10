package bookmall.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;



public class OrderTest 
{
	public static void main(String[] args) 
	{
		/* 주문리스트 테스트 코드 */ 
		OrderInsert(125500L,"서울시 서초구 반포동",2L);
		
		getOrderListTest(2L);
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
		
		//insert order (Ordervo)
		   // insert orderBook (List)
		   // 오더를 보여주고 눌렀을떄 List  getOrderList(Long MemeberNo)
		   // List getOrderBookList (Long orderNo)  --> service에서 잘 조합하도록
		   /// 여기는 CRUD만
		   // select last_insert_id(); -> 방금 넣은 것의 pk 를 찾아줌
}
