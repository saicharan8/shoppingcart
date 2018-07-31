package com.shoppingcart.DAO;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.shoppingcart.model.Customer;

import java.sql.*; 

public class LoginDAO {

	Connection con;
	
	public void loadDB() throws ClassNotFoundException, SQLException {	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=cochin;integratedSecurity=true;", "SYADAVELLI01", "Geethasrinu@19");
	}
	
	public boolean CheckDB(Customer c){  
		boolean status=false; 
		
		try{  
		 loadDB();
		PreparedStatement ps=con.prepareStatement(  
		"select * from [dbo].[UserDetail] where userName=? and userPassword=?");  
		ps.setString(1,c.getName());  
		ps.setString(2,c.getPassword());  
		ResultSet rs=ps.executeQuery();
		status=rs.next();  
		          
		}catch(Exception e){
			System.out.println("Connection to database failed");
			System.out.println(e);
			}  
		return status;  
		}

 
	
	
	
	
	
}
