<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Portal</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&family=Playfair+Display:wght@700&display=swap">
    <style>
        :root {
            --primary: #4a6fa5;
            --secondary: #166088;
            --accent: #4fc3f7;
            --text: #2d3436;
            --bg: #f9f9f9;
        }

        body {
            font-family: 'Montserrat', sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            margin: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            color: var(--text);
        }

        .container {
            text-align: center;
            padding: 2rem;
            background: rgba(255, 255, 255, 0.9);
            border-radius: 16px;
            box-shadow: 0 8px 32px rgba(31, 38, 135, 0.15);
            backdrop-filter: blur(8px);
            -webkit-backdrop-filter: blur(8px);
            border: 1px solid rgba(255, 255, 255, 0.18);
            max-width: 500px;
            width: 90%;
            animation: fadeIn 0.8s ease-out;
        }

        h1 {
            font-family: 'Playfair Display', serif;
            color: var(--secondary);
            margin-bottom: 2rem;
            font-size: 2.5rem;
            position: relative;
        }

        h1::after {
            content: '';
            position: absolute;
            bottom: -10px;
            left: 50%;
            transform: translateX(-50%);
            width: 80px;
            height: 3px;
            background: var(--accent);
        }

        .nav-links {
            display: flex;
            flex-direction: column;
            gap: 1.5rem;
            margin-top: 1rem;
        }

        .nav-link {
            position: relative;
            text-decoration: none;
            color: var(--primary);
            font-weight: 600;
            font-size: 1.2rem;
            padding: 0.8rem 1.5rem;
            transition: all 0.3s ease;
            border-radius: 8px;
            overflow: hidden;
            z-index: 1;
        }

        .nav-link::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, rgba(74, 111, 165, 0.1) 0%, rgba(22, 96, 136, 0.1) 100%);
            z-index: -1;
            transform: scaleX(0);
            transform-origin: left;
            transition: transform 0.3s ease;
        }

        .nav-link:hover {
            color: white;
            transform: translateY(-3px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }

        .nav-link:hover::before {
            transform: scaleX(1);
            background: linear-gradient(90deg, var(--primary) 0%, var(--secondary) 100%);
        }

        .nav-link i {
            margin-right: 10px;
            font-size: 1.1em;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        footer {
            margin-top: 3rem;
            font-size: 0.9rem;
            color: var(--primary);
            opacity: 0.7;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<div class="container">
    <h1>Library Portal</h1>
    <div class="nav-links">
        <a href="people" class="nav-link">
            <i class="fas fa-users"></i> People
        </a>
        <a href="books" class="nav-link">
            <i class="fas fa-book-open"></i> Books
        </a>
    </div>
</div>
<footer>
    © 2023 Library Management System
</footer>
</body>
</html>

