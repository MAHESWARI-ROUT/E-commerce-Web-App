<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ecommerce.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Product Details</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header class="navbar">
  <h1 class="logo">🛒 MyStore</h1>
  <nav>
    <a href="ProductServlet">Home</a>
    <a href="CartServlet">Cart 🛍️</a>
  </nav>
</header>

<main class="container">
<%
  Product product = (Product) request.getAttribute("product");
  if (product != null) {
%>
  <div class="product-details">
    <img src="<%= product.getImage() %>" alt="Product Image">
    <div class="details-text">
      <h2><%= product.getName() %></h2>
      <p class="price">₹<%= String.format("%.2f", product.getPrice()) %></p>
      <p><%= product.getDescription() %></p>
      <form action="CartServlet" method="post">
        <input type="hidden" name="productId" value="<%= product.getId() %>">
        <label>Quantity:</label>
        <input type="number" name="quantity" value="1" min="1" required>
        <button type="submit" class="btn">Add to Cart</button>
      </form>
    </div>
  </div>
<% } else { %>
  <p>Product not found.</p>
<% } %>
</main>

<footer>
  <p>© 2025 MyStore. All rights reserved.</p>
</footer>
</body>
</html>
