package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;

public class CartDao 
{
	// 카트 추가
	public Boolean insert(CartVo vo) 
	{
		Boolean result = false;
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		try 
		{
			conn = getConnection();
				
			String sql = "insert into cart values(?,?,?)";
				
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setLong(1, vo.getMember_no());
			pstmt.setLong(2, vo.getBook_no());
			pstmt.setLong(3, vo.getQuentity());
				
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
		
	    //카트 리스트
		public List<CartVo> getList(Long no)
		{
			List<CartVo> result = new ArrayList<CartVo>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try 
			{
				conn = getConnection();
				
				String sql = "SELECT c.name as name, b.title as title, a.quantity as quentity " + 
						"FROM cart a " + 
						"JOIN book b " + 
						"ON a.book_no = b.book_no " + 
						"JOIN member c " + 
						"ON a.member_no = c.member_no " + 
						"WHERE a.member_no = ?";
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, no);
				
				rs = pstmt.executeQuery();
			
				while( rs.next() ) 
				{
					String name = rs.getString(1);
					String title = rs.getString(2);
					Long quentity = rs.getLong(3);
					
					CartVo vo = new CartVo();
					
					vo.setName(name);
					vo.setTitle(title);
					vo.setQuentity(quentity);
					
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
