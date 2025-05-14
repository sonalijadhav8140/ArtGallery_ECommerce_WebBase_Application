<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditProduct</title>
<link rel="stylesheet" href="homepage.css"/>
</head>
<body>

<header>
<div class="navbar">
<a href="success.jsp" >Home</a>
<a href="#">Contact us</a>
<a href="login.jsp">Login</a>
<a href="register.jsp">Register</a>
</div>

<div class="panel">
<p>ArtGallery</p> 
</div>
</header>

	
<form action="update" method="post" enctype="multipart/form-data">
<h1>Edit Product</h1>


Product Id<input type="text" name="product_id" value="${p.product_id}" >
Product Image:<input type="file" name="img"  value="${p.img}" ><br><br>
Product Name:<input type="text" name="p_name" value="${p.p_name}"><br><br>
Product Description:<input type="text" name="p_des" value="${p.p_des}"><br><br>
Actual Price:<input type="text" name="act_price" value="${p.act_price}"><br><br>
Discount:<input type="text" name="dis_price" value="${p.dis_price}"><br><br>
Quantity<input type="text" name="quantity" value="${p.quantity}"><br><br>

<input type="submit" value="Update">


</from>
</body>
</html>