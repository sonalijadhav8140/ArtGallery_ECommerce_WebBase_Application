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

public class HomeServlete extends HttpServlet{
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDAoI pdi=new ProductDaoIMPL();
		List<Product> list = pdi.getAllData();
		 
		req.setAttribute("Product", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("AdminDashboard.jsp");
		    rd.forward(req, resp);
		    System.out.println(list);
	}
}
