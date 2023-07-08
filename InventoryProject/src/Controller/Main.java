package Controller;

import java.sql.SQLException;

import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;

public class Main
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		Scanner k=new Scanner(System.in);
		int choice,option;
		
		Login login = new Login();
		Product product = new Product();
		LoginDAO logindao=new LoginDAO();
		ProductDAO productdao= new ProductDAO();
		do 
		{
			System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("------------------------------------------------");
			System.out.println("Enter your choice");
			choice=k.nextInt();
			switch(choice)
			{
			case 1: System.out.println("Admin Login:-");
			System.out.println("------------------------------------------------");
			k.nextLine();
			System.out.println("Enter your username");
			String username = k.nextLine();
			System.out.println("Enter your password");
			String password = k.nextLine();
			login.setUsername(username);
			login.setPassword(password);
			if(logindao.validate(login))
					{
						System.out.println("Login Success!!!!!!!!");
						System.out.println();
						do
						{
							System.out.println("--------------------------------------------------------");
							System.out.println("1.Add product");
							System.out.println("2.Display product");
							System.out.println("3.Logout");
							System.out.println("---------------------------------------------------------");
							System.out.println("Enter your option");
							option = k.nextInt();
							switch(option)
							{
							case 1: System.out.println("Add product");
							System.out.println("---------------------------------------------------------");
							System.out.println("Enter the productID");
							int productID = k.nextInt();
							k.nextLine();
							System.out.println("Enter the productName");
							String productName = k.nextLine();
							System.out.println("Enter the minimum sell quantity");
							int minsellQuantity = k.nextInt();
							System.out.println("Enter the price");
							int price = k.nextInt();
							System.out.println("Enter the quantity");
							int quantity = k.nextInt();
							product.setProductId(productID);
							product.setProductName(productName);
							product.setMinSellQuantity(minsellQuantity);
							product.setPrice(price);
							product.setQuantity(quantity);
							productdao.addProduct(product);
							break;
							case 2: System.out.println("Display product");
							productdao.display();
							break;
							case 3: System.out.println("Logout");
							break;
							}
						}while(option!=3);

					}
			else
			{
				System.out.println("Login Failure");
			}
			break;
			case 2: System.out.println("Agent Login:-");
			System.out.println("------------------------------------------------");
			k.nextLine();
			System.out.println("Enter your username");
			String username1 = k.nextLine();
			System.out.println("Enter your password");
			String password1 = k.nextLine();
			login.setUsername(username1);
			login.setPassword(password1);
			if(logindao.validate(login))
					{
						System.out.println("Login Success!!!!!!!!");
						System.out.println();
						do
						{
							System.out.println("--------------------------------------------------------");
							System.out.println("1.Display product");
							System.out.println("2.Logout");
							System.out.println("---------------------------------------------------------");
							System.out.println("Enter your option");
							option = k.nextInt();
							switch(option)
							{
							case 1: System.out.println("Display product");
							productdao.display();
							break;
							case 2: System.out.println("Logout");
							break;
							}
						}while(option!=2);
					}
			else
			{
				System.out.println("Login Failure");
			}
			break;
			case 3: System.out.println("Exit");
			break;
			}
			
		}while(choice!=3);
		k.close();

	}

}
