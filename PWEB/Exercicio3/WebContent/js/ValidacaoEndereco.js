function ValidacaoEndereco(endereco) {
	if(endereco.value == ''){
		document.getElementById("msgendereco").innerHTML = "<font color='red'>Endereço inválido </font>";
		
		alert("Preencha o campo Endereço");
	} else {
		document.getElementById("msgendereco").innerHTML = "Endereço válido";
		
		alert("Endereço válido");
	}
}