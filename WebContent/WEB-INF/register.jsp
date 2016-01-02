<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<title>Inscription</title>
		<link rel="stylesheet" href="style.css" type="text/css" />
	</head>
	
	<body>
		
		<section class="form" id="form">
		
			<h2>Cr&eacute;er un compte</h2>
			
			<form method="post" class="minimal">
				
				<label for="login">
					<!-- Majuscules ou minisucles ou underscore ou chiffres -->
					<input type="text" name="login" id="login" placeholder="Login" pattern="^[A-Za-z0-9_]{4,32}$" maxlength="32" required>
				</label>
				
				<label for="password">
					<!-- Majuscules et minisucles et chiffres -->
					<input type="password" name="password" id="mdp1" placeholder="Mot de passe" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,32}" maxlength="32" required>
				</label>

				<label for="password2">
					<input type="password" name="password2" id="mdp2" placeholder="Confirm&eacute;e le mot de passe" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,32}" maxlength="32" required>
				</label>

				<label for="captcha">
					<span id="a">  </span> + <span id="b">  </span> = <span id="capAlert" style="display:none;">Erreur</span> <input type="text" name="captcha" id="captcha" style="margin:0; padding:0; font-size:100%; line-height:1;width:20%;float:right;" required>
				</label>

				<label for="name">
					<input type="text" name="firstname" id="firstname" placeholder="Nom" maxlength="32">
					<input type="text" name="secondname" id="secondname" placeholder="Prenom" maxlength="32">
				</label>

				<input type="submit" class="btn-minimal" value="M'inscrire">

		   </form>

           <div id="alert" style="display:none;"><p>Verifier votre mot de passe</p> </div>

	   </section>

	<script src="register.js"></script>
	
	</body>
	
</html>
