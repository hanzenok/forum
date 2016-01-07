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
				Conversation cr&eacute;e par <c:out value="${sessionScope.conversations.currentConversation.author.login}" />
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
			
			<form method="post" action="AddPost">
					<input type="text" name="addpost" id="addpost" style="margin-left:30%;" placeholder="Votre commentaire" maxlength="128">
					<input type="submit" class="btn-minimal" id="btn_add" value="Ajouter">
			</form>
			
		</section>

	</body>
	
</html>