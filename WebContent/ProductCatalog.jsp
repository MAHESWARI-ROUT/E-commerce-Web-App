<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, com.ecommerce.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Product Catalog</title>
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
  <h2>Available Products</h2>
  <div class="product-grid">
    <%
      List<Product> products = (List<Product>) request.getAttribute("products");
      if (products != null && !products.isEmpty()) {
          for (Product p : products) {
    %>
    <div class="product-card">
      <img src="<%= p.getImage() %>" alt="Product Image">
      <h3><%= p.getName() %></h3>
      <p class="price">₹<%= String.format("%.2f", p.getPrice()) %></p>
      <a href="ProductDetailsServlet?id=<%= p.getId() %>" class="btn">View</a>
    </div>
    <% } } else { %>
      <p>No products available.</p>
    <% } %>
  </div>
</main>

<footer>
  <p>© 2025 MyStore. All rights reserved.</p>
</footer>
</body>
</html>
