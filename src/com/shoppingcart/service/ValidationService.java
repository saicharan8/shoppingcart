package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.DAO.LoginDAO;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Customer;

public class ValidationService {

	
Cart c=new Cart();	
LoginDAO ld = new LoginDAO();

	public boolean validate(Customer c) {
		boolean status = false;
		status = ld.CheckDB(c);
		return status;
	}


}
