package bookmall.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

// 1번 테스트
// 테스트 순서
// CategoryTest -> MemberTest -> BookTest -> CartTest -> OrderTest -> OrderBookTest
public class CategoryTest 
{
	public static void main(String[] args) 
	{
		/* 카테고리리스트 - 3개 테스트 코드 */ 
		CategoryInsert("소설");
		CategoryInsert("수필");
		CategoryInsert("컴퓨터/IT");
		getCategoryListTest();
	}
	
	// 카테고리 등록
	public static void CategoryInsert(String name) 
	{
			CategoryVo vo = new CategoryVo();
			vo.setName(name);
					
			new CategoryDao().insert(vo);
			System.out.println("카테고리가 등록되었습니다.");
	}
	
	// 카테고리리스트
	public static void getCategoryListTest() 
	{
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo vo : list) 
		{
			System.out.println(vo);
		}
	}
}
