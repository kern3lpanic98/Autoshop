<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.RicambiAuto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="js/validQnt.js"></script>
<link rel="stylesheet" href="css/Nuove.css" type="text/css">
<link rel="stylesheet" href="css/ricerca.css" type="text/css">
<link rel="stylesheet" href="css/guida.css" type="text/css">
<link href="css/styles1.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Visualizzazione ricambi</title>
</head>
<body>

	<%
		ArrayList<RicambiAuto> ricambi = (ArrayList<RicambiAuto>) request.getAttribute("ricambi");
		RicambiAuto ricambio;
	%>
	


	<!-- Header -->
	<%@ include file="menuMaga.html"%>
	<div id="wrapper">
		<div id="container">
			<h1>Concessionaria - Pezzi di ricambio</h1>

			<%
				for (int i = 0; i < ricambi.size(); i++) {
					ricambio = ricambi.get(i);
			%>
			<form method="get" action="ControlRicambi"  id="modulo<%=i %>" onsubmit="validQnt(index)">
				<div class="simpleCart_shelfItem">
					<input type="button" class="item_add" value="Quantità" /> <input
						type="button" class="item_add" value="<%=ricambio.getQuantità()%>" />
					<h3 class="item_name"><%=ricambio.getMarca()%>
						-
						<%=ricambio.getTipo()%>
					</h3>
					<img src="<%=ricambio.getPath()%>" width="150px" height="100px" />
					<strong class="item_price">€<%=ricambio.getPrezzo()%></strong> <a
						href="./ControlRicambi?action=delete&id=<%=ricambio.getId()%>"><input
						type="button" class="item_add" value="Rimuovi" /></a> <input
						type="hidden" name="action" value="updateRicambi" /> <input
						type="hidden" name="id" value="<%=ricambio.getId()%>" /> <input
						id="r<%=i %>"
						type="text" name="qntRicambi" maxlength="3" size="3" /> <input
						onclick="validQnt(<%=i %>)" type="button" 
						class="item_add" value="Modifica quantità" />
						<br><label style="color:red; font-size:15px;" id="<%=i%>"></label>

				</div>
			</form>
			
			<%
				}
			%>
		</div>

	</div>

</body>
</html>