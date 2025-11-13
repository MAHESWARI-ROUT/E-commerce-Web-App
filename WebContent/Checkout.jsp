<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header class="navbar">
  <h1 class="logo">🛒 MyStore</h1>
  <nav>
    <a href="ProductServlet">Home</a>
    <a href="CartServlet">Cart</a>
  </nav>
</header>

<main class="container">
  <h2>Checkout</h2>
  <form action="CheckoutServlet" method="post" class="checkout-form">
    <label>Name:</label>
    <input type="text" name="name" required>

    <label>Address:</label>
    <textarea name="address" required></textarea>

    <label>Payment Method:</label>
    <select name="payment" required>
      <option value="card">Credit/Debit Card</option>
      <option value="upi">UPI</option>
      <option value="cod">Cash on Delivery</option>
    </select>

    <button type="submit" class="btn">Place Order</button>
  </form>
</main>

<footer>
  <p>© 2025 MyStore. All rights reserved.</p>
</footer>
</body>
</html>
