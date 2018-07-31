package com.shoppingcart.service;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.shoppingcart.DAO.LoginDAO;
import com.shoppingcart.DAO.OrderManagerDAO;
import com.shoppingcart.DAO.ProductManagerDAO;
import com.shoppingcart.model.*;

public class ProductsService {

	
	ProductManagerDAO pm=new ProductManagerDAO();

	public List<Product> selectAllProducts() throws SQLException {
		return pm.listProducts();

	}

	
	
}
