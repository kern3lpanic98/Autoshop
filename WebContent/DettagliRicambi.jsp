
<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*, model.RicambiAuto"%>
<%
	RicambiAuto ricambi = (RicambiAuto) request.getAttribute("ricambio");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<link rel="stylesheet" href="css/schedaTecnica.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli Ricambi</title>
</head>
<body>
	<%@ include file="header.html"%>
	<jsp:include page="menuConcessionaria.jsp" /> 

	<div id="container_scheda">

		<img id="imgTecnica" src="<%=ricambi.getPath()%>">

		<table id="info" cellspacing=”10″>

			<td>Marca:</td>
			<td><%=ricambi.getMarca()%></td>
			</tr>

			<tr>
				<td>Modello:</td>
				<td><%=ricambi.getTipo()%></td>
			</tr>

			<tr>
				<td>Prezzo:</td>
				<td>€<%=ricambi.getPrezzo()%></td>
			</tr>

		</table>
		<div>

			<form id="carrello" method="get" action="./ControlCarrello">
				<input type="hidden" name="id" value="<%=ricambi.getId()%>">
				<input type="hidden" name="prezzo" value="<%=ricambi.getPrezzo()%>">
				Quantità<br> <br> <select name="quantità"
					class="selectpicker">
					<%
						for (int i = 1; i <= ricambi.getQuantità(); i++) {
					%><option><%=i%></option>
					<%
						}
					%>

				</select><br> <br> <input type="submit" class="btn warning" 
					value="Aggiungi al carrello"> <i
					class="fa fa-circle-o-notch fa-spin"></i><br>


			</form>
		</div>


	</div>


</body>
</html>