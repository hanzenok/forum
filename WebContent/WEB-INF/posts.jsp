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
		
		<!-- info sur une conversation -->
		<section class="form" id="info">
			<span style="font-size:2em; font-weight:bold;">
				<c:out value="${sessionScope.conversations.currentConversation.title}" />
			</span>
			<span>
				( <c:out value="${sessionScope.conversations.currentConversation.nbPosts}"/> messages )
			</span>
		</section>
		
		<!-- ensemble des messages -->
		<c:forEach items="${sessionScope.conversations.currentConversation.posts}" var="post">
			<section class="form" id="post">
				
				<!-- post id -->
				<span style="font-weight:bold;">
					#<c:out value="${post.number}"></c:out>
				</span>
				
				<!-- l'auteur de post -->
				<span style="margin-left:5px;font-family:'Times New Roman'; font-size:1.4em; font-weight: bold; color:#4195fc;">
					<c:out value="${post.author.login}"></c:out>
				</span>
				
				<!-- text de post -->
				<span style="font-size:1.1em;word-wrap:break-word;">
					<c:out value="${post.text}"></c:out>
				</span>
				
				<!-- date de creation de post -->
				<span style="font-size:0.7em;font-stye:italic; position:absolute; right:12%;">
					(<c:out value="${post.date}"></c:out>)
				</span>
			</section>
		</c:forEach>
		
		<!-- section pour remplir l'espace -->
		<section class="form" id="fill_space"></section>
		
		<!-- une forme glissante d'ajout d'un nouveau message -->
		<div style="display:inline-block;position:fixed; bottom:4%; left:2%;width:98%;">
			<form method="post" action="AddPost">
				<textarea name="addpost" id="addpost" placeholder="Votre commentaire" maxlength="128" rows="3"></textarea>
				<input type="submit" class="btn-minimal" id="btn_add_post" value="Ajouter">
			</form>
		</div>
		
	</body>
	
</html>