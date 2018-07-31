package com.shoppingcart.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.*;

public class OrderManagerDAO {

	Cart c=new Cart();
	Connection con;
	ResultSet rs;
	
	public void loadDB() throws ClassNotFoundException, SQLException {	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=cochin;integratedSecurity=true;", "SYADAVELLI01", "Geethasrinu@19");
	}
	
	public void insertOrders(Cart c) throws SQLException {
		
		try {
			loadDB();
			String sql = "insert into OrderDetails (TotalPrice,userID) values (? , ? )";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, c.TotalPrice);
			st.setInt(2, c.OID);
			st.executeUpdate();	
		} 
	  catch (ClassNotFoundException e) {
	  	// TODO Auto-generated catch block
		System.out.println("cannot insert orders");
		e.printStackTrace();
	}
	}
	
	
	 public List<Cart> displayOrder() throws SQLException {

		List<Cart> arrC=new ArrayList<Cart>();
		try {
			loadDB();
			Statement st = con.createStatement();

			String sql = "select * from OrderDetails";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				int oId = rs.getInt("OID");

				int Price = rs.getInt("TotalPrice");
				arrC.add(new Cart(oId, Price));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error in displaying");
			e.printStackTrace();

		} 
		finally {	
			con.close();
		}
		return arrC;
	}
	 
		public void clearOrders() {
			// TODO Auto-generated method stub
			try{  
				 loadDB();
				PreparedStatement ps=con.prepareStatement("delete from OrderDetails ");  
				ps.executeQuery();  
				}catch(Exception e){
					System.out.println("orders cleared");
				}  
			
		} 
	 


	
}
