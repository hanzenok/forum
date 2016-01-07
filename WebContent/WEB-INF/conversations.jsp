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
		
			<table>
				<tr>
					<th>Auteur</th>
					<th>Titre</th>
					<th>Date de cr&eacute;ation</th>
					<th>Nombre des posts</th>
				</tr>

				<c:forEach items="${sessionScope.conversations.conversationsList}" var="conversation" varStatus="status">
					<tr class="core" onclick="location.href='main/posts?conversation_index=${status.count - 1}'">
						<td> <c:out value="${conversation.author.login}"></c:out> </td>
						<td> <c:out value="${conversation.title}"></c:out> </td>
						<td> <c:out value="${conversation.creationDate}"></c:out> </td>
						<td> <c:out value="${conversation.nbPosts}"></c:out> </td>
					</tr>
				</c:forEach>

			</table>
			
			<form method="post" action="CreateConversation">
					<input type="text" name="title" id="title" style="margin-left:59%;" placeholder="Nouvelle conversation" maxlength="128">
					<input type="submit" class="btn-minimal" id="btn_add" value="Ajouter">
			</form>
			
		</section>

	</body>
	
</html>