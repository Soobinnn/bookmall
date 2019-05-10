package bookmall.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;


//2번 테스트
public class MemberTest 
{
	public static void main(String[] args) 
	{
		/* 회원리스트 -2명 테스트 코드 */ 
		MemberInsert("임수빈", "010-3449-0918", "isb9082@naver.com", "1234");
		MemberInsert("베리", "010-5259-4588", "berry@daum.net", "5678");
	
		getMemberListTest();
	}
	// 회원등록
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
	// 회원리스트 
	public static void getMemberListTest() 
	{
			List<MemberVo> list = new MemberDao().getList();
			for(MemberVo vo : list) 
			{
				System.out.println(vo);
			}
	}
}
