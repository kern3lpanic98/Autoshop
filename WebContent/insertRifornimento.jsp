<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/registrazione.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci rifornimento</title>
</head>
<body>


	<div id=container_reg>
		<form method="get" action="ControlRifornimento"
			enctype="multipart/form-data">
			<div class="container">
				<label><b>Marca</b></label> <input type="text"
					placeholder="Inserisci marca ricambio" name="marca" required>
				<label><b> <label><b>Tipo</b></label> <input type="text"
						placeholder="Inserisci tipo ricambio" name="tipo" required>
						<label><b> <label><b>Data consegna </b></label><br>
								<input type="text" class="civico" maxlength="2" size="2"
								placeholder="" name="gg" required>/ <input type="text"
								class="civico" maxlength="2" size="2" placeholder="" name="mm"
								required>/ <input type="text" class="civico"
								maxlength="4" size="2" placeholder="" name="aa" required>
								<input type="hidden" name="action" value="insert">
								<br>
							<br> <label><b>Numero pezzi </b></label> <input type="text"
								class="civico" maxlength="3" size="3" placeholder=""
								name="n_pezzi" required> <label><b>




										<div class="clearfix">
											<button type="button" class="cancelbtn">Annulla</button>
											<button type="submit" class="signupbtn">Richiedi</button>
										</div>
			</div>
		</form>
	</div>



</body>
</html>