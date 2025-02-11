<!-- welcome.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .welcome-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }
        h2 {
            color: #4CAF50;
        }
        .welcome-message {
            margin-top: 20px;
            font-size: 18px;
            color: #333;
        }
        .logout-button {
            background-color: #f44336;
            color: white;
            padding: 12px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
            width: 100%;
        }
        .logout-button:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>

    <div class="welcome-container">
        <h2>Welcome, <%= session.getAttribute("userName") %>!</h2>
        <p class="welcome-message">Your email: <%= session.getAttribute("userEmail") %></p>
        <form action="logout" method="get">
            <button type="submit" class="logout-button">Logout</button>
        </form>
    </div>

</body>
</html>
