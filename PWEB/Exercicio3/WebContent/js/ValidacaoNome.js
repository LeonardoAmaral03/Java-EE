function ValidacaoNome(nome) {
	if(nome.value == ''){
		document.getElementById("msgnome").innerHTML = "<font color='red'>Nome inválido </font>";
		
		alert("Preencha o campo Nome");
	} else {
		document.getElementById("msgnome").innerHTML = "Nome válido";
		
		alert("Nome válido");
	}
}