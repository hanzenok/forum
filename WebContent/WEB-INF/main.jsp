<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
     <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<title>Inscription</title>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	</head>
	
	<body>
	
		<section class="form" id="user">
			<span style="margin-left:20px;font-size:1.6em;"> <c:out value="${sessionScope.user.login}" /> </span>
			<a href="<c:url value="/index"/>" style="margin-top:10px;" >deconnexion</a>
		</section>
		
		<section class="form" id="forum">
		
			<table>
				<tr>
					<th>Author</th>
					<th>Titre</th>
					<th>Date de cr&eacute;ation</th>
					<th>Dernier modification</th>
				</tr>

				<c:forEach items="${conversations}" var="conversation">
					<tr class="core">
						<td> <c:out value="${conversation.author.login}"></c:out> </td>
						<td> <c:out value="${conversation.title}"></c:out> </td>
						<td> <c:out value="${conversation.creationDate}"></c:out> </td>
						<td> <c:out value="${conversation.modificationDate}"></c:out> </td>
					</tr>
				</c:forEach>

			</table>
			
			<form method="post" action="CreateConversation">
					<input type="text" name="title" id="title" style="margin-left:59%;" placeholder="Nouvelle conversation" maxlength="128">
					<input type="submit" class="btn-minimal" id="btn_add" value="Ajouter">
			</form>
			
		</section>
		
		<script>
			$(document).ready(function() {
	
			    $('tr').click(function() {
			    	
			        alert("test");
		            
			        
					$.post('main', { name: "yo" });
			    });
	
			});
		</script>

	</body>
	
</html>