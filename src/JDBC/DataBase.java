package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

	Connection conn=null;
	public Connection getDBConnection()throws Exception  {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");// 加载驱动程序，此次无需更改mysql8.0
			System.out.println("registered success!");//输出registered success表示驱动加载成功
			//创建对象连接，连接数据库，此例中employeedbms为数据库名，root为用户名，123456位密码，该三项均需根据实际情况进行修改，其它代码无需变动。注：确保数据库名、用户名和密码的准确性。
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC","root","root");
			System.out.println("connection success!");//输出connection success表示数据库已成功连接
			
		}
		catch(Exception e)
		{
			System.out.println("error!");
		}
		finally{
		}
		return conn;
	}
	 public void free(Connection conn,PreparedStatement stmt,ResultSet rs) throws SQLException {
		  if(rs!=null) rs.close();
		  if(stmt!=null) stmt.close();
		  if(conn!=null) conn.close();
}
}

