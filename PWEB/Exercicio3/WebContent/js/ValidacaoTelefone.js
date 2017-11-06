function ValidacaoTelefone(tel) {
	if(tel.value.length != 8){
		document.getElementById("msgtel").innerHTML = "<font color='red'>Telefone inválido </font>";
		
		alert("Telefone inválido");
	} else {
		if (isNaN(tel.value)) {
		       document.getElementById("msgtel").innerHTML = "<font color='red'>Telefone inválido </font>";
			
		       alert("Digite apenas números!");
		} else {
			document.getElementById("msgtel").innerHTML = "Telefone válido";
			
			alert("Telefone válido");
		}
	}
}