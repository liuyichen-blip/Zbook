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
			Class.forName("com.mysql.cj.jdbc.Driver");// �����������򣬴˴��������mysql8.0
			System.out.println("registered success!");//���registered success��ʾ�������سɹ�
			//�����������ӣ��������ݿ⣬������employeedbmsΪ���ݿ�����rootΪ�û�����123456λ���룬������������ʵ����������޸ģ�������������䶯��ע��ȷ�����ݿ������û����������׼ȷ�ԡ�
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC","root","root");
			System.out.println("connection success!");//���connection success��ʾ���ݿ��ѳɹ�����
			
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

