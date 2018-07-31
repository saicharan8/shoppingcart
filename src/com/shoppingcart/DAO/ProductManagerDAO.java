package com.shoppingcart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.Product;

public class ProductManagerDAO {

	Connection con;
	ResultSet rs;
	
	public List<Product> listProducts() throws SQLException {

		List<Product> pArrList = new ArrayList<>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=cochin;integratedSecurity=true;",
					"SYADAVELLI01", "Geethasrinu@19");
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from products");
			while (rs.next()) {
				int pId = rs.getInt("PID");
				String pName = rs.getString("PName");
				int pPrice = rs.getInt("Price");
				pArrList.add(new Product(pId, pName, pPrice));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to load products list");
			e.printStackTrace();
		} finally {
			con.close();
		}
		return pArrList;
	}
	
	
	
	
	
}
