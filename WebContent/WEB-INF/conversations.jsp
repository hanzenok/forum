<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
     <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<title>Forum</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css" />
		<link rel="icon" href="forum.png" type="image/png" sizes="16x16">
	</head>
	
	<body>
	
		<!-- login d'utilisateur -->
		<section class="form" id="user">
			<span style="margin-left:20px;font-size:1.6em;"> <c:out value="${sessionScope.user.login}" /> </span>
			<a href="<c:url value="/index"/>" style="margin-top:10px;" >deconnexion</a>
		</section>
		
		<section class="form" id="info">
			<span style="margin-left:30%;font-size:1em;">
				Info:
			 	<c:out value="${sessionScope.conversations.nbConversations}" /> conversations,
			 	et  <c:out value="${sessionScope.conversations.nbPosts}" /> posts en total
			 </span>
		</section>
		
		<section class="form" id="forum">
		
			<ul>
				<c:forEach items="${sessionScope.conversations.conversationsList}" var="conversation" varStatus="status">
					<li class="core" onclick="location.href='main/posts?conversation_index=${status.count - 1}'">
						
						<!-- l'auteur de la conversation -->
						<span style="margin-left:5px;font-family:'Times New Roman'; font-size:1.4em; font-weight: bold;display:inline-block;">
							<c:out value="${conversation.author.login}"></c:out>
						</span>
						
						<!-- date de creation de la conversation -->
						<span style="font-size:0.7em;font-stye:italic;display:inline-block;">
							(<c:out value="${conversation.creationDate}"></c:out>)
						</span>
						
						<!-- titre de la conversation -->
						<span style="font-size:1.6em;display:inline-block;position:absolute;left:30%;">
							<c:out value="${conversation.title}"></c:out>
						</span>
						
						<!-- nombre des posts dans la conversation -->
						<span style="display:inlin-block;position:absolute;right:5%;">
							<c:out value="${conversation.nbPosts}"></c:out>
						</span>
					</li>
				</c:forEach>
			</ul>
			
			<form method="post" action="CreateConversation">
					<input type="text" name="title" id="title" style="margin-left:59%;" placeholder="Nouvelle conversation" maxlength="128">
					<input type="submit" class="btn-minimal" id="btn_add" value="Ajouter">
			</form>
			
		</section>

	</body>
	
</html>