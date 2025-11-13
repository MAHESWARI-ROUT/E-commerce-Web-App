<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.ecommerce.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>🛍️ Product Catalog</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            padding: 20px;
            color: #333;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 25px;
            padding: 30px;
        }
        .card {
            background: white;
            width: 230px;
            border-radius: 10px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            text-align: center;
            padding: 15px;
            transition: transform 0.2s ease;
        }
        .card:hover {
            transform: scale(1.03);
        }
        .card img {
            width: 100%;
            height: 160px;
            object-fit: cover;
            border-radius: 8px;
        }
        .product-name {
            font-size: 18px;
            font-weight: bold;
            margin-top: 10px;
            color: #222;
        }
        .price {
            color: #28a745;
            font-size: 16px;
            margin: 5px 0;
        }
        .btn {
            display: inline-block;
            background-color: #007bff;
            color: white;
            padding: 8px 14px;
            border-radius: 6px;
            text-decoration: none;
            transition: background-color 0.2s;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h2>🛍️ Available Products</h2>

<div class="container">
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if (products != null && !products.isEmpty()) {
        for (Product p : products) {
%>
    <div class="card">
        <img src="<%=p.getImage()%>" alt="<%=p.getName()%>">
        <div class="product-name"><%=p.getName()%></div>
        <div class="price">&#8377;<%=p.getPrice()%></div>
        <a href="ProductDetailsServlet?id=<%=p.getId()%>" class="btn">View Details</a>
    </div>
<%
        }
    } else {
%>
    <p style="text-align:center; color:red;">No products available.</p>
<%
    }
%>
</div>

</body>
</html>
