package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bookmall.vo.OrderBookVo;



public class OrderBookDao 
{
	// 주문도서 추가
	public Boolean insert(OrderBookVo vo) 
	{
		Boolean result = false;
					
		Connection conn = null;
		PreparedStatement pstmt = null;
		try 
		{
			conn = getConnection();
				
			String sql = "insert into order_book values(?,?,?)";
						
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setLong(1, vo.getBook_no());
			pstmt.setLong(2, vo.getOrders_no());
			pstmt.setLong(3, vo.getQuantity());
						
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
				
		  //주문도서 리스트
		public List<OrderBookVo> getList(Long orders_no)
		{
			List<OrderBookVo> result = new ArrayList<OrderBookVo>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try 
			{
				conn = getConnection();
			
				String sql = "SELECT (SELECT orders_code FROM orders WHERE a.orders_no=orders_no) as orders_code "+
								", (SELECT title FROM book WHERE a.book_no=book_no) as title, quantity " + 
							"FROM order_book a " + 
							"WHERE orders_no = ?";
					
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setLong(1, orders_no);
					
				rs = pstmt.executeQuery();
					
				while( rs.next() ) 
				{
					String orders_code = rs.getString(1);
					String title = rs.getString(2);
					Long quantity = rs.getLong(3);
				
							
					OrderBookVo vo = new OrderBookVo();
								
					vo.setOrders_code(orders_code);
					vo.setTitle(title);			
					vo.setQuantity(quantity);
							
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
