function ValidacaoQuantidade(quantidade) {
	if(quantidade.value == ''){
		document.getElementById("msgqtd").innerHTML = "<font color='red'>Quantidade inválida </font>";
		
		alert("Preencha o campo Quantidade");
	} else {
		if (isNaN(quantidade.value)) {
		       document.getElementById("msgqtd").innerHTML = "<font color='red'>Quantidade inválida </font>";
			
		       alert("Digite apenas números!");
		} else {
			document.getElementById("msgqtd").innerHTML = "Quantidade válida";
			
			alert("Quantidade válida");
		}
	}
}