<head>
    <meta charset="UTF-8" />
    <title>Shopping Cart App</title>
    <style>
        /* Reset & base */
        * {
            box-sizing: border-box;
        }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: #333;
            margin: 0;
            padding: 0;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            padding: 40px 20px;
        }
        h2 {
            color: #fff;
            font-weight: 700;
            margin-bottom: 30px;
            text-shadow: 1px 1px 6px rgba(0,0,0,0.3);
        }

        /* Container for forms and content */
        .container {
            background: #fff;
            border-radius: 12px;
            padding: 30px 40px;
            max-width: 600px;
            width: 100%;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
        }

        /* Forms */
        form {
            display: flex;
            flex-direction: column;
            gap: 18px;
        }
        label {
            font-weight: 600;
            margin-bottom: 6px;
            color: #444;
        }
        input[type="text"], 
        input[type="password"], 
        select {
            padding: 12px 15px;
            border-radius: 8px;
            border: 1.8px solid #ccc;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }
        input[type="text"]:focus, 
        input[type="password"]:focus, 
        select:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 8px rgba(102, 126, 234, 0.6);
        }
        .error {
            color: #d9534f;
            font-size: 14px;
            margin-top: -12px;
        }

        /* Buttons */
        input[type="submit"], button {
            background: #667eea;
            border: none;
            color: #fff;
            font-weight: 700;
            padding: 14px 0;
            font-size: 18px;
            border-radius: 10px;
            cursor: pointer;
            transition: background 0.3s ease;
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
            margin-top: 10px;
        }
        input[type="submit"]:hover, button:hover {
            background: #5a67d8;
            box-shadow: 0 8px 20px rgba(90, 103, 216, 0.6);
        }

        /* Tables */
        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 12px;
            margin-top: 20px;
            font-size: 16px;
        }
        th {
            background-color: #764ba2;
            color: #fff;
            font-weight: 700;
            padding: 12px 15px;
            border-radius: 12px 12px 0 0;
            text-align: left;
            box-shadow: 0 3px 10px rgba(118, 75, 162, 0.6);
        }
        td {
            background-color: #f7f7f7;
            padding: 15px;
            border-left: 4px solid #667eea;
            color: #333;
            vertical-align: middle;
        }
        tr:last-child td {
            border-radius: 0 0 12px 12px;
        }

        /* Checkbox groups */
        .checkbox-group {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            justify-content: flex-start;
            margin-top: 10px;
        }
        .checkbox-group label {
            background: #f0f4ff;
            border-radius: 10px;
            padding: 10px 16px;
            cursor: pointer;
            font-weight: 600;
            user-select: none;
            border: 2px solid transparent;
            transition: all 0.3s ease;
        }
        .checkbox-group input[type="checkbox"] {
            display: none;
        }
        .checkbox-group input[type="checkbox"]:checked + label {
            background: #667eea;
            color: white;
            border-color: #4c63d9;
            box-shadow: 0 4px 12px rgba(102, 126, 234, 0.5);
        }

        /* Links */
        a {
            color: #667eea;
            text-decoration: none;
            font-weight: 600;
            transition: color 0.3s ease;
            display: inline-block;
            margin-top: 20px;
        }
        a:hover {
            color: #4c63d9;
            text-decoration: underline;
        }

        /* Responsive */
        @media (max-width: 640px) {
            .container {
                padding: 20px 25px;
            }
            table {
                font-size: 14px;
            }
            input[type="submit"], button {
                font-size: 16px;
                padding: 12px 0;
            }
        }
    </style>
</head>
