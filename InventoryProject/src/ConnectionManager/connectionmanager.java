package ConnectionManager;

import java.sql.*;

public class connectionmanager
{
	Connection con=null;
	public Connection establishConnection()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryProject","root","tamil");
		return con;
	}
	public void closeConnection()throws SQLException
	
	{
		con.close();
	}

}
