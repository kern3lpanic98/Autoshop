<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.RicambiAuto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="js/validRif.js"></script>

<link rel="stylesheet" href="css/Nuove.css" type="text/css">
<link rel="stylesheet" href="css/ricerca.css" type="text/css">
<link rel="stylesheet" href="css/guida.css" type="text/css">
<link href="css/styles1.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Richiedi rifornimento</title>
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
			
				<div class="simpleCart_shelfItem">
					<input type="button" class="item_add" value="Quantità" /> <input
						type="button" class="item_add" value="<%=ricambio.getQuantità()%>" />
					<h3 class="item_name"><%=ricambio.getMarca()%>
						-
						<%=ricambio.getTipo()%>
					</h3>
					<img src="<%=ricambio.getPath()%>" width="150px" height="100px" />
					<strong class="item_price">€<%=ricambio.getPrezzo()%></strong>  <input
						type="hidden" name="action" value="insert" /> <input
						type="hidden" name="id" value="<%=ricambio.getId()%>" />
						<br> 
						<input type="button" class="item_add" value="Data consegna" />
						<br>
						<input placeholder="gg"
						type="text" id="gg<%=i %>" name="gg" maxlength="2" size="2" />/
						<input placeholder="mm"
						type="text" id="mm<%=i %>" name="mm" maxlength="2" size="2" />/
						<input placeholder="aa"
						type="text" id="aa<%=i %>" name="aa" maxlength="4" size=2" />
						<br>
						<input type="button" class="item_add" value="input quantità" />
						<input
						type="text" id="r<%=i %>" name="n_pezzi" maxlength="3" size="3" /> <input type="button"
						onclick="validRif(<%=i %>)" class="item_add" value="Richiedi rifornimento" />
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