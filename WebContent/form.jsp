<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Submit Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            padding: 50px;
        }
        .form-box {
            width: 380px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        input, select {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            background: #eef3ff;
        }
        button {
            background: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Submit Form</h2>

    <form action="handleForm" method="post">
        <input type="text" name="username" placeholder="Enter your name" required>
        <input type="email" name="email" placeholder="Enter your email" required>

        <select name="gender" required>
            <option value="">Select Gender</option>
            <option>Male</option>
            <option>Female</option>
        </select>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
