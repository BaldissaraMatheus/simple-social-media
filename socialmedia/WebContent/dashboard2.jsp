<%
	
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title> Dashboard </title>
    <link rel="stylesheet" href="assets/stylesheets/normalize.css">
    <link rel="stylesheet" href="assets/stylesheets/shared.css">
    <link rel="stylesheet" href="assets/stylesheets/index.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <script src="assets/js/app.js" type="text/javascript"></script>
</head>

<body>
    <nav class="navbar">
        <a class="active" href="logout">Sair</a>
    </nav>
    <main class="container flex-container">
        <div class="user-box container">
            <a class="user-icon  user-icon--${ icon }"></a>
            <div class="user-info">
                <p class="user-name">${ name }</p>
                <p class="user-nick">@${ username }</p>
            </div>
            <button class="btn btn--small btn--sair" href="logout">Sair</button>
        </div>
        <div class="dashboard">
            <div class="create-post">
                <div class="post-content">
                    <div class="user-icon"></div>
                    <form action="criaPost" method="GET" class="create-post-form">
                        <textarea name="content"></textarea>
                        <input type="submit" value="Enviar" class="btn btn--small">
                    </form>
                </div>
            </div>
            <div class="post">
                <div class="post-content">
                    <div class="user-icon user-icon--aang"></div>
                    <div class="user-info">
                        <div class="user-name">zezinho</div>
                        <div class="user-nick">@zezinho</div>
                    </div>
                    <p>�gua tem mem�ria</p>
                </div>
                <div class="action-bar">
                    <button class="btn far fa-grin-hearts" onclick="toggleIconStyle(this)"></button>
                    <button class="btn far fa-comment-alt" id="reply-btn" onclick="toggleReplyContainer(this); toggleIconStyle(this)"></button>
                </div>
                <div class="replies">
                    <div class="create-post display-none" id="reply-container">
                        <div class="post-content">
                            <div class="user-icon user-icon--aang"></div>
                            <form class="create-post-form">
                                <textarea></textarea>
                                <input type="submit" value="Enviar" class="btn btn--small">
                            </form>
                        </div>
                    </div>
                    <div class="post">
                        <div class="post-content">
                            <div class="user-icon user-icon--aang"></div>
                            <div class="user-info">
                                <div class="user-name">zezinho</div>
                                <div class="user-nick">@zezinho</div>
                            </div>
                            <p>Simm!!!</p>
                        </div>
                    </div>
                    <div class="post">
	                    <div class="post-content">
	                        <div class="user-icon user-icon--aang"></div>
	                        <div class="user-info">
	                            <div class="user-name">zezinho</div>
	                            <div class="user-nick">@zezinho</div>
	                        </div>
	                        <p>Unidos pela #LigaNacionalDeHomeopatia!</p>
                    	</div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>

</html>