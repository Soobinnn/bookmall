package bookmall.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;



public class CartTest 
{
	public static void main(String[] args) 
	{
		/* 카트리스트 테스트 코드 */ 
		CartInsert(2L,5L,4L);
		
		getCartListTest(2L);
	}
	
	// 카트  등록
	public static void CartInsert(Long member_no, Long book_no, Long quentity) 
	{
			CartVo vo = new CartVo();
			vo.setMember_no(member_no);
			vo.setBook_no(book_no);
			vo.setQuentity(quentity);
					
			new CartDao().insert(vo);
			System.out.println("카트에 등록되었습니다.");
	}
	
	// 카트 리스트
	public static void getCartListTest(Long no) 
	{
			List<CartVo> list = new CartDao().getList(no);
			for(CartVo vo : list) 
			{
				System.out.println(vo);
			}
	}
}
