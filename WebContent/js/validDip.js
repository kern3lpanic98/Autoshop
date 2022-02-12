function validDip() {

		// prelevo variabili 
		
		var esitoName = document.getElementById('checkRegularName');
		var name = document.getElementById('name').value;
		
		var esitoPass = document.getElementById('checkRegularPass');
		var pass = document.getElementById('pass').value;
		
		var esitoSurname = document.getElementById('checkRegularSurname');
		var surname = document.getElementById('surname').value;
		
		var pass2 = document.getElementById('pass2').value;

		var esitoUser = document.getElementById('checkRegularEmail');
		var user = document.getElementById('user').value;
		
		// espressioni regolari 
		
		var password = new RegExp("^[a-zA-Z0-9]{8,15}$");
		var email = new RegExp(
				'^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$');
		var nomi = new RegExp("^(([a-zA-Z])+[\\s]*)+$");
		
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
			alert("Password con meno di 8 caratteri");
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
		alert("L'account è stato creato!");
}