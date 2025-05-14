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

@WebServlet("/buy")
public class BuyServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		ProductDAoI pdi=new ProductDaoIMPL();
		
		
		 Product list = pdi.Buyproduct(id);
		System.out.println(id);
        System.out.println(list);
	    req.setAttribute("p", list);
	    req.setAttribute("p_img", list.getImg()); 
	    
	    if(list!=null) {
	    	
	    	RequestDispatcher rd = req.getRequestDispatcher("Buy.jsp");
	    	rd.forward(req, res);
	    	System.out.println(list);
	     
}
		
	}

}
