package dao;
import model.Login;  //for linking login data
import java.sql.*;
import  ConnectionManager.connectionmanager;

public class LoginDAO 
{
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		String username=login.getUsername();
		String password=login.getPassword();
		connectionmanager conm=new connectionmanager();
		Connection con=conm.establishConnection();
		// to write query for getting value from sql table
		//Statement class
		Statement st=con.createStatement();
		
		//ResultSet class - to convert the value from table and store in list
		ResultSet rt=st.executeQuery("select * from Login");
		
		while(rt.next())
		{
			if(username.equals(rt.getString("username"))&&password.equals(rt.getString("password")))
			{
				conm.closeConnection();
				return true;
			}
		}
		
		conm.closeConnection();
		return false;
	}
}
