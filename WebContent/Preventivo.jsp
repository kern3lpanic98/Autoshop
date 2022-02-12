<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Preventivo </title>
</head>
<body>
<%@ include file="header.html"%>
<jsp:include page="menuConcessionaria.jsp" />
<%



    boolean esito = false;
   esito= (boolean) request.getAttribute("esito");
 if(esito) out.print("<div style='margin-top:70px; position:relative; left: 300px;  border: 2px solid red;  border-radius: 25px; width: 40%; padding: 10px;'>richiesta avvenuta con successo! Invieremo il preventivo via email </div>");
 else out.print("<div style='margin-top:70px; position:relative; left: 300px;  border: 2px solid red;  border-radius: 25px; width: 40%; padding: 10px;'>Richiesta di preventivo già inviata per questa automobile. Torna alla home</div>");
%>


</body>
</html>