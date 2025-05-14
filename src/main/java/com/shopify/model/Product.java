package com.shopify.model;

import javax.servlet.http.Part;

public class Product {
    
	private int product_id;
    private byte[] img; 
	private String p_name;
	private String p_des;
	private double act_price;
	private double dis_price;
	private double selling_price;
	private  int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getP_name() {
		return p_name;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] bs) {
		this.img = bs;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_des() {
		return p_des;
	}
	public void setP_des(String p_des) {
		this.p_des = p_des;
	}
	public double getAct_price() {
		return act_price;
	}
	public void setAct_price(double act_price) {
		this.act_price = act_price;
	}
	public double getDis_price() {
		return dis_price;
	}
	public void setDis_price(double dis_price) {
		this.dis_price = dis_price;
	}
	public double getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(double selling_price) {
		this.selling_price = selling_price;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", p_name=" + p_name + ", p_des=" + p_des + ", act_price="
				+ act_price + ", dis_price=" + dis_price + ", selling_price=" + selling_price + ", quantity=" + quantity
				+ "]";
	}
	
	
	
	
	
	
}
