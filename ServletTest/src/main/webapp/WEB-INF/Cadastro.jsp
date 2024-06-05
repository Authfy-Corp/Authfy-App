
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #007BFF;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: 'Poppins', sans-serif;
        }
        .cadastro-container {
            background-color: #007BFF;
            padding: 2rem;
            border-radius: 15px;
            box-shadow: 9px 9px 16px #0063cc, -9px -9px 16px #008fff;
            text-align: center;
            color: white;
        }
        .cadastro-container h1 {
            margin-bottom: 1.5rem;
            font-size: 2.5rem;
            text-shadow: 3px 3px 6px #0063cc, -3px -3px 6px #008fff;
        }
        .form-control {
            border-radius: 50px;
            padding: 0.75rem 1.25rem;
            box-shadow: inset -6px -6px 10px #0063cc, inset 6px 6px 10px #008fff;
            border: none;
            margin-bottom: 1rem;
            background-color: #007BFF;
            color: white;
            transition: box-shadow 0.3s;
        }
        .form-control:focus {
            box-shadow: inset 6px 6px 10px #0063cc, inset -6px -6px 10px #008fff;
        }
        .form-control::placeholder {
            color: #e0e0e0;
        }
        .btn-primary {
            border-radius: 10px;
            padding: 0.75rem 1.25rem;
            background-color: #28a745;
            color: white;
            box-shadow: 6px 6px 10px #1e7e34, -6px -6px 10px #3de06d;
            border: none;
            margin-bottom: 1rem;
            transition: box-shadow 0.3s, transform 0.1s;
            width: 100%;
        }
        .btn-primary:active {
            box-shadow: inset 6px 6px 10px #1e7e34, inset -6px -6px 10px #3de06d;
            transform: translateY(2px);
        }
    </style>
</head>
<body>
    <div class="cadastro-container">
        <h1>Cadastro</h1>
        <form method="post" action="CadastroServlet">
            <div class="mb-3">
                <input type="text" class="form-control" name="usuario" placeholder="Usuário" required>
            </div>
            <div class="mb-3">
                <input type="password" class="form-control" name="senha" placeholder="Senha" required>
            </div>
            <div class="mb-3">
                <input type="password" class="form-control" name="confirmarSenha" placeholder="Confirmar Senha" required>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>
</body>
</html>
