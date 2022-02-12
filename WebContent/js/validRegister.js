	function validRegister() {

		// prelevo variabili 
		
		var esitoName = document.getElementById('checkRegularName');
		var name = document.getElementById('name').value;

		var esitoPass = document.getElementById('checkRegularPass');
		var pass = document.getElementById('pass').value;
		
		var esitoVia = document.getElementById('checkRegularVia');
		var via = document.getElementById('via').value;
		
		var esitoCC = document.getElementById('checkRegularCC');
		var cap = document.getElementById('cap').value;
		var civico = document.getElementById('civico').value;

		var pass2 = document.getElementById('pass2').value;

		var esitoSurname = document.getElementById('checkRegularSurname');
		var surname = document.getElementById('surname').value;

		var esitoUser = document.getElementById('checkRegularEmail');
		var user = document.getElementById('user').value;

		
	
		

		
	
		
		// espressioni regolari

		var password = new RegExp("^[a-zA-Z0-9]{8,15}$");
		var email = new RegExp(
				'^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$');

		var nomi = new RegExp("^(([a-zA-Z])+[\\s]*)+$");
		var civicoR = new RegExp("^[0-9]{1,3}$")
		var capR = new RegExp("^[0-9]{5}$")

		
		//controlli 
		
		if (!nomi.test(name)) {
			esitoName.style.color = "red";
			esitoName.style.fontSize = "13px";
			esitoName.innerHTML = "Inserire solo caratteri alfabetici<br><br>";
			return false;

		}
		else{
			esitoName.innerHTML="";
		}
	
		if (!nomi.test(surname)) {
			
			esitoSurname.style.color = "red";
			esitoSurname.style.fontSize = "13px";
			esitoSurname.innerHTML = "Inserire solo caratteri alfabetici<br><br>";
			return false;

		}
		else{
			esitoSurname.innerHTML="";
		}

		if (!email.test(user)) {
			esitoUser.style.color = "red";
			esitoUser.style.fontSize = "13px";
			esitoUser.innerHTML = "Email non conforme. Es xyz@xht.it/com. Riprovare <br><br>";

			return false;
		}
		else{
			esitoUser.innerHTML="";
		}

	
		if (!password.test(pass)) {

			esitoPass.style.color = "red";
			esitoPass.style.fontSize = "13px";
			esitoPass.innerHTML = "Inserire password con minimo 8 e massimo 15 caratteri <br><br>";

			return false;

		} else if (pass != pass2) {
			esitoPass.style.color = "red";
			esitoPass.style.fontSize = "13px";
			esitoPass.innerHTML = "Le due password non coincidono <br><br>";
			return false;
		}
		else{
			esitoPass.innerHTML="";
		}
		if (!nomi.test(via)) {

			esitoVia.style.color = "red";
			esitoVia.style.fontSize = "13px";
			esitoVia.innerHTML = "Inserire solo caratteri alfabetici <br><br>";

			return false;

		}
		else{
			esitoVia.innerHTML="";
		}
		
		if (!civicoR.test(civico)) {

			esitoCC.style.color = "red";
			esitoCC.style.fontSize = "13px";
			esitoCC.innerHTML = "Inserire da 1 a 3 caratteri numerici per il civico <br><br>";

			return false;

		}
		else{
			esitoCC.innerHTML="";
		}
		if (!capR.test(cap)) {

			esitoCC.style.color = "red";
			esitoCC.style.fontSize = "13px";
			esitoCC.innerHTML = "Inserire 5 caratteri numerici per il cap  <br><br>";

			return false;

		}
		else{
			esitoCC.innerHTML="";
		}

		return true;

	}