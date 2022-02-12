	function controlUser(){
	
	
    var esitoUser = document.getElementById('checkRegularEmail');
	var user = document.getElementById('user').value;
	
	 var esitoP = document.getElementById('checkRegularP');
		var pass = document.getElementById('p').value;
	
	var espressione = new RegExp('^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$');
	var password = new RegExp("^[a-zA-Z0-9]{8,15}$");
	
		if(!espressione.test(user)){
		esitoUser.style.color="red";
		esitoUser.style.fontSize="13px";
		esitoUser.innerHTML="Email non conforme. Es xyz@xht.it/com. Riprovare <br><br>";
		alert("email non valida");
	   return false;
	}
	

		
		

		if (!password.test(pass)) {

			esitoP.style.color = "red";
			esitoP.style.fontSize = "13px";
			esitoP.innerHTML = "Inserire password con minimo 8 e massimo 15 caratteri <br><br>";
			alert("password non valida");
			return false;
	}
		else{
			esitoP.innerHTML="";
		}
		
	}