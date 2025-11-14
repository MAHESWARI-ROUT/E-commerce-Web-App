<%@ page import="java.util.*, com.ecommerce.Product" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Available Products</title>
  <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header class="navbar">
  <h1 class="logo">🛒 MyStore</h1>
  <nav>
    <a href="ProductServlet">Home</a>
    <a href="CartServlet">Cart</a>
    <a href="OrdersServlet">Orders</a>
  </nav>
</header>
<main class="container">
  <h2>Available Products</h2>
  <div class="product-grid">
    <%
      List<Product> products = (List<Product>) request.getAttribute("products");
      if (products != null) {
          for (Product p : products) {
    %>
    <div class="product-card">
      <img src="<%= p.getImage()!=null? p.getImage(): "images/default.png" %>" alt="Product Image">
      <h3><%= p.getName() %></h3>
      <p class="price">₹<%= String.format("%.2f", p.getPrice()) %></p>
      <form action="ProductDetailsServlet" method="get">
        <input type="hidden" name="id" value="<%=p.getId()%>">
        <button class="btn">View</button>
      </form>
    </div>
    <%
          }
      } else {
    %>
    <p>No products available.</p>
    <% } %>
  </div>
</main>
<footer>© 2025 MyStore</footer>
</body>
</html>
