<%@ page import="br.com.uff.socialmedia.model.Post" %>
<%@ page import="br.com.uff.socialmedia.model.Reply" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	List<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
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
            
            <%
				for (Post post : posts) {
			%>
            
            <div class="post">
                <div class="post-content">
                    <div class="user-icon user-icon--<% out.println(post.getOwner().getIcon().getNome()); %>"></div>
                    <div class="user-info">
                        <div class="user-name"><% out.println(post.getOwner().getName()); %></div>
                        <div class="user-nick">@<% out.println(post.getOwner().getUsername()); %></div>
                    </div>
                    <p><% out.println(post.getContent()); %></p>
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
                     	<%
							for (Reply reply : post.getReplies()) {
						%>
                    <div class="post">
                        <div class="post-content">
                            <div class="user-icon user-icon--aang"></div>
                            <div class="user-info">
                                <div class="user-name"><% out.println(reply.getOwner().getName()); %></div>
                                <div class="user-nick">@<% out.println(reply.getOwner().getUsername()); %></div>
                            </div>
                            <p><% out.println(reply.getContent()); %></p>
                        </div>
                    </div>
			            <%
                    		}
						%>
                </div>
            </div>
	        <%
            	}
			%>
        </div>
    </main>
</body>

</html>