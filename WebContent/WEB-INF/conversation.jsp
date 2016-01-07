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
	
		<section class="form" id="user">
			<span style="margin-left:20px;font-size:1.6em;"> <c:out value="${sessionScope.user.login}" /> </span>
			<a href="<c:url value="/index"/>" style="margin-top:10px;" >deconnexion</a>
		</section>
		
		<section class="form" id="info">
			<span style="font-size:2em; font-weight:bold;">
				<c:out value="${sessionScope.conversations.currentConversation.title}" />
			</span>
			<span>
				( <c:out value="${sessionScope.conversations.currentConversation.nbPosts}"/> posts )
			</span>
		</section>
		
		<section class="form" id="forum">
		
			<table>
				<tr>
					<th></th>
					<th>Auteur</th>
					<th></th>
					<th>Date</th>
				</tr>

				<c:forEach items="${sessionScope.conversations.currentConversation.posts}" var="post">
					<tr>
						<td> <c:out value="${post.number}"></c:out> </td>
						<td> <c:out value="${post.author.login}"></c:out> </td>
						<td> <c:out value="${post.text}"></c:out> </td>
						<td> <c:out value="${post.date}"></c:out> </td>
					</tr>
				</c:forEach>

			</table>
			
		</section>
		
			<form method="post" action="AddPost">
				<div style="margin-left: 30%;display:inline-block;posiiton:relative;">
					<textarea name="addpost" id="addpost" placeholder="Votre commentaire" maxlength="128" rows="3" cols="50"></textarea>
					<input type="submit" class="btn-minimal" id="btn_add_post" value="Ajouter">
				</div>
			</form>

	</body>
	
</html>