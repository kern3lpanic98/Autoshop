<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,model.RicambiAuto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ricambi Auto</title>
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<link rel="stylesheet" href="css/Nuove.css" type="text/css">
<link rel="stylesheet" href="css/ricerca.css" type="text/css">
<link rel="stylesheet" href="css/guida.css" type="text/css">



<!-- javascript per le offerte nella concessionaria -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/responsiveslides.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<!-- Fa muovere la riga-->
<script src="js/responsiveslides.min.js"></script>
<script>
	// You can also use "$(window).load(function() {"
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
	simpleCart.taxRate = 0; //valore percentuale dell’imposta o IVA
	simpleCart.shippingFlatRate = 15.00; //costi di spedizione, aggiunge un importo forfettario di spedizione per l'intero ordine

	simpleCart.cartHeaders = [ "Name", /*"Size"*/, "Price", "decrement",
			"Quantity", "increment", "remove", "Total" ];
</script>
<link href="css/styles1.css" rel="stylesheet" type="text/css">


</head>

<body>
	<%
		ArrayList<RicambiAuto> ricambi = (ArrayList<RicambiAuto>) request.getAttribute("ricambi");
		RicambiAuto ricambio;
	%>
	<%@ include file="header.html"%>

 <jsp:include page="menuConcessionaria.jsp" /> 



	<!-- Titolo della pagina -->
	<aside>
		<div id="guida">
			<h3>
				<mark>&raquo Ricambi</mark>
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
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-1 jcarousel-item-1-horizontal"
									jcarouselindex="1" style="float: left; list-style: none;">
									<a href="#"><img src="Immagini/Auto Nuove/Audi/A1.jpg"
										width="175" height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=1">Audi A1</a>
									</h4>
									<p>Prezzo: € 16,500.00</p>
								</li>
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-2 jcarousel-item-2-horizontal"
									jcarouselindex="2" style="float: left; list-style: none;">
									<a href="#"><img
										src="Immagini/Auto Nuove/Hyundai/hyundai ix35.jpg" width="175"
										height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=2">Hyundai
											ix35</a>
									</h4>
									<p>Prezzo: € 23,500.00</p>
								</li>
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-3 jcarousel-item-3-horizontal"
									jcarouselindex="3" style="float: left; list-style: none;">
									<a href="#"><img src="Immagini/Auto Nuove/Audi/Q2.jpg"
										width="175" height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=3">Audi Q2</a>
									</h4>
									<p>Prezzo: € 30,000.00</p>
								</li>
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-4 jcarousel-item-4-horizontal"
									jcarouselindex="4" style="float: left; list-style: none;">
									<a href="#"><img src="Immagini/Auto Nuove/Audi/R8.jpg"
										width="175" height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=4">Audi R8</a>
									</h4>
									<p>Prezzo: € 80,500.00</p>
								</li>
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-5 jcarousel-item-5-horizontal"
									jcarouselindex="5" style="float: left; list-style: none;">
									<a href="#"><img src="Immagini/Auto Nuove/Audi/TT.jpg"
										width="175" height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=5">Audi TT</a>
									</h4>
									<p>Prezzo: € 36,000.00</p>
								</li>
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-6 jcarousel-item-6-horizontal"
									jcarouselindex="6" style="float: left; list-style: none;">
									<a href="#"><img
										src="Immagini/Auto Nuove/Opel/opel mokka.jpg" width="175"
										height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=6">Opel Mokka</a>
									</h4>
									<p>Prezzo: € 19,750.00</p>
								</li>
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-7 jcarousel-item-7-horizontal"
									jcarouselindex="7" style="float: left; list-style: none;">
									<a href="#"><img
										src="Immagini/Auto Nuove/BMW/bmw serie 1.jpg" width="175"
										height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=7">BMW serie
											1</a>
									</h4>
									<p>Prezzo: € 41,000.00</p>
								</li>
								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-8 jcarousel-item-8-horizontal"
									jcarouselindex="8" style="float: left; list-style: none;">
									<a href="#"><img
										src="Immagini/Auto Nuove/Mercedes/Mercedes Classe A.jpg"
										width="175" height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=8">Mercedes
											classe A</a>
									</h4>
									<p>Prezzo: € 36,500.00</p>
								</li>


								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-2 jcarousel-item-2-horizontal"
									jcarouselindex="2" style="float: left; list-style: none;">
									<a href="#"><img
										src="Immagini/Auto Nuove/Renault/Talisman.jpg" width="175"
										height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=9">Renault
											Talisman</a>
									</h4>
									<p>Prezzo: € 29,600.00</p>
								</li>


								<li
									class="jcarousel-item jcarousel-item-horizontal jcarousel-item-2 jcarousel-item-2-horizontal"
									jcarouselindex="2" style="float: left; list-style: none;">
									<a href="#"><img
										src="Immagini/Auto Nuove/Alfa Romeo/Giulietta.jpg" width="175"
										height="115" border="0"></a>
									<h4>
										<a href="./ControlloAutoNuove?action=read&id=10">Alfa
											Romeo Giulietta</a>
									</h4>
									<p>Prezzo: € 22,000.00</p>
								</li>


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
			<h1>Concessionaria - Pezzi di ricambio</h1>

			<%
				for (int i = 0; i < ricambi.size(); i++) {
					ricambio = ricambi.get(i);
			%>

			<div class="simpleCart_shelfItem">
				<h3 class="item_name"><%=ricambio.getMarca()%>
					-
					<%=ricambio.getTipo()%>
				</h3>
				<img src="<%=ricambio.getPath()%>" width="150px" height="100px" />
				<strong class="item_price">€<%=ricambio.getPrezzo()%></strong> <a
					href="./ControlRicambi?action=read&id=<%=ricambio.getId()%>"><input
					type="button" class="item_add" value="Dettagli" /></a>
			</div>
			<%
				}
			%>


			<!-- 	
						<div class="clear">&nbsp;</div>
						<p>
						<h2>Riepilogo del carrello</h2>
						</p>
						<!-- si occuperà di popolare con i dati memorizzati nel cookie -->
			<!--  		<div class="simpleCart_items"></div>
						<div class="clear">&nbsp;</div>
		
						<div id="cartTotal">
							<!-- stampa il subtotale del carrello senza tasse e spese di spedizione -->
			<!--  		Totale parziale: <span class="simpleCart_total"></span>
		
							<!-- stampa l'importo totale delle spese di spedizione  -->
			<!--  		Spedizione: <span class="simpleCart_shippingCost"></span>
		
							<!-- stampa il totale del carrello dopo l'aggiunta di tasse e spese di spedizione -->
			<!--  		Totale finale: <span class="simpleCart_finalTotal"></span>
							<a href="javascript:;" class="simpleCart_checkout">Invia Ordine</a>
							<!-- href="javascript:;"  -->
			<!--  	</div>
					</div>
					<div class="clear">&nbsp;</div>
				</div>
				
	</body>
</html> -->