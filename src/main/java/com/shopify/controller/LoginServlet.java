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

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String cemail = req.getParameter("email");
		String password = req.getParameter("password");
          
		
		ProductDAoI pdi = new ProductDaoIMPL();
        
		List<Customer> list = pdi.logincheck(cemail, password);
		
		List<Product> list2 = pdi.getAllData();

		PrintWriter out = res.getWriter();

		if (!list.isEmpty() & list != null) {
			for (Customer l : list) {
				if (l.getCemail().equals("admin@gmail.com") && l.getPassword().equals("admin")) {
                    
					req.setAttribute("Product", list2);
					RequestDispatcher rd = req.getRequestDispatcher("AdminDashboard.jsp");
					rd.forward(req, res);
				}
				
				else {
					req.setAttribute("Customer",list);
					req.setAttribute("Product", list2);
					RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
					rd.forward(req, res);
				}
			}
		   	
		}

		else {

			req.setAttribute("errorMessage", "Incorrect Username and Password...");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}

	}
}
