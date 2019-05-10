package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.main.MyConnection;
import bookmall.vo.CategoryVo;

public class CategoryDao 
{
		// 카테고리 추가
		public Boolean insert(CategoryVo vo) 
		{
			Boolean result = false;
				
			Connection conn = null;
			PreparedStatement pstmt = null;
			try 
			{
				conn = MyConnection.getConnection();
					
				String sql = "insert into category values(null, ?)";
					
				pstmt = conn.prepareStatement(sql);
					
				pstmt.setString(1, vo.getName());
				
				int count = pstmt.executeUpdate();
				result = (count == 1);
				
			} 
			catch (SQLException e) 
			{
				System.out.println("error" + e);
			} 
			finally 
			{
				try 
				{
					if( pstmt != null ) 
					{
						pstmt.close();
					}
					if( conn != null ) 
					{
						conn.close();
					}
		 		} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}		
				
				return result;
			}
			
		    //카테고리 리스트
			public List<CategoryVo> getList()
			{
				List<CategoryVo> result = new ArrayList<CategoryVo>();

				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try 
				{
					conn = MyConnection.getConnection();
					
					String sql = "select category_no, name from category";
				
					pstmt = conn.prepareStatement(sql);
					
					rs = pstmt.executeQuery();
					
					while( rs.next() ) 
					{
						Long category_no = rs.getLong(1);
						String name = rs.getString(2);
						
						CategoryVo vo = new CategoryVo();
						
						vo.setCategory_no(category_no);
						vo.setName(name);
						
						result.add(vo);
					}
					
				} 
				catch (SQLException e) 
				{
					System.out.println("error" + e);
				} 
				finally 
				{
					try 
					{
						if( rs != null ) 
						{
							rs.close();
						}
						if( pstmt != null ) 
						{
							pstmt.close();
						}
						if( conn != null ) 
						{
							conn.close();
						}
		 			} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}		
				return result;
			}
			
}
