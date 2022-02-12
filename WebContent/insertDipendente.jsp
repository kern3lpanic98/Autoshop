<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="js/validDip.js"></script>
<script src="js/resetForm.js"></script>
<link rel="stylesheet" href="css/registrazione.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci dipendente</title>
</head>
<body>

<header> <img id="img_header" src="Immagini/newlogo.png"
		width="200"></header>
	<div id=container_reg>
		<form  method="post" action="./ControlDip" onsubmit="return validDip()">
			<div class="container">
				<label><b>Nome</b></label> <input type="text" id="name"
					placeholder="Enter Nome" name="nome" required>
					<label
					id="checkRegularName"></label> <label><b>
						<label><b>Cognome</b></label> <input type="text" id="surname"
						placeholder="Enter Cognome" name="cognome" required>
						<label id="checkRegularSurname"></label> <label><b>
								<label><b>Username</b></label> <input type="text" id="user"
								placeholder="Enter Username" name="username" required>
								<label id="checkRegularEmail"></label>
								
								<%if(request.getAttribute("esitouser")!=null){
									out.print("<label>"+request.getAttribute("esitouser")+"</label><br>");}
								 %>
								 <input type="hidden" name="action" value="insert">
								 <label><b>Password</b></label>
								<input type="password" id="pass" placeholder="Enter Password" name="psw"
								required> 
								<label id="checkRegularPass"></label>
								<label><b>Ripeti Password</b></label> <input
								type="password" id="pass2" placeholder="Repeti Password" name="rpsw"
								required>
							
				

								<div class="clearfix">
									<button type="button" class="cancelbtn">Annulla</button>
									<button type="submit" class="signupbtn">Completa</button>
								</div>
			</div>
		</form>
	</div>
	
</body>
</html>