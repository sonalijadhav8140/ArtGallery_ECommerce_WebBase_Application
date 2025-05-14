<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="homepage.css"/>
<meta charset="UTF-8">
<title>Homepage</title>
<link rel="stylesheet" href=homepage.css/> 
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

<form action="home" method="post" enctype="multipart/form-data">
<h1>Add Product</h1>
Product Image:<input type="file" name="img" required><br><br>
Product Name:<input type="text" name="p_name" required><br><br>
Product Description:<input type="text" name="p_des" required><br><br>
Actual Price:<input type="text" name="act_price" required><br><br>
Discount:<input type="text" name="dis_price" required><br><br>
Quantity<input type="text" name="quantity" required><br><br>

<input type="submit" value="Submit">
</form>]
</body>
</html>