<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/registrazione.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci carta</title>
</head>
<body>

	<%
		String user = (String) request.getAttribute("user");
	%>
	<header> <img id="img_header" src="Immagini/newlogo.png"
		width="200"></header>
	<span style="align-text: center" id="form_card"> Inserire i dati
		della carta </span>
	<div id="conteiner_card">

		<form method="post" action="acquistoEffettuato.jsp">
			<div class="container">
				<label><b>Inserisci Paese</b></label><br> <br> <select
					name="paese">
					<option value="Italia">Italia</option>
					<option value="Belgio">Belgio</option>
					<option value="Francia">Francia</option>
					<option value="Germania">Germania</option>
					<option value="Spagna">Spagna</option>
				</select><br> <br> <br> <label><b>Codice della carta
						</b></label> <input type="text" placeholder="XXXX-XXXX-XXXX-XXXX"
					name="cifre"  maxlength="20" size="20" required> <label><b>
					
					
					 <input
						type="hidden" placeholder="" name="user"
						value="<%=user%>" required> <label><b>
								CVV</b></label>&nbsp &nbsp<input type="text" class="sic"
						 placeholder="XXX" name="sicurezza"  maxlength="3" size="3"required>
						 <br>
						 <label><b>
								Scadenza</b></label>&nbsp &nbsp<input type="text" class="mese"
						 placeholder="XX"  maxlength="2" size="2" name="mese" required>
						 <label><b>/</b>
						 <input type="text" class="anno"
						 placeholder="XX"  maxlength="2" size="2" name="anno" required>
						 
						 
						 
						 
						 <br>
						<label><b> <input type="radio" id="master"
								name="tipo" value="master"> <label
								for="contactChoice1"><img src="Immagini/mastercard.jpg" width="50"></label> <input
								type="radio" id="visa" name="tipo" value="visa"> <label
								for="contactChoice2"><img src="Immagini/visa.jpg" width="65"></label>

								<div class="clearfix">
									<button type="button" class="cancelbtn">Indietro</button>
									<button type="submit" class="signupbtn">Paga</button>
								</div>
			</div>
		</form>


	</div>

</body>
</html>