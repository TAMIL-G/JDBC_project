package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.connectionmanager;
import model.Product;

public class ProductDAO 
{
	public void addProduct(Product product) throws ClassNotFoundException, SQLException
	{
		//1.Java and JDBC connect
		connectionmanager conm=new connectionmanager();
		Connection con=conm.establishConnection(); 
		
		String sql_query = "insert into product(productId,productname,minSellQuantity,price,quantity) values (?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductId());
		ps.setString(2,product.getProductName());
		ps.setInt(3,product.getMinSellQuantity());
		ps.setInt(4,product.getPrice());
		ps.setInt(5,product.getQuantity());
		
		ps.executeUpdate();
		
		conm.closeConnection();
		
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		connectionmanager conm=new connectionmanager();
		Connection con=conm.establishConnection();
        Statement st=con.createStatement();
		
		//ResultSet class - to convert the value from table and store in list
		ResultSet rt=st.executeQuery("select * from product");
		
		while(rt.next())
		{
			System.out.println(rt.getInt("productID")+" | "+ rt.getString("productName")+" | "+rt.getInt("minSellQuantity")+" | "+rt.getInt("price")+" | "+rt.getInt("quantity"));
		}
		conm.closeConnection();
	}
	

}