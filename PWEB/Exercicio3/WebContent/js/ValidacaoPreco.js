function ValidacaoPreco(preco) {
	if(preco.value == ''){
		document.getElementById("msgpreco").innerHTML = "<font color='red'>Preço inválido </font>";
		
		alert("Preencha o campo Preço");
	} else {
		if (isNaN(preco.value)) {
		       document.getElementById("msgpreco").innerHTML = "<font color='red'>Preço inválido </font>";
			
		       alert("Digite apenas números!");
		} else {
			document.getElementById("msgpreco").innerHTML = "Preço válido";
			
			alert("Preço válido");
		}
	}
}