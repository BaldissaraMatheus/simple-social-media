<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>

<head>
    <title>Redefinir senha</title>
    <link rel="stylesheet" href="assets/stylesheets/normalize.css">
    <link rel="stylesheet" href="assets/stylesheets/shared.css">
    <link rel="stylesheet" href="assets/stylesheets/redefinicao-senha.css">
    <link rel="shortcut icon" href="img/favicon.ico" />
</head>

<body class="image-background">
    <main class="container">
        <h1>Redefina sua senha</h1>
        <form action="realizaRedefinicaoSenha" method="POST">
            <p>Digite seu e-mail.</p>
            <input type="text" name="email" placeholder="E-mail">
            <input type="password" name="novasenha" placeholder="Nova senha">
            <input type="submit" value="Confirmar" class="btn btn--small">
        </form>
    </main>
</body>

</html>