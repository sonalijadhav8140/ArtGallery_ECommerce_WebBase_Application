<%@page import="java.util.Base64"%>
<%@page import="com.shopify.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="homepage.css"/> 
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>
<header>
<div class="navbar">
<a href="success.jsp" >Home</a>
<a href="homepage.jsp">Add Product</a>
<a href="login.jsp">Login</a>
<a href="register.jsp">Register</a>
</div>

<div class="panel">
<p>ArtGallery</p> 
</div>
</header>

<h1>Welcome To Shopify</h1>
<div class="box-container">
<%
List<Product> list=(List<Product>)request.getAttribute("Product");
if(list!=null && !list.isEmpty()){
	for(Product p:list){

%>

<div class="box">
 <div class="box-img">
   <% byte[] imgData=p.getImg();
  String base64Image =(imgData !=null) ?
  Base64.getEncoder().encodeToString(imgData) :"";
  %>
 
<img src="data:image/jpg;base64,<%= base64Image %>"width="300px" /></div>
<p>Product Id:<%=p.getProduct_id() %><br>
Product Name:<%= p.getP_name()%><br>
Product Description:<%= p.getP_des() %><br>
Product Actual Price:<%= p.getAct_price()%><br>
Product Discount Price:<%= p.getDis_price() %><br>
Selling Price:<%= p.getSelling_price() %><br>
Quantity :<%= p.getQuantity()%> <br>
<div class="buttons">
<a href="edit?id=<%= p.getProduct_id() %>">Edit</a>

</div> 
<div class="buttons">
<a href="delete?id=<%= p.getProduct_id() %>">Delete</a>
</div>
</p>
</div>

<% }
	%>
	
	
	<% 
}

%>

 </div>
</body>
</html>