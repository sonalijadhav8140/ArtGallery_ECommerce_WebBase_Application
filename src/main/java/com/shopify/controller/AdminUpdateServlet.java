package com.shopify.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shopify.daoI.ProductDAoI;
import com.shopify.daoIMPL.ProductDaoIMPL;
import com.shopify.model.Product;
@MultipartConfig
@WebServlet("/update")
public class AdminUpdateServlet extends HttpServlet{
	  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
            int product_id= Integer.parseInt(req.getParameter("product_id"));
            InputStream inputStream=null;
    		Part img = req.getPart("img");
    	     
    	    	  inputStream = img.getInputStream();
    	      
    	      byte[] imageBytes= inputStream.readAllBytes();
    		//String img = req.getParameter("img");
    		String p_name = req.getParameter("p_name");
    		String p_des = req.getParameter("p_des");
    		double act_price =Double.parseDouble(req.getParameter("act_price"));
    		
    		double dis_price = Double.parseDouble(req.getParameter("dis_price"));
    		
    		int quantity = Integer.parseInt(req.getParameter("quantity"));
    		
    		ProductDAoI pdi=new ProductDaoIMPL();
    		Product p=new Product();
    		
    		p.setProduct_id(product_id);
    		p.setImg(imageBytes);
    		p.setP_name(p_name);
    		p.setP_des(p_des);
    		p.setAct_price(act_price);
    		p.setDis_price(dis_price);
    	   
    	    p.setQuantity(quantity);
    	     
    	    List<Product> list = pdi.UpdateData(p);
    	    
    	    req.setAttribute("Product", list);
    	    
    	    if(!list.isEmpty()) {
    	    	
    	    	RequestDispatcher rd = req.getRequestDispatcher("AdminDashboard.jsp");
    	    	rd.forward(req, resp);
    	    	System.out.println(list);
		     
	}
	
}
}
