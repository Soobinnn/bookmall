package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;
import bookmall.vo.MemberVo;

public class MemberDao 
{
	// 도서 추가
	public Boolean insert(MemberVo vo) 
	{
		Boolean result = false;
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		try 
		{
			conn = getConnection();
				
			String sql = "insert into member "+
						 "values(null ,? ,? ,? ,password(?))";
				
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());
			
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
		
		public List<BookVo> getList()
		{
			List<BookVo> result = new ArrayList<BookVo>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try 
			{
				conn = getConnection();
				
				String sql = 
				"select book_no as 도서번호, title as 제목, price as 가격,"+
				"(select name from category where a.category_no=category_no) as 카테고리명 "+ 
				"from book a";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				while( rs.next() ) {
					Long book_no = rs.getLong(1);
					String title = rs.getString(2);
					Long price = rs.getLong(3);
					String category_name = rs.getString(4);
					
					BookVo vo = new BookVo();
					vo.setBook_no(book_no);
					vo.setTitle(title);
					vo.setPrice(price);
					vo.setCategory_name(category_name);
					
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
		
		
		
		private Connection getConnection() throws SQLException 
		{
			Connection conn = null;
			try 
			{
				Class.forName("org.mariadb.jdbc.Driver");
				String url = "jdbc:mariadb://192.168.1.118:3307/bookmall";
				conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println("드라이버 로딩 실패:" + e);
			}
			return conn;
		}
}
