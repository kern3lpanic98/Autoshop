<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,model.RicambiAuto, java.text.NumberFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<link rel="stylesheet" href="css/feedbackCarrello.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback aggiunta</title>
</head>
<body>

	<%
		RicambiAuto ricambio;
		ricambio = (RicambiAuto) request.getAttribute("ricambio");
		int qnt = (int) request.getAttribute("qnt");
		double prezzoQnt = ricambio.getPrezzo() * qnt;
		String link = "./ControlCarrello?action=read";
	%>
	<%@ include file="header.html"%>

	<div id="feedback">

		<table id="table_feedback" cellpadding="10">
			<tr>
				<td><img id="articolo" src="<%=ricambio.getPath()%>" width="80"></td>
				<td><span style="color: #60C124">Aggiunto al Carrello</span></td>
				<td><span style="font-weight: bold">Subtotale carrello</span><span>(<%
					if (qnt > 1) {
				%><%=qnt%><%=" Articoli:)"%>
				<% } else { %>
				<%=1%><%=" Articolo:)"%>
						<%
							}
						%>
						
							<%
		NumberFormat f = NumberFormat.getNumberInstance(Locale.US);
		f.setMinimumFractionDigits(2);
		String s = f.format(prezzoQnt);
	%>
				</span><span style="color: #D71717; font-weight: bold">EUR <%=s%></span></td>
				<td>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</td>
				<td><a href=<%=link%>><button class="btn default">
							Carrello</button></a></td>
				
			</tr>
		</table>

	</div>

</body>
</html>