<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="js/validRegister.js"></script>
<script src="js/resetForm.js"></script>


<link rel="stylesheet" href="css/registrazione.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrazione</title>
</head>
<body>
	<header> <img id="img_header" src="Immagini/newlogo.png"
		width="200"></header>
	<div id=container_reg>
		<form method="post" action="./ControlRegister" name="modulo"
			onsubmit="return validRegister()">
			<div class="container">
				<label><b>Nome</b></label> <input type="text" id="name"
					placeholder="Enter Nome" name="nome" required> <label
					id="checkRegularName"></label> <label><b>Cognome</b></label> <input
					type="text" id="surname" placeholder="Enter Cognome" name="cognome"
					required> <label id="checkRegularSurname"></label> <label><b>Username</b></label>
				<input type="text" id="user" placeholder="Enter Email"
					name="username" required> <label id="checkRegularEmail"></label>

				<%
					if (request.getAttribute("esitouser") != null) {
						out.print("<label style='color: red; fontSize: 13px;'>" + request.getAttribute("esitouser") + "</label><br>");
					}
				%>
				<label><b>Password</b></label> <input type="password" id="pass"
					placeholder="Enter Password" name="psw" required> <label
					id="checkRegularPass"></label><label><b>Repeti Password</b></label>
				<input id="pass2" type="password" placeholder="Repeti Password"
					name="rpsw" required>
			
				<hr>
				<label><b>Dati per la spedizione</b></label><br> <br> <label><b>Via
				</b></label> <input  id="via" type="text" class="via" maxlength="50" size="50"
					placeholder="Via o Piazza" name="via" required>
					 <label id="checkRegularVia"></label>
					 <label><b>

						<label><b>Civico </b></label> <input id="civico" type="text" class="civico"
						maxlength="3" size="3" placeholder="N°" name="civico" required>
						<label><b> <label><b>Cap </b></label> <input id="cap"
								type="text" class="cap" maxlength="5" size="5" placeholder="Cap"
								name="cap" required>
								<label id="checkRegularCC"></label>
								 <label><b><br> <br>

										<div class="clearfix">
											<button onclick="resetForm()" type="button"
												class="cancelbtn">Cancel</button>
											<button type="submit" class="signupbtn">Registrati</button>
										</div>
			</div>
		</form>
	</div>



</body>
</html>