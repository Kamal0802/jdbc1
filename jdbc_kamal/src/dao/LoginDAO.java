package dao;

import java.sql.*;

import connectionManager.ConnectionManager;
import model.Login;



public class LoginDAO {

	public boolean validate(Login Login) throws ClassNotFoundException,SQLException
	{
		String username=Login.getUsername();
		
		String password=Login.getPassword();
		
		ConnectionManager conn=new ConnectionManager();
		
		Connection con=conn.establishConnection();
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select*from login");
		
		while(rs.next())
		{
			if(username.equals(rs.getString("username"))&&password.equals(rs.getString("password"))) {
				
				conn.closeConnection();
				return true;
			}
			
		}
		
		conn.closeConnection();
		return false;
		
		
	}


}
