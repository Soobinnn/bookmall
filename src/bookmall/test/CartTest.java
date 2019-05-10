package bookmall.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

// 4번 테스트
public class CartTest 
{
	public static void main(String[] args) 
	{
		/* 카트리스트 - 2개 테스트 코드 */ 
		CartInsert(1L,1L,2L);
		CartInsert(1L,2L,3L);
		CartInsert(2L,2L,1L);
		CartInsert(2L,3L,2L);
		
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
