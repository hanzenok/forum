<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
     <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<title>Inscription</title>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<link rel="icon" href="${pageContext.request.contextPath}/forum.png" type="image/png" sizes="16x16">
	</head>
	
	<body>

		<!-- form d'ajout d'un nouveau utilisateur -->
		<div data-role="main">
		
			<section class="form" id="form">
			
				<h2>Cr&eacute;er un compte</h2>
				
				<form method="post" action="AddUser" class="minimal">
					
					<label for="login">
						<!-- Majuscules ou minisucles ou underscore ou chiffres -->
						<input type="text" name="login" id="login" placeholder="Login" pattern=".{4,32}" maxlength="32" value="<c:out value="${param.login}"/>" required>
					</label>
					
					<label for="password">
						<!-- Majuscules et minisucles et chiffres -->
						<input type="password" name="password" id="mdp1" placeholder="Mot de passe" pattern=".{6,32}" maxlength="32" required>
					</label>
	
					<label for="password2">
						<input type="password" name="password2" id="mdp2" placeholder="Confirm&eacute;ez le mot de passe" pattern=".{6,32}" maxlength="32" required>
					</label>
	
					<label for="name">
						<input type="text" name="firstname" id="firstname" placeholder="Nom" value="<c:out value="${param.firstname}"/>" maxlength="32">
						<input type="text" name="secondname" id="secondname" placeholder="Prenom" value="<c:out value="${param.secondname}"/>" maxlength="32">
					</label>
	
					<input type="submit" class="btn-minimal" value="M'inscrire">
	
			   </form>
	
				<%-- Affichage de la chaîne "message" transmise par la servlet --%>
	        	<p>${message}</p>
	
		   </section>
	   </div>
	
	</body>
	
</html>
