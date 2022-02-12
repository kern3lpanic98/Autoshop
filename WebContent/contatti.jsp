<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Contatti</title>
<link rel="stylesheet" href="css/concessionaria-modify.css" type="text/css">
<link rel="stylesheet" href="css/ricerca.css" type="text/css">
<link rel="stylesheet" href="css/Contatti.css" type="text/css">
<link rel="stylesheet" href="css/guida.css" type="text/css">

<!-- Script per la ricerca -->
<script language="JavaScript" type="text/javascript">
<!--
	var item = new Array();

	// "Nome pagina","percorso","Titolo pagina","parole,chiave,Key,Words","Descrizione e Commenti"

	c = 0;
	item[c] = new Array("Concessionaria.jsp", "", "Concessionaria",
			"commento,sito,home", "Concessionaria");

	c++;
	item[c] = new Array("Auto Nuove.jsp", "", "Auto Nuove", "nuove",
			"In questa pagina troverete vari tipi d'auto nuovissime.");

	c++;
	item[c] = new Array("Auto Usate.jsp", "", "Auto Usate", "usate",
			"In questa pagina troverete vari tipi d'auto usate.");

	c++;
	item[c] = new Array("Ricambi.jsp", "", "Ricambi",
			"ricambi, pezzi, componenti",
			"In questa pagina troverete vari tipi di pezzi di ricambio per auto.");

	c++;
	item[c] = new Array("Contatti.jsp", "", "Contatti",
			"contatti, indirizzo, via",
			"In questa pagina troverete vari tipi d'auto usate.");

	c++;
	item[c] = new Array("biografia.jsp", "", "biografia",
			"biografia, storia, testo",
			"In questa pagina troverete la biografia dei creatori del sito.");

	c++;
	item[c] = new Array("index.jsp", "", "Login", "Login",
			"Qui potete registravi per accedere al database del sito.");

	page = "<html><head><title>Risultato della ricerca</title><\/head><body bgcolor='#99FF66'><center><table border=0 cellspacing=10 width=80%>";

	function search(frm) {
		win = window.open("", "", "scrollbars");
		win.document.write(page);
		txt = frm.srchval.value.split(" ");
		fnd = new Array();
		total = 0;
		for (i = 0; i < item.length; i++) {
			fnd[i] = 0;
			order = new Array(0, 4, 2, 3);
			for (j = 0; j < order.length; j++)
				for (k = 0; k < txt.length; k++)
					if (item[i][order[j]].toLowerCase().indexOf(txt[k]) > -1
							&& txt[k] != "")
						fnd[i] += (j + 1);
		}
		for (i = 0; i < fnd.length; i++) {
			n = 0;
			w = -1;
			for (j = 0; j < fnd.length; j++)
				if (fnd[j] > n) {
					n = fnd[j];
					w = j;
				}
			;
			if (w > -1)
				total += show(w, win, n);
			fnd[w] = 0;
		}
		win.document.write("<\/table><br>Parole trovate: " + total
				+ "<br><\/center><\/body><\/html>");
		win.document.close();
	}
	function show(which, wind, num) {
		link = item[which][1] + item[which][0];
		line = "<tr><td><a href='"+link+"'>" + item[which][2] + "</a> Punti: "
				+ num + "<br>";
		line += item[which][4] + "<br>" + link + "<\/td><\/tr>";
		wind.document.write(line);
		return 1;
	}
	-->
</script>

<!-- Script per la mappa -->
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js? sensor=true & language=it">
	
</script>
<script type="text/javascript">
	function initialize() {
		var latlng = new google.maps.LatLng(41.109947, 14.847514); // centro della mappa
		var myLatlng = new google.maps.LatLng(40.773671, 14.794072); // segnapunto
		// definizione della mappa
		var myOptions = {
			zoom : 8,
			center : latlng,
			mapTypeId : google.maps.MapTypeId.HYBRID,
			mapTypeControlOptions : {
				style : google.maps.MapTypeControlStyle.HORIZONTAL_BAR
			}
		}
		mymap = new google.maps.Map(document.getElementById("map"), myOptions);
		// definizione segnapunto
		var marker = new google.maps.Marker({
			position : myLatlng,
			map : mymap,
			title : "Concessionaria T&C"
		});
	}
</script>
</head>

<body onload="initialize()">
	<!--  	<header class="top">
			<img src="Immagini/logo.png" alt="Concessionaria Auto">
			<form method=get action="javascript:void(0)" onsubmit="search(this); return false;">
				<input id="s" name="srchval" type="text" value="" onfocus="if(this.value==this.defaultValue)this.value=''"> 
				<input class="btn" type=submit value="Cerca">
			</form>
		</header>
		-->


<%@ include file="header.html"%>
	


	<!-- Titolo della pagina -->
	<aside>
		<div id="guida">
			<h3>
				<mark>&raquo Contatti</mark>
			</h3>
		</div>
	</aside>
	
	<section>
		<div>
			<h1>Posizione della concessionaria</h1>
		</div>
	</section>

	<!-- Mappa -->
	<section>
		<div id="map"></div>
	</section>

</body>
</html>