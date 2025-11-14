<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
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

    <label>Full Name:</label>
    <input type="text" name="customerName" required>

    <label>Phone:</label>
    <input type="text" name="phone" required>

    <label>Address:</label>
    <textarea name="address" required></textarea>

    <label>Payment Method:</label>
    <select name="paymentMethod" required>
      <option value="Card">Credit/Debit Card</option>
      <option value="UPI">UPI</option>
      <option value="COD">Cash on Delivery</option>
    </select>

    <button type="submit" class="btn">Place Order</button>
  </form>
</main>

<footer>
  <p>© 2025 MyStore</p>
</footer>

</body>
</html>
