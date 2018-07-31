package com.shoppingcart.servlet;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import com.shoppingcart.model.*;
import com.shoppingcart.service.*;  
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
		    processRequest(request, response);
		    }  
	
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		    int OID =Integer.parseInt(request.getParameter("id"));
	        int TotalPrice = Integer.parseInt(request.getParameter("price"));
	        
	        Cart c=new Cart(OID,TotalPrice);
	        OrderManagerService oms=new OrderManagerService();
	        
		    try {
				oms.insertOrder(c);
				RequestDispatcher rd=request.getRequestDispatcher("Product.jsp");
				rd.include(request,response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    
	    }
	  
	  public void processRequest(HttpServletRequest request, HttpServletResponse response)  
			    throws ServletException, IOException {  
			ProductsService ss=new ProductsService();   
	        try {
	        	List<Product> arrPro = new ArrayList<Product>();
				arrPro=ss.selectAllProducts();
				RequestDispatcher rd=request.getRequestDispatcher("Product.jsp");
				RequestDispatcher rd2=request.getRequestDispatcher("CartServlet");
				rd.include(request,response);
				
				
			} catch (SQLException e) {
				System.out.println("cannot list products");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
		}
}
