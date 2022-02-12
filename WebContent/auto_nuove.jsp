<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,model.Automobile"%>
<%
	ArrayList<Automobile> lista = (ArrayList<Automobile>) request.getAttribute("list");
    ArrayList<Automobile> filtri = (ArrayList<Automobile>) request.getAttribute("filtri");
    ArrayList<Automobile> oggetti;
	Automobile auto;
	String rif;
%>

<!DOCTYPE html>
<html>
<head>

<title>Auto Nuove</title>
<!--  <link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet" />-->
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<link rel="stylesheet" href="css/Nuove.css" type="text/css">
<link rel="stylesheet" href="css/ricerca.css" type="text/css">
<link rel="stylesheet" href="css/guida.css" type="text/css">
<link rel="stylesheet" href="css/schedaTecnica.css" type="text/css">

<!-- javascript per le offerte nella concessionaria -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/responsiveslides.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js">
	
</script>

<!-- Fa muovere la riga dello slider-->
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {

		// Slideshow 1
		$("#slider1").responsiveSlides({
			maxwidth : 1600,
			speed : 600
		});
	});
</script>



<!-- javascript per la vendita -->
<script type="text/javascript" src="js ecommerce/simpleCart.js"></script>
<script type="text/javascript">
	simpleCart.currency = EUR; //USD (i dollari sono il valore di default), GBP, EUR, AUD, CAD, CHF, etc
	simpleCart.taxRate = 0; //valore percentuale dellâimposta o IVA
	simpleCart.shippingFlatRate = 15.00; //costi di spedizione, aggiunge un importo forfettario di spedizione per l'intero ordine

	simpleCart.cartHeaders = [ "Name", /*"Size"*/, "Price", "decrement",
			"Quantity", "increment", "remove", "Total" ];
</script>

<link href="css/styles1.css" rel="stylesheet" type="text/css">
</head>

<body>

	<%@ include file="header.html"%>
 	<jsp:include page="menuConcessionaria.jsp" /> 

	<!-- Titolo della pagina -->
	<aside>
		<div id="guida">
			<h3>
				<mark>&raquo Nuove</mark>
			</h3>
		</div>
	</aside>
	
	<!---start-wrap--->
	<div class="wrap">
		<div class="our-clients">
			<h3>Auto Nuove - (offerte)</h3>
			<div class="tsc_carousel_hor">
				<div class="l-carousel">
					<div class="jcarousel-container jcarousel-container-horizontal"
						style="position: relative; display: block;">
						<div class="jcarousel-clip jcarousel-clip-horizontal"
							style="overflow: hidden; position: relative;">
							<ul class="carousel jcarousel-list jcarousel-list-horizontal"
								style="overflow: hidden; position: relative; top: 0px; left: -454px; margin: 0px; padding: 0px; width: 1816px;">



								<%
								if(request.getAttribute("token").equals("true")){
									oggetti=filtri;
								}
								else oggetti=lista;
									for (int i = 0; i < oggetti.size(); i++) {
										auto = oggetti.get(i);

										rif = "./ControlloAutoNuove?action=read&id=";
								%>
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-1 jcarousel-item-1-horizontal"
									jcarouselindex="1"
									style="float: left; list-style: none; height: 200px;"><a
									href="#"><img src="<%=auto.getPath()%>" width="175"
										height="115" border="0"></a>
									<h4>

										<a
											href="./ControlloAutoNuove?action=read&id=<%=Integer.toString(auto.getId())%>"><%=auto.getMarca() + " " + auto.getModello()%></a>

									</h4>
									<p>
										Prezzo: €<%=auto.getPrezzo()%>
										<%
											}
										%>
									</p></li>


							</ul>

						</div>

						<div class="jcarousel-prev jcarousel-prev-horizontal"
							style="display: block;"></div>
						<div
							class="jcarousel-next jcarousel-next-horizontal jcarousel-next-disabled jcarousel-next-disabled-horizontal"
							disabled="disabled" style="display: block;"></div>
					</div>
				</div>

				<div class="clear"></div>
				<script type="text/javascript" src="js/tsc_jqcarousel.js"></script>
				<script type="text/javascript">
					$(function() {
						jQuery('.tsc_carousel_hor .carousel').jcarousel({
							scroll : 1
						});
					});
				</script>
				<!-- DC Horizontal Carousel:Light End -->
			</div>
		</div>
		<div class="our-clients">
			<hr />
		</div>
	</div>


	<!-- Carrello Vendita  -->
	<div id="wrapper">
		<div id="container">
			<h1>Concessionaria - Auto Nuove</h1>


			<%
				for (int i = 0; i < lista.size(); i++) {
					auto = lista.get(i);
			%>
			<div class="simpleCart_shelfItem">
				<h3 class="item_name"><%=auto.getMarca() + " " + auto.getModello()%></h3>
				<img src="<%=auto.getPath()%>" width="150px" height="100px" /> <strong
					class="item_price"><%=auto.getPrezzo()%></strong> 
					<a href="./ControlloAutoNuove?action=read&id=<%=Integer.toString(auto.getId())%>"><input
					type="button" class="item_add" value="Dettagli" /></a>
			</div>
			<%
				}
			%>

			
</body>
</html>