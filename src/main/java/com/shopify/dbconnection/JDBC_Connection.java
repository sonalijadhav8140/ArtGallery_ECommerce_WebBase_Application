package com.shopify.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {

	   public static Connection con=null;

	public static Connection getconnection() {
				
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopify","root","root");
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return con;
		
		
		
	}
	
}
