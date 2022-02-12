<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/controlUser.js"></script>
<script src="js/resetForm.js"></script>



<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<link rel="stylesheet" href="css/ricerca.css" type="text/css">
<link rel="stylesheet" href="css/login.css" type="text/css">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<!-- Script per la ricerca -->

</head>
<body  >

	<header>
	<img id="img_header" src="Immagini/newlogo.png" width="200"></header>

<% if(session.getAttribute("login")!=null){
	String esito = (String) session.getAttribute("login");
	if (esito.equalsIgnoreCase("false")){
		out.println("<div style='position: relative; left: 500px; border: 2px solid red;  border-radius: 25px; width:240px; padding:20px;'>"+
				"<h4 >Ops! Si è verificato un errore <br> Email o Password non corretti </h4>"+
				"</div>");
		out.println("<script> alert('Account non presente '); </script>");
		session.removeAttribute("login");
		
	}
	
} %> 

	<div id="container_login">
		<form method="post" action="login.jsp" name="modulo" onsubmit="return controlUser()"  >
			<div>
				<h2>Accedi</h2>
			</div>
			<div class="container">
				<label><b>Username</b></label> <input type="text" id="user"
					placeholder="Enter Email" name="uname" required> 
					<label  id="checkRegularEmail"
					 ></label>
					
					<label><b>Password</b></label>
				<input type="password" placeholder="Enter Password" name="pass" id="p"
					required>
					<label  id="checkRegularP"
					 ></label>
					 <!--  <input type="hidden" name="preventivo"
					value="<%//=request.getAttribute("url")%>"-->

				<button type="submit">Login</button>
				<input type="checkbox" checked="checked"> Remember me
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button onclick="resetForm()" type="button" class="cancelbtn">Cancel</button>
				<span class="psw"> <a href="registrazione.jsp">Registrati</a></span>
			</div>
		</form>
	</div>
	
 


</body>
</html>