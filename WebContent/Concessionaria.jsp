<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>



<head>
<title>Autoshop</title>
<link rel="stylesheet" href="css/concessionaria-modify.css"
	type="text/css">
<!--   <link rel="stylesheet" href="css/ricerca.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">-->
<link rel="stylesheet" href="css/Jslider.css" type="text/css">



<body >


	<%@ include file="header.html"%>

<jsp:include page="menuConcessionaria.jsp" />


	<div class="slideshow-container">
		<div class="mySlides fade">
			<div class="numbertext"></div>
			<img src="Immagini/img.jpg " style="width: 100%">
			<div class="text"></div>
		</div>

		<div class="mySlides fade">
			<div class="numbertext"></div>
			<img src="Immagini/promo.jpg" style="width: 100%">
			<div class="text"></div>
		</div>

		<div class="mySlides fade">
			<div class="numbertext"></div>
			<img src="Immagini/hyundai-elite.jpg" style="width: 100%">
			<div class="text"></div>
		</div>

		<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
			onclick="plusSlides(1)">&#10095;</a>
	</div>
	<br>

	<div style="text-align: center">
		<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
			onclick="currentSlide(2)"></span> <span class="dot"
			onclick="currentSlide(3)"></span>
	</div>

	<!-- Script - Slider a Libro -->
	<div id="tableContainer">
		<div id="tableRow">
			<script id="script" language="JavaScript" type="text/javascript">
			<!--
				var slideIndex = 0;
				showSlides();

				function showSlides() {
					var i;
					var slides = document.getElementsByClassName("mySlides");
					for (i = 0; i < slides.length; i++) {
						slides[i].style.display = "none";
					}
					slideIndex++;
					if (slideIndex > slides.length) {
						slideIndex = 1
					}
					slides[slideIndex - 1].style.display = "block";
					setTimeout(showSlides, 4000); // Change image every 2 seconds
				}
			// end  -->
			</script>

			<div id="Book" style="position: relative"></div>
		</div>
	</div>

	<div>
		<span id="motto_uno">NON INSEGUIRE I TUOI SOGNI.</span><span
			id="motto_due">GUIDALI.</span>
	</div>
	<div>
		<img id="fiat-f" src="Immagini/Fiat-footer.png"> <img
			id="hyundai-f" src="Immagini/hyundai-footer.png">
	</div>



</body>
</html>