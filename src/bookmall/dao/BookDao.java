package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;


public class BookDao 
{
	// 도서 추가
	public Boolean insert(BookVo vo) 
	{
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try 
		{
			conn = getConnection();
			
			String sql = 
				" insert" +
				"   into book" + 
				" values (null, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategory_no());
			
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
 			} catch (SQLException e) 
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
			"select book_no, title, price,"+
			"(select name from category where a.category_no=category_no) as category_name "+ 
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
