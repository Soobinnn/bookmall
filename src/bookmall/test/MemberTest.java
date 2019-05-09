package bookmall.test;

import bookmall.dao.BookDao;
import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberTest 
{
	public static void main(String[] args) 
	{
		MemberInsert("임수빈", "010-3449-0918", "isb9082@naver.com", "1234");
	}
	// 회원리스트(회원리스트) 테스트 코드
	public static void MemberInsert(String name, String tel, String email, String password) 
	{
			MemberVo vo = new MemberVo();
			vo.setName(name);
			vo.setTel(tel);
			vo.setEmail(email);
			vo.setPassword(password);
					
			new MemberDao().insert(vo);
			System.out.println("회원이 등록되었습니다.");
	}
}
