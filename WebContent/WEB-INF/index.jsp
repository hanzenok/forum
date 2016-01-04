<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<title>Autentification</title>
		<link rel="stylesheet" href="style.css" type="text/css">

	</head>

	<body>
		
		<div data-role="main">
		
			<section class="form">
			
				<h2>Autentification</h2>
				
				<form method="post" class="minimal">
				
					<label for="login">
						<input type="text" name="login" id="login" placeholder="Login" pattern=".{4,32}" value="<c:out value="${sessionScope.user.login}"/>" maxlength="32" required />
					</label>
					
					<label for="password">
						<input type="password" name="password" id="password" placeholder="Mot de passe" pattern=".{6,32}" maxlength="32" required />
					</label>
					
					<button type="submit" id="connexion" class="btn-minimal" action="test.php">Connexion</button>
					
					<a href="<c:url value="/register"/>"> Creer un compte </a>
					
				</form>
				
				<%-- Affichage de la chaîne "message" transmise par la servlet --%>
	        	<p>${message}</p>
				
			</section>
		
		</div>
	
	</body>	
	
</html>
