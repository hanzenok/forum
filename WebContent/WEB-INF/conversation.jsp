<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
     <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<title>Forum</title>
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
					<th></th>
					<th>Auteur</th>
					<th></th>
					<th>Date</th>
				</tr>

				<c:forEach items="${conversation.posts}" var="post">
					<tr class="core">
						<td> <c:out value="${post.number}"></c:out> </td>
						<td> <c:out value="${post.author.login}"></c:out> </td>
						<td> <c:out value="${post.text}"></c:out> </td>
						<td> <c:out value="${post.date}"></c:out> </td>
					</tr>
				</c:forEach>

			</table>
			
		</section>

	</body>
	
</html>