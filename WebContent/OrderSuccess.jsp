<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Successful</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<header class="navbar">
  <h1 class="logo">🛒 MyStore</h1>
  <nav>
    <a href="ProductServlet">Home</a>
    <a href="OrdersServlet">Orders</a>
  </nav>
</header>

<main class="container">
  <h2>Order Successful!</h2>

  <p>Thank you, <strong><%= request.getAttribute("customerName") %></strong>!</p>
  <p>Your order has been placed successfully.</p>

  <a href="ProductServlet" class="btn">Continue Shopping</a>
</main>

<footer>
  <p>© 2025 MyStore</p>
</footer>

</body>
</html>
