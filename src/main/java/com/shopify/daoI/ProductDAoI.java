package com.shopify.daoI;

import java.util.List;

import com.shopify.model.Customer;
import com.shopify.model.Product;

public interface ProductDAoI {

	
	 public List<Product> saveData(Product s);
	 
	 public List<Customer> logincheck(String username,String password);
	 
	 public List<Customer> registeruser(Customer c);
	 
	 public List<Product> getAllData();
		
	 public Product EditProduct(int productid);

	public List<Product> UpdateData(Product s);
	
	public List<Product> DeletData(int id);
	
	public Product Buyproduct(int id);
}
