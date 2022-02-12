<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>menu Concessionaria</title>
</head>
<body>

	<!-- Barra di Navigazione -->
	<nav>
		<div id="menu">
			<!-- Lista generale -->
			<ul>
				<!-- 1° Elemento	-->
				<li class="selected"><a href="Concessionaria.jsp">HOME</a></li>

				<!-- 2° Elemento	-->
				<li><a href="./ControlloAutoNuove?action=carica">AUTO</a></li>
				<!-- 3° Elemento	-->
				<li><a href="./ControlRicambi?action=carica">RICAMBI</a></li>

				<!-- 4° Elemento	-->
				<li><a href="contatti.jsp">CONTATTI</a></li>


				<!-- 5° Elemento	-->
				<li><a href="./ControlCarrello?action=read">CARRELLO</a></li>
				
				<!-- 6° Elemento	-->
				<% if( request.getSession().getAttribute("userid")==null){  %>
				<li><a href="index.jsp">LOGIN</a></li>
				<%}  else{ 
					%>
				<li><a href="#">CIAO <%=request.getSession().getAttribute("userid") %></a>
				<ul>
				<li><a href="logout.jsp">LOGOUT</a></li>
					</ul></li>
			
					<%} %>
			</ul>
		</div>
	</nav>


</body>
</html>