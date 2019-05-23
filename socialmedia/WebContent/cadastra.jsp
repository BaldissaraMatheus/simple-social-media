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
    Nome do Usuário: ${param.nome}
        <h1>Faça seu cadastro!</h1>
        <form action="" method="POST">
            <input type="email" name="Email" placeholder="Email">
            <input type="text" name="Nome completo" placeholder="Nome completo">
            <input type="text" name="Nome de usuário" placeholder="Nome de usuário">
            <input type="password" name="Senha" placeholder="Senha">

            <h2>Escolha seu avatar:</h2>
            <div class="container avatares">  
                <input type="radio" name="radio" id="katara" checked>
                <label for="katara" class="katara"></label>

                <input type="radio" name="radio" id="aang">
                <label for="aang" class="aang"></label>

                <input type="radio" name="radio" id="toph" checked>
                <label for="toph" class="toph"></label>

                <input type="radio" name="radio" id="zuko">
                <label for="zuko" class="zuko"></label>
            </div>
            <input type="submit" value="Confirmar" class="btn btn--small">
        </form>
    </main>
</body>

</html>