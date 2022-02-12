<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.Dipendente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizza dipendenti</title>
</head>
<body>

<% ArrayList<Dipendente> dips = (ArrayList<Dipendente>) request.getAttribute("dips");
   Dipendente dip;
%>


<%@ include file="menuAmministratore.html"%>

<div style="position:relative; top:80px"  id="container_dip">
<table border="1" >
<tr><th>Nome</th><th>Cognome</th><th>Username</th><th>Password</th><th>Azione</th></tr>
<% for(int i=0;i<dips.size();i++){ 
dip= dips.get(i); %>
 

<tr><td> <%=dip.getNome() %> </td><td> <%=dip.getCognome() %> </td>
<td> <%=dip.getUsername() %> </td><td> <%=dip.getPassword() %> </td>
<td><a href="./ControlDip?action=delete&dip=<%=dip.getUsername()%>">Rimuovi</a> </td></tr>



<% } %>
</table>

</div>

</body>
</html>