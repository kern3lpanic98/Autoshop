<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Automobile auto = (Automobile) request.getAttribute("auto_nuove");
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*, model.Automobile"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  <link href="ProductStyle.css" rel="stylesheet" type="text/css"> -->
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<!--  <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	-->
<link rel="stylesheet" href="css/schedaTecnica.css" type="text/css">
<title>DETTAGLI AUTO</title>
</head>

<body>
	<%@ include file="header.html"%>
	<jsp:include page="menuConcessionaria.jsp" />
	<!--	<h2>Auto</h2>
	<a href="./ControlloAutoNuove?action=carica">List</a>  -->


	<div id="container_scheda">

		<img id="imgTecnica" src="<%=auto.getPath()%>">

		<table id="info" cellspacing=”10″>

			<td>Marca:</td>
			<td><%=auto.getMarca()%></td>
			</tr>

			<tr>
				<td>Modello:</td>
				<td><%=auto.getModello()%></td>
			</tr>

			<tr>
				<td>Prezzo:</td>
				<td><%=auto.getPrezzo()%></td>
			</tr>

			<tr>
		<td><a href="./ControlPreventivo?action=carica&id=<%=auto.getId()%>">
						<button class="buttonload">
							<i class="fa fa-circle-o-notch fa-spin"></i>Richiedi preventivo
						</button>
				</a></td>
			</tr>
		</table>
	</div>











</body>
</html>
