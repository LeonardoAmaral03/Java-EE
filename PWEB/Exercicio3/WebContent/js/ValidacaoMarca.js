function ValidacaoMarca(marca) {
	if(marca.value == ''){
		document.getElementById("msgmarca").innerHTML = "<font color='red'>Marca inválida </font>";
		
		alert("Preencha o campo Marca");
	} else {
		document.getElementById("msgmarca").innerHTML = "Marca válida";
		
		alert("Marca válida");
	}
}