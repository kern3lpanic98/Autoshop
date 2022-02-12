
function validRicambi(){
	
	
	var esitoMarca = document.getElementById('checkRegularMarca');
	var marca = document.getElementById('marcaa').value;
	
	var esitoNum = document.getElementById('checkRegularNum');
	var prezzo = document.getElementById('p').value;
	
	
	var qnt = document.getElementById('qntt').value;
	
	var esitoTipo = document.getElementById('checkRegularTipo');
	var tipo = document.getElementById('tipoo').value;
	
	
	var esitoFile = document.getElementById('checkRegularFile');
	
	var file = document.getElementById("filee").value;
	
	var nomi = new RegExp("^(([a-zA-Z])+[\\s]*)+$");
	var prezzoRegex = new RegExp("^[0-9]{1,5}[\.]{0,1}[0-9]{0,5}$");
	var numInt = new RegExp("^[0-9]{1,5}$");

	
	
	//controlli 
	 

	
	if (!nomi.test(marca)) {
		esitoMarca.style.color = "red";
		esitoMarca.style.fontSize = "13px";
		esitoMarca.innerHTML = "Inserire solo caratteri alfabetici<br><br>";
		
		return false;
	}
		else{
			esitoMarca.innerHTML="";
			
		}

	if (!nomi.test(tipo)) {
		esitoTipo.style.color = "red";
		esitoTipo.style.fontSize = "13px";
		esitoTipo.innerHTML = "Inserire solo caratteri alfabetici<br><br>";
		return false;
	}
		else{
			esitoTipo.innerHTML="";
		}
	
	
	

	if (!numInt.test(qnt)) {
		esitoNum.style.color = "red";
		esitoNum.style.fontSize = "13px";
		esitoNum.innerHTML = "Inserire da uno a 3 caratteri numerici per la quantita'<br><br>";
		return false;
	}
		else{
			esitoNum.innerHTML="";
		}
	
	if (!prezzoRegex.test(prezzo)) {
		esitoNum.style.color = "red";
		esitoNum.style.fontSize = "13px";
		esitoNum.innerHTML = "Inserire il prezzo <br><br>";
		return false;
	}
		else{
			esitoNum.innerHTML="";
		}
	
	


	
	
		var allowed_extensions = new Array("jpg","png","gif");
	    var file_extension = file.split('.').pop().toLowerCase(); // split function will split the filename by dot(.), and pop function will pop the last element from the array which will give you the extension as well. If there will be no extension then it will return the filename.

	    for(var i = 0; i <= allowed_extensions.length; i++)
	    {
	        if(allowed_extensions[i]==file_extension)
	        {
	            return true; // valid file extension
	        }
	    }
	    esitoFile.style.color = "red";
		esitoFile.style.fontSize = "13px";
	    esitoFile.innerHTML="Inserire un file immagine ";
	    return false;
		
	
}