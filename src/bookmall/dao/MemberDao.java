package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.main.MyConnection;
import bookmall.vo.MemberVo;

public class MemberDao 
{
	// 회원 추가
	public Boolean insert(MemberVo vo) 
	{
		Boolean result = false;
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		try 
		{
			conn = MyConnection.getConnection();
				
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
		
	//회원리스트
	public List<MemberVo> getList()
	{
		List<MemberVo> result = new ArrayList<MemberVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			conn = MyConnection.getConnection();
				
			String sql = "select member_no, name, tel, email, password from member";
			
			pstmt = conn.prepareStatement(sql);
				
			rs = pstmt.executeQuery();
				
			while( rs.next() ) 
			{
				Long member_no = rs.getLong(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				
				MemberVo vo = new MemberVo();
					
				vo.setMember_no(member_no);
				vo.setName(name);
				vo.setTel(tel);
				vo.setEmail(email);
				vo.setPassword(password);
					
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
