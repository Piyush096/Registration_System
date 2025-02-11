<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }
        fieldset {
            margin-bottom: 15px;
            padding: 15px;
            border: 1px solid #ccc;
        }
        legend {
            font-weight: bold;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="email"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        .register-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .register-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h2>Registration Page</h2>

<form action="process_registration" method="post">
    <!-- Personal Information -->
    <fieldset>
        <legend>Personal Information</legend>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        
        <label>Gender:</label>
        <input type="radio" id="male" name="gender" value="Male" required>
        <label for="male" style="display: inline;">Male</label>
        
        <input type="radio" id="female" name="gender" value="Female" required>
        <label for="female" style="display: inline;">Female</label>

        <label for="city">State:</label>
        <select id="city" name="state" required>
            <option value="">Select State</option>
            <option value="Bihar">Bihar</option>
            <option value="Bihar">WestBengal</option>
            <option value="Karnataka">Karnataka</option>
            <option value="other">other</option>
        </select>
    </fieldset>

    <button type="submit" class="register-btn" value ="Register">Register</button>
</form>


</body>
</html>