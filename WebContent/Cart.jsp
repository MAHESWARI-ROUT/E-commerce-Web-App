<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, com.ecommerce.DBConnection" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header class="navbar">
  <h1 class="logo">🛒 MyStore</h1>
  <nav>
    <a href="ProductServlet">Home</a>
    <a href="Checkout.jsp">Checkout</a>
  </nav>
</header>

<main class="container">
<h2>Your Shopping Cart</h2>
<table class="cart-table">
<tr><th>Product</th><th>Quantity</th><th>Price</th><th>Total</th></tr>
<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT p.name, p.price, c.quantity FROM cart c JOIN products p ON c.product_id=p.id");
double grandTotal = 0;
while (rs.next()) {
    double total = rs.getDouble("price") * rs.getInt("quantity");
    grandTotal += total;
%>
<tr>
  <td><%= rs.getString("name") %></td>
  <td><%= rs.getInt("quantity") %></td>
  <td>₹<%= rs.getDouble("price") %></td>
  <td>₹<%= String.format("%.2f", total) %></td>
</tr>
<% } %>
</table>
<h3>Total: ₹<%= String.format("%.2f", grandTotal) %></h3>
<form action="CheckoutServlet" method="post">
  <button type="submit" class="btn">Proceed to Checkout</button>
</form>
</main>

<footer>
  <p>© 2025 MyStore. All rights reserved.</p>
</footer>
</body>
</html>
