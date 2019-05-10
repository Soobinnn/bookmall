package bookmall.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// db정보
public class MyConnection 
{
	public static Connection getConnection() throws SQLException 
	{
		Connection conn = null;
		try 
		{
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.118:3307/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
			
			// 집 테스트용
			//String url = "jdbc:mariadb://soobindb.c9rnggg5gymg.ap-northeast-2.rds.amazonaws.com:3307/bookmall";
			//conn = DriverManager.getConnection(url, "soobinnn", "TksxhRl21!");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}
}
