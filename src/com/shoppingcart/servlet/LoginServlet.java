package com.shoppingcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingcart.DAO.*;
import com.shoppingcart.model.Customer;
import com.shoppingcart.service.ProductsService;
import com.shoppingcart.service.ValidationService;  

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  RequestDispatcher rd=request.getRequestDispatcher("Product.jsp");  
	        rd.forward(request,response);  
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    ProductsService ss=new ProductsService();
	          
	    String name=request.getParameter("username");  
	    String password=request.getParameter("userpass");  
	    Customer c=new Customer(name,password);
	    ValidationService vs=new ValidationService();
	          
	    if(vs.validate(c)){  
	    	HttpSession session=request.getSession();
	    	session.setAttribute("user", name);
	    	session.setMaxInactiveInterval(10);
	        RequestDispatcher rd=request.getRequestDispatcher("ProductServlet");  
	        rd.forward(request,response);  
	    }  
	    else{
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	        rd.include(request,response);  
	    }  
	         
	    
	    }  

}
