package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bookmall.main.MyConnection;
import bookmall.vo.OrderVo;


public class OrderDao 
{
		// 주문 추가
		public Boolean insert(OrderVo vo) 
		{
			Boolean result = false;
				
			Connection conn = null;
			PreparedStatement pstmt = null;
			try 
			{
				conn = MyConnection.getConnection();
					
				
				String sql = "INSERT INTO orders values (null, ?, ?, ?, now(), "+
						"concat(date_format(now(), '%Y%m%d'),'-', "+
						"lpad(((select `auto_increment` from information_schema.tables "+
								"where table_schema = 'bookmall' and table_name = 'orders')),3,0)))";
					
				pstmt = conn.prepareStatement(sql);
					
				pstmt.setLong(1, vo.getPrice());
				pstmt.setString(2, vo.getAddress());
				pstmt.setLong(3, vo.getMember_no());	    
			    
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
			
		    //주문 리스트
			public List<OrderVo> getList(Long no)
			{
				List<OrderVo> result = new ArrayList<OrderVo>();

				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try 
				{
					conn = MyConnection.getConnection();
					
					String sql = "SELECT orders_code, name, address,price , orders_date "+ 
							"FROM orders " + 
							"JOIN member " +
							"USING (member_no) "+
							"WHERE member_no=?";
				
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setLong(1, no);
					
					rs = pstmt.executeQuery();
				
					while( rs.next() ) 
					{
						String orders_code = rs.getString(1);
						String name = rs.getString(2);
						String address = rs.getString(3);
						Long price = rs.getLong(4);
						Date orders_date = rs.getDate(5);
						
						OrderVo vo = new OrderVo();
						
						
						vo.setOrders_code(orders_code);
						vo.setName(name);
						vo.setAddress(address);
						vo.setPrice(price);
						vo.setOrders_date(orders_date);
						
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
