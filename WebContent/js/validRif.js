function validRif(index) {

	var gg = "gg"+index;
	var mm = "mm"+index;
	var aa = "aa"+index;
	
// prelevo data
	
	var giorno=document.getElementById(gg).value;
	var mese = document.getElementById(mm).value;
	var anno = document.getElementById(aa).value;
	
	
	var id_text = "r"+ index;
	var qntRicambio = document.getElementById(id_text).value;
	var label = document.getElementById(index);
	var numeri = new RegExp("^[0-9]{0,4}$");
	var regexAnno = new RegExp("^[0-9]{4}$");
	//controlli 
	
	if(giorno!=""){
		
		if(!numeri.test(giorno)){
			
			label.innerHTML = "Inserire caratteri numerici per il giorno";
			return;
		}
		else{
			
			var parseGiorno = parseInt(giorno);
			if(parseGiorno==0){
				label.innerHTML = "Scegliere un valore maggiore di 0 per il giorno";
			return;}
			if(parseGiorno>31){
				
				label.innerHTML = "Scegliere un valore minore o uguale a 31 per il giorno";
				return;
				
			}
			
		}
		
		
		
		if(mese!=""){
			
			if(!numeri.test(mese)){
				
				label.innerHTML = "Inserire caratteri numerici per il mese";
				return;
			}
			else{
				
				var parseMese = parseInt(mese);
				
				if(parseMese==0){
					label.innerHTML = "Scegliere un valore maggiore di 0 per il mese";
				return;}
				if(parseMese>12){
					
					label.innerHTML = "Scegliere un valore minore o uguale a 12 per il mese";
					return;
					
				}else if(parseMese==2){
					if(parseGiorno>28){
						label.innerHTML = "Scegliere un valore inferiore a 29 per questo mese";
						return;
					}
				}
				}
			
			if(anno!=""){
				
				if(!regexAnno.test(anno)){
					
					label.innerHTML = "Inserire 4 cifre numeriche nell'anno";
					return;
				}
				else{
					var parseAnno = parseInt(anno);
					  var preimpostata = new Date(parseAnno, parseMese, parseGiorno); //30 APRILE 2092
					    var oggi = new Date();
					     
					    var diff = preimpostata.getTime()  - oggi.getTime();
					     
					    //Se la data preimpostata è già passata
					    if(diff<=0){
					    	label.innerHTML = "Data già passata!";
							return;
					    }
					    
				}
				
				
			}
			else{
				label.innerHTML = "Inserire anno";
				return;
			}
		}
		else{
			label.innerHTML = "Inserire mese";
			return;
		}
	}
	else{
		label.innerHTML = "Inserire giorno";
		return ;
	}
	
	

	if (qntRicambio != "") {

		if (numeri.test(qntRicambio)) {
			 var parseQnt = parseInt(qntRicambio);
             if(parseQnt==0){
			label.innerHTML = "Inserire un valore numerico maggiore di 0";
             }
             else{
            	 label.innerHTML = "Richiesta rifornimento effettuata!";
			document.getElementById("modulo" + index).submit();
             }

		} 
		else{
			label.innerHTML = "Inserire solo valori numerici in input quantità";
		}
	} else {
		label.innerHTML = "Inserire un valore in input quantità ";
	}

}