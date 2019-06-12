
<%
	
%>

<html>

<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="assets/stylesheets/normalize.css">
	<link rel="stylesheet" href="assets/stylesheets/shared.css">
	<link rel="stylesheet" href="assets/stylesheets/login.css">
	<link rel="shortcut icon" href="assets/img/favicon.ico" />
</head>

<body>
	<main class="container flex-container">
	<div class="center">
		<h1 class="h1-container left">Mais de um bilhão de usuários já cadastrados</h1>
	</div>
	<div class="center">
		<div class="container form-container">
			<img src="assets/img/logo.png" class="logo"> ${ err != null ? "<p>" += err += "</p>" : "" }
			<form action="realizaLogin" method="POST">
				<input type="email" name="email" placeholder="Email"> 
				<input type="password" name="password" placeholder="Senha"> 
				<a class='form-link' href="redefine-senha">Redefinir minha senha</a>
				<a class='form-link' href="cadastra">Criar uma conta</a> 
				<input type="submit" value="Entrar" class="btn btn--main">
			</form>
		</div>
	</div>
	<div class="center">
		<h1 class="h1-container right">Crie uma conta e acesse já!</h1>
	</div>
	</main>
</body>

</html>