<%

%>


<html>

<head>
    <meta charset="utf-8">
    <title>Cadastre-se</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="assets/img/favicon.ico" />
    <link rel="stylesheet" href="assets/stylesheets/normalize.css">
    <link rel="stylesheet" href="assets/stylesheets/shared.css">
    <link rel="stylesheet" href="assets/stylesheets/cadastro.css">
</head>

<body>
    <main class="container main-container">
        <h1>Faça seu cadastro!</h1>
        <form action="realizaCadastro" method="POST">
            <input type="email" name="email" placeholder="Email">
            <input type="text" name="name" placeholder="Nome completo">
            <input type="text" name="username" placeholder="Nome de usuário">
            <input type="password" name="password" placeholder="Senha">

            <h2>Escolha seu avatar:</h2>
            <div class="container avatares">  
                <input type="radio" name="icon" value="katara" id="katara" checked>
                <label for="katara" class="katara"></label>

                <input type="radio" name="icon" value="aang" id="aang">
                <label for="aang" class="aang"></label>

                <input type="radio" name="icon" value="toph" id="toph">
                <label for="toph" class="toph"></label>

                <input type="radio" name="icon" value="zuko" id="zuko">
                <label for="zuko" class="zuko"></label>
            </div>
            <input type="submit" value="confirmar" class="btn btn--small">
        </form>
    </main>
</body>

</html>