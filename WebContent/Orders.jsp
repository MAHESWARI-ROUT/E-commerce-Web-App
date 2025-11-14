<%@ page import="java.util.*, com.ecommerce.OrderSummary" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
  List<OrderSummary> orders = (List<OrderSummary>) request.getAttribute("orders");
%>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>Orders</title><link rel="stylesheet" href="assets/css/style.css"></head>
<body>
<header class="navbar"><a href="ProductServlet">Home</a></header>
<main class="container">
  <h2>Order History (Summary)</h2>
  <% if (orders == null || orders.isEmpty()) { %>
    <p>No orders yet.</p>
  <% } else { %>
    <table class="orders-table">
      <tr><th>Order Ref</th><th>Items</th><th>Total (₹)</th><th>Placed At</th></tr>
      <% for (OrderSummary s : orders) { %>
        <tr>
          <td><%= s.getOrderRef()>0 ? s.getOrderRef() : "-" %></td>
          <td style="text-align:left;"><%= s.getItemsText() %></td>
          <td><%= String.format("%.2f", s.getTotalAmount()) %></td>
          <td><%= s.getCreatedAt() %></td>
        </tr>
      <% } %>
    </table>
  <% } %>
</main>
</body>
</html>
