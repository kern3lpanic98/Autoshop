function validQnt(index) {

	var ricambio = "r";
	var id_text = ricambio + index;
	var qntRicambio = document.getElementById(id_text).value;
	var label = document.getElementById(index);
	var numeri = new RegExp("^[1-9]{0,3}$");

	if (qntRicambio != "") {

		if (numeri.test(qntRicambio)) {

			document.getElementById("modulo" + index).submit();

		} else {

			label.innerHTML = "Inserire un valore numerico maggiore di 0"; 
		}                                                                                                                                                                                                                                                                
	} else {
		label.innerHTML = "Inserire una quantità numerica ";
	}

}