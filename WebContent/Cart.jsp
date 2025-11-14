<%@ page import="java.util.*, com.ecommerce.Product, com.ecommerce.ProductDAO" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<link rel="stylesheet" href="assets/css/style.css">
<style>
    .cart-container {
        width: 90%;
        max-width: 900px;
        margin: 30px auto;
        background: #fff;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 3px 8px rgba(0,0,0,0.1);
    }
    .cart-title {
        font-size: 28px;
        margin-bottom: 20px;
        font-weight: bold;
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 25px;
    }
    table th {
        background: #0078d7;
        color: white;
        padding: 12px;
        font-size: 16px;
    }
    table td {
        padding: 12px;
        border-bottom: 1px solid #eee;
        text-align: center;
        font-size: 15px;
    }
    .total-box {
        font-size: 22px;
        font-weight: bold;
        text-align: right;
        margin-top: 15px;
        color: #111;
    }
    .checkout-btn {
        display: inline-block;
        margin-top: 20px;
        padding: 12px 22px;
        background: #0078d7;
        color: white;
        border-radius: 6px;
        text-decoration: none;
        font-size: 17px;
        transition: 0.2s;
    }
    .checkout-btn:hover {
        background: #005bb5;
    }
</style>
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

<div class="cart-container">
    <div class="cart-title">Your Cart</div>

    <%
        Map<Integer, Integer> cart = null;
        HttpSession s = request.getSession(false);
        if (s != null) {
            cart = (Map<Integer, Integer>) s.getAttribute("cart");
        }

        if (cart == null || cart.isEmpty()) {
    %>

    <p>Your cart is empty.</p>

    <% } else { 
        double grandTotal = 0;
    %>

    <table>
        <tr>
            <th>Product</th>
            <th>Qty</th>
            <th>Price</th>
            <th>Total</th>
        </tr>

        <%
            for (Map.Entry<Integer, Integer> e : cart.entrySet()) {
                Product p = ProductDAO.getProductById(e.getKey());
                int qty = e.getValue();
                double line = p.getPrice() * qty;
                grandTotal += line;
        %>

        <tr>
            <td><%= p.getName() %></td>
            <td><%= qty %></td>
            <td>₹<%= String.format("%.2f", p.getPrice()) %></td>
            <td>₹<%= String.format("%.2f", line) %></td>
        </tr>

        <% } %>
    </table>

    <div class="total-box">Total: ₹<%= String.format("%.2f", grandTotal) %></div>

    <a href="Checkout.jsp" class="checkout-btn">Proceed to Checkout</a>

    <% } %>
</div>

</body>
</html>
