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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		ProductDAoI pdi=new ProductDaoIMPL();
		
		List<Product> list = pdi.DeletData(id);
		

		if( list!=null) {
		
			req.setAttribute("Product", list);
		RequestDispatcher rd = req.getRequestDispatcher("AdminDashboard.jsp");
		    rd.forward(req, res);
		    
		}
		
	}

}
