<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="homepage.css">
<meta charset="UTF-8">
<title>Buy</title>
</head>
<body>

	<header>
		<div class="navbar">
			<a href="success.jsp">Home</a> <a href="#">Contact us</a> <a
				href="login.jsp">Login</a> <a href="register.jsp">Register</a>
		</div>

		
	</header>
<div class="container">
<div class="buy-img">
    <%
        byte[] imgData = (byte[]) request.getAttribute("p_img"); // Retrieve byte[] from request
        String base64Image = (imgData != null) ? Base64.getEncoder().encodeToString(imgData) : "";
    %>
    <% if (!base64Image.isEmpty()) { %>
        <img src="data:image/jpg;base64,<%= base64Image %>" width="300px" />
    <% } else { %>
        <p>No Image Available</p>
    <% } %>
</div>

<div class="ProductInfo">


	<h4>${p.p_name}</h4><br><br>
<p>
Product Name:${p.p_name}<br><br>
Product Description:${p.p_des}<br><br>
Actual Price:${p.act_price}<br><br>
Discount:${p.dis_price}<br><br>
Quantity:${p.quantity}<br><br>
<div class="buy1">
<a href="#">Buy</a>
</div>
</p>
</div>
</div>
</body>
</html>