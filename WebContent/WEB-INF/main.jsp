<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
     <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<title>Inscription</title>
		<link rel="stylesheet" href="style.css" type="text/css" />
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
			
			<label for="new_conversation">
					<input type="text" name="input_add" id="input_add" style="margin-left:59%;" placeholder="Nouvelle conversation" maxlength="128">
					<input type="submit" class="btn-minimal" id="btn_add" value="Ajouter">
			</label>
			
		</section>

	</body>
	
</html>