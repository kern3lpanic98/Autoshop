<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,model.RicambiAuto, model.Carrello, java.text.NumberFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrello</title>
</head>
<body>
	<%
		ArrayList<RicambiAuto> ricambi = (ArrayList<RicambiAuto>) request.getAttribute("tutti_ricambi");
		ArrayList<Carrello> carrello = (ArrayList<Carrello>) request.getAttribute("contenuto_carrello");
		ArrayList<Integer> id_ricambi = new ArrayList<Integer>(50); 
		RicambiAuto ricambio;
		Carrello car;
		double totale_car = 0;
		
		int number=0;
	%>
	<%@ include file="header.html"%>
	<jsp:include page="menuConcessionaria.jsp" />
<br>
<div><span style="font-weight: bold"> Carrello</span></div>
	<div id="feedback"
		style="width: 70%; background-color: #EFF7F9; float: left; border-top: 1px solid black; border-right: 1px solid black; border-left: 1px solid black;">
 <form  method="get" action="ControlAcquisto">
		<table  bgcolor="#ccccb3" border="0" cellspacing="0" cellpadding="2" style="border: 1px solid #ccccb3">
			<tr>
			    <td width="230px" ></td>
				<td width="280px" style="font-weight: bold;">Tipo</td>
				<td width="390px" style="font-weight: bold;">Marca</td>
				<td width="280px" style="font-weight: bold;">Prezzo</td>
				<td width="150px" style="font-weight: bold;">Quantità</td>
			</tr>
		</table>
<% NumberFormat f = NumberFormat.getNumberInstance(Locale.US);
f.setMinimumFractionDigits(2); %>

		<%
			for (int i = 0; i < carrello.size(); i++) {
				for (int j = 0; j < ricambi.size(); j++) {

					if (carrello.get(i).getId_ricambio() == ricambi.get(j).getId()) {
		%>
		<%       number++;
			ricambio = ricambi.get(j);
			id_ricambi.add(ricambio.getId());
						car = carrello.get(i);
						
						
		%>

		
		<table id="table_feedback" cellpadding="10">
			<tr>
				<td><img id="articolo" src="<%=ricambio.getPath()%>"
					width="110"></td>

				<td width="190px align="center" ><span style="color: #60C124"><%=ricambio.getTipo()%></span></td>
				<td width="170px"><span style="font-weight: bold"><%=ricambio.getMarca()%></span>
				</td>
				<td><a href="./ControlCarrello?action=remove&id=<%=ricambio.getId() %>"><span> Rimuovi </span></a></td>
				<%
				  
					double totale = car.getQuantità() * ricambio.getPrezzo();
								totale_car = totale_car + totale;
								String tot_qnt = f.format(totale);
							
				%>
				<td width="200px"><span
					style="color: #D71717; font-weight: bold">EUR <%=tot_qnt%></span></td>

				<td>
				
				
			
				<!--  creo le select -->
				
				<select name="<%=number%>">
				
				
				
				<% for(int k=1; k<=ricambio.getQuantità();k++){%>
		          
				<%if(k==car.getQuantità()){%>
				
				<option value="<% out.print(k);%>" selected><% out.print(k); %></option>
				<%}else{ %>
				<option value="<% out.print(k);%>"><% out.print(k); %></option>
				<%} %>
				<%} %>
				</select>
				</td>
				
			</tr>
			
		</table>


		<%
			}
				}
			}
		%>
		<!--  inserisco i dati per  il forward -->
		
			<input type="hidden" name="action" value="acquisto">	
				<input type="hidden" name="numberSelect" value="<%=number%>">
	   <% request.getSession().setAttribute("id_ricambi", id_ricambi); %>				
		<input type="submit" value="Procedi all'acquisto" style="float: right; position:relative;" class="btn warning"">
		 
		
		</form>
		<a href="./ControlCarrello?action=svuota"><button   style="float: right; position:relative; top:1px; right:10px;" class="btn default"> Svuota carrello </button></a> 

	</div>
	<%
		
		String tot_car = f.format(totale_car);
	%>
	<span
		style="font-weight: bold; position: relative; left: 60px; top: 170px;">Totale
		del carrello</span>
	<span
		style="color: #D71717; font-weight: bold; position: relative; left: 70px; top: 170px;">EUR
		<%=tot_car%>
	</span>


	<div
		style=" border: 1px solid; padding-top: 10px; padding-left: 10px; padding-right: 10px; padding-bottom: 20px; float: right; width: 25%;">

		<table id="table_ordine"  bgcolor="#ccccb3" border="0" cellspacing="0" cellpadding="2" style="border: 1px solid #ccccb3" >
			<tr>
				<th  width="100px">Articolo</th>
				<th width="200px">Euro</th>
			</tr>
			</table>
			<%
				for (int i = 0; i < carrello.size(); i++) {
					for (int j = 0; j < ricambi.size(); j++) {

						if (carrello.get(i).getId_ricambio() == ricambi.get(j).getId()) {
			%>
			<%
				ricambio = ricambi.get(j);
							car = carrello.get(i);
			%>
<br>
<table>
			<tr>


				<td align="center"><span style="color: #0D0D08"><%=ricambio.getTipo()%>
						<%=ricambio.getMarca()%></span>  </td>
				<td align="center"><span
					style="font-weight: bold; color: #D71212">&nbsp &nbsp &nbsp
						x <%=car.getQuantità()%> &nbsp &nbsp &nbsp<%=ricambio.getPrezzo()%> </span></td>


				
			</tr>
		</table>
		<%
			}
				}
			}
		%>


	</div>

</body>
</html>