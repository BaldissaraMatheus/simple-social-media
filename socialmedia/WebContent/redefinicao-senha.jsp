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

<body>
    <main class="container">
        <a class="btn btn--small" href="login">Voltar</a>
        <h1>Redefina sua senha</h1>
        	<% if(request.getAttribute("err") != null) { %>
			<h2><% out.println(request.getAttribute("err")); %></h2>
			<% } %>
        <form action="realizaRedefinicaoSenha" method="POST">
            <p>Digite seu e-mail.</p>
            <input type="text" name="email" placeholder="E-mail">
            <input type="password" name="novaSenha" placeholder="Nova senha">
            <input type="submit" value="Confirmar" class="btn btn--small">
        </form>
    </main>
</body>

</html>