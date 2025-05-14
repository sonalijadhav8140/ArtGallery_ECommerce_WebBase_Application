package com.shopify.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopify.daoI.ProductDAoI;
import com.shopify.daoIMPL.ProductDaoIMPL;
import com.shopify.model.Product;

@WebServlet("/edit")
public class AdminEditServlet extends HttpServlet{
      
	
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int productid = Integer.parseInt(req.getParameter("id"));
		ProductDAoI pdi=new ProductDaoIMPL();
		Product list = pdi.EditProduct(productid);
		
		 
		
		
		if( list!=null) {
		
			req.setAttribute("p", list);
		RequestDispatcher rd = req.getRequestDispatcher("EditProduct.jsp");
		    rd.forward(req, resp);
		    
		}
		
//		System.out.println(list);
	}
}
