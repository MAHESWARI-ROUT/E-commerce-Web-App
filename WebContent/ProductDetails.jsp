<%@ page import="com.ecommerce.Product" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
  Product product = (Product) request.getAttribute("product");
%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title><%= product!=null ? product.getName() : "Product" %></title>
  <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header class="navbar"><a href="ProductServlet">Home</a> | <a href="CartServlet">Cart</a></header>
<main class="container">
  <% if (product == null) { %>
    <p>Product not found.</p>
  <% } else { %>
  <div class="product-details">
    <img src="<%= product.getImage()!=null? product.getImage(): "images/default.png" %>" alt="Product Image">
    <div class="details-text">
      <h2><%= product.getName() %></h2>
      <p class="price">₹<%= String.format("%.2f", product.getPrice()) %></p>
      <p><%= product.getDescription() %></p>
      <form action="CartServlet" method="post">
        <input type="hidden" name="productId" value="<%= product.getId() %>">
        Quantity: <input type="number" name="quantity" value="1" min="1">
        <button class="btn" type="submit">Add to Cart</button>
      </form>
    </div>
  </div>
  <% } %>
</main>
</body>
</html>
