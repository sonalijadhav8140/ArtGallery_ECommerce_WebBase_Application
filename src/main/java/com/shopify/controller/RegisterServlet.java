package com.shopify.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopify.daoI.ProductDAoI;
import com.shopify.daoIMPL.ProductDaoIMPL;
import com.shopify.model.Customer;
import com.shopify.model.Product;
	public class RegisterServlet extends HttpServlet{

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		      
		     
	           ProductDAoI pdi =new ProductDaoIMPL();
			
			   String name = req.getParameter("cname");
			   String caddr = req.getParameter("caddr");
			   String cemail=req.getParameter("email");
			   String password=req.getParameter("password");
			   
			   Customer c=new Customer();
			   
			   c.setCname(name);
	           c.setCemail(cemail);
	           c.setCaddr(caddr);
	           c.setPassword(password);
	           
	           List<Customer> list = pdi.registeruser(c);
	           
	          res.sendRedirect("login.jsp");
	           
		}
	}
	          
	           
		
	
		

