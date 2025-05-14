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

@WebServlet("/products")
public class Index extends HttpServlet{
	
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
		ProductDAoI pdi=new ProductDaoIMPL();
		
		List<Product> list = pdi.getAllData();
		

	    req.setAttribute("Product", list);
	   
	    if(!list.isEmpty()) {
	    	
	    	RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
	    	rd.forward(req, res);
	    	
	    }
		
	}

}
