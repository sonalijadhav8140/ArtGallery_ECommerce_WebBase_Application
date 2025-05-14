package com.shopify.daoIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopify.daoI.ProductDAoI;
import com.shopify.dbconnection.JDBC_Connection;
import com.shopify.model.Customer;
import com.shopify.model.Product;

public class ProductDaoIMPL implements ProductDAoI {

	
	private Connection con=JDBC_Connection.getconnection();
	
	@Override
	public List<Product> saveData(Product s) {
		List<Product> list=null;
		String sql="insert into product(img,pname,pdesc,acprice,disprice,quantity) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			                  psmt.setBytes(1, s.getImg());
			                  psmt.setString(2,s.getP_name());
			                  psmt.setString(3,s.getP_des());
			                  psmt.setDouble(4, s.getAct_price());
			                  psmt.setDouble(5, s.getDis_price());
			                  psmt.setInt(6, s.getQuantity());
			                  boolean execute = psmt.execute();
			                  
			            String sql2="select * from Product";
			            
			            Statement smt = con.createStatement();
			            ResultSet rs = smt.executeQuery(sql2);
			            
			            
			                  list=new ArrayList();
			                  while(rs.next()) {
			                	  
			                	  Product pro=new Product();
			                	  pro.setProduct_id(rs.getInt(1));
			                	  pro.setP_name(rs.getString(2));
			                	  pro.setP_des(rs.getString(3));
			                	  pro.setAct_price(rs.getDouble(4));
			                	  pro.setDis_price(rs.getDouble(5));
			                   	  pro.setQuantity(rs.getInt(6));
			                   	  pro.setSelling_price(rs.getDouble(7));
			                   	 pro.setImg(rs.getBytes("img"));
			                	  list.add(pro);
			                	  
			                  }
			                  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<Customer> logincheck(String cemail, String password) {
		List<Customer> list=null;
		
		try {
			
			
				String sql="select * from customer where email='"+cemail+"'and password='"+password+"'";
			
			   Statement smt = con.createStatement();
			        ResultSet rs = smt.executeQuery(sql);
			        list = new ArrayList<>();
			       
			        while(rs.next()) {
			        	Customer c=new Customer();
			        
			        	 c.setCid(rs.getInt(1));
			        	 c.setCname(rs.getString(2));
			        	 c.setCaddr(rs.getString(3));
			        	 c.setCemail(rs.getString(4));
			        	 c.setPassword(rs.getString(5));
			        	 
			        	 list.add(c);
			        	
			        }
			      
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<Customer> registeruser(Customer c) {
		 List<Customer> list=null;
		String sql="insert into Customer(cname,caddr,email,password) values(?,?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			
			    psmt.setString(1,c.getCname());
			    psmt.setString(2,c.getCaddr());
			    psmt.setString(3, c.getCemail());
			    psmt.setString(4,c.getPassword());
			    
			    boolean execute = psmt.execute();
			   
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<Product> getAllData() {
	  List<Product> list=null;
	  
	  String sql="select * from product";
	  
	  try {
		Statement smt = con.createStatement();
		       ResultSet rs = smt.executeQuery(sql);
		       
		       
		       list=new ArrayList();
               while(rs.next()) {
             	  
             	  Product pro=new Product();
             	  pro.setProduct_id(rs.getInt(1));
             	  pro.setP_name(rs.getString(2));
             	  pro.setP_des(rs.getString(3));
             	  pro.setAct_price(rs.getDouble(4));
             	  pro.setDis_price(rs.getDouble(5));
                	  pro.setQuantity(rs.getInt(6));
                	  pro.setSelling_price(rs.getDouble(7));
                	 pro.setImg(rs.getBytes("img"));
             	  list.add(pro);
             	  
               }

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return list;
		
	}

	@Override
	public Product EditProduct(int productid) {
		Product p=null;
		
	String sql="select * from product where pid='"+productid+"'";
	
	try {
		Statement smt = con.createStatement();
		     ResultSet rs = smt.executeQuery(sql);
		     
		     
		     if(rs.next()) {
		    	 
		    	 p=new Product();
		    	 p.setProduct_id(rs.getInt(1));
		    	 p.setP_name(rs.getString("pname"));
		    	 p.setImg(rs.getBytes("img"));
		    	 p.setP_des(rs.getString("pdesc"));
		    	 p.setAct_price(rs.getDouble("acprice"));
		    	 p.setDis_price(rs.getDouble("disprice"));
		    	 p.setSelling_price(rs.getDouble("sellingprice"));
		    	 p.setQuantity(rs.getInt("quantity"));
		    	 
		    	 
		    	 
		     }
		     
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return p;
		
		
		
		
	}
     
	
	@Override
	public List<Product> UpdateData(Product s) {
		List<Product> list=null;
		String sql="update product set img=?,pname=?,pdesc=?,acprice=?,disprice=?,quantity=? where pid=?";
		
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			                
			                  psmt.setBytes(1, s.getImg());
			                  psmt.setString(2,s.getP_name());
			                  psmt.setString(3,s.getP_des());
			                  psmt.setDouble(4, s.getAct_price());
			                  psmt.setDouble(5, s.getDis_price());
			                  psmt.setInt(6, s.getQuantity());
			                  psmt.setInt(7,s.getProduct_id());
			                  boolean execute = psmt.execute();
			                  
			            String sql2="select * from Product";
			            
			            Statement smt = con.createStatement();
			            ResultSet rs = smt.executeQuery(sql2);
			            
			            
			                  list=new ArrayList();
			                  while(rs.next()) {
			                	  
			                	  Product pro=new Product();
			                	  pro.setProduct_id(rs.getInt(1));
			                	  pro.setP_name(rs.getString(2));
			                	  pro.setP_des(rs.getString(3));
			                	  pro.setAct_price(rs.getDouble(4));
			                	  pro.setDis_price(rs.getDouble(5));
			                   	  pro.setQuantity(rs.getInt(6));
			                   	  pro.setSelling_price(rs.getDouble(7));
			                   	 pro.setImg(rs.getBytes("img"));
			                	  list.add(pro);
			                	  
			                  }
			                  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<Product> DeletData(int id) {
		List<Product> list=null;
		
		String sql="delete from Product where pid='"+id+"'";
		try {
			Statement smt = con.createStatement();
			smt.execute(sql);
			list = getAllData();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Product Buyproduct(int id) {
	Product pro=null;
		
    String sql="select * from Product where pid='"+id+"'";
    try {
		Statement smt = con.createStatement();
		   ResultSet rs = smt.executeQuery(sql);
		 
		   if(rs.next()) {
			   
			   pro=new Product();
         	  
         	  pro.setProduct_id(rs.getInt(1));
         	  pro.setP_name(rs.getString(2));
         	  pro.setP_des(rs.getString(3));
         	  pro.setAct_price(rs.getDouble(4));
         	  pro.setDis_price(rs.getDouble(5));
            	  pro.setQuantity(rs.getInt(6));
            	  pro.setSelling_price(rs.getDouble(7));
            	 pro.setImg(rs.getBytes("img"));
         	  
			   
		   }
		   
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return pro;
			
		
	}
   
	
	
	
	
}
