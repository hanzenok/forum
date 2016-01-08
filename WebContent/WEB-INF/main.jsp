<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
     <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<title>Forum</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css" />
		<link rel="icon" href="${pageContext.request.contextPath}/forum.png" type="image/png" sizes="16x16">
	</head>
	
	<body>
	
		<!-- login d'utilisateur -->
		<section class="form" id="user">
			<span style="margin-left:20px;font-size:1.6em;"> <c:out value="${sessionScope.user.login}" /> </span>
			<img alt="picture" src="${pageContext.request.contextPath}/forum.png" width="16px" height="16px">
			<a href="<c:url value="/disconnect"/>" style="margin-top:10px;" >deconnexion</a>
		</section>
		
		<!-- info sur le forum -->
		<section class="form" id="info">
			<span style="font-size:1.8em;">
				Bienvenu sur le forum!
			 </span>
			 <span>
				( <c:out value="${sessionScope.conversations.nbPosts}"/> messages )
			</span>
		</section>
		
		<!-- ensemble des conversations -->
		<section class="form" id="forum">
		
			<ul>
				<c:forEach items="${sessionScope.conversations.conversationsList}" var="conversation" varStatus="status">
					<li class="core" onclick="location.href='main/posts?conversation_index=${status.count - 1}'">
						
						<!-- l'auteur de la conversation -->
						<span style="margin-left:5px;font-family:'Times New Roman'; font-size:1.4em; font-weight: bold;">
							<c:out value="${conversation.author.login}"></c:out>
						</span>
						
						<!-- date de creation de la conversation -->
						<span style="font-size:0.7em;font-stye:italic;">
							(<c:out value="${conversation.creationDate}"></c:out>)
						</span>
						
						<!-- titre de la conversation -->
						<span style="font-size:1.6em;position:absolute;left:30%;">
							<c:out value="${conversation.title}"></c:out>
						</span>
						
						<!-- nombre des posts dans la conversation -->
						<span style="position:absolute;right:5%;font-weight:bold;">
							#<c:out value="${conversation.nbPosts}"></c:out>
						</span>
					</li>
				</c:forEach>
			</ul>
			
			<!-- form pour ajout une nouvelle conversation -->
			<form method="post" action="AddConversation" accept-charset="ISO-8859-1">
					<input type="text" name="title" id="title" style="margin-left:59%;" placeholder="Nouvelle conversation" maxlength="32">
					<input type="submit" class="btn-minimal" id="btn_add_conv" value="Ajouter">
			</form>
			
		</section>

	</body>
	
</html>