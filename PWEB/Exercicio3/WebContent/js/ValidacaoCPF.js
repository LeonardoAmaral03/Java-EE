function ValidacaoCPF(cpf) {  
    cpf.value = cpf.value.replace(/[^\d]+/g,'');    
    if(cpf.value == '') {
    	document.getElementById("msgcpf").innerHTML = "<font color='red'>CPF inválido </font>";

    	alert("CPF inválido");
    } else {
	    // Elimina CPFs invalidos conhecidos    
	    if (cpf.value.length != 11 || 
	        cpf.value == "00000000000" || 
	        cpf.value == "11111111111" || 
	        cpf.value == "22222222222" || 
	        cpf.value == "33333333333" || 
	        cpf.value == "44444444444" || 
	        cpf.value == "55555555555" || 
	        cpf.value == "66666666666" || 
	        cpf.value == "77777777777" || 
	        cpf.value == "88888888888" || 
	        cpf.value == "99999999999"){
	    	document.getElementById("msgcpf").innerHTML = "<font color='red'>CPF inválido </font>";
	
	    	alert("CPF inválido");  
	    } else {
		    // Valida 1o digito 
		    add = 0;    
		    for (i=0; i < 9; i ++)       
		        add += parseInt(cpf.value.charAt(i)) * (10 - i);  
		        rev = 11 - (add % 11);  
		        if (rev == 10 || rev == 11)     
		            rev = 0;    
		        if (rev != parseInt(cpf.value.charAt(9))){   
		        	document.getElementById("msgcpf").innerHTML = "<font color='red'>CPF inválido </font>";
		
		        	alert("CPF inválido");      
		        } else {
				    // Valida 2o digito 
				    add = 0;    
				    for (i = 0; i < 10; i ++)        
				        add += parseInt(cpf.value.charAt(i)) * (11 - i);  
				    rev = 11 - (add % 11);  
				    if (rev == 10 || rev == 11) 
				        rev = 0;    
				    if (rev != parseInt(cpf.value.charAt(10))){
				    	document.getElementById("msgcpf").innerHTML = "<font color='red'>CPF inválido </font>";
				
				    	alert("CPF inválido");      
				    } else {
					    document.getElementById("msgcpf").innerHTML = "CPF válido";
						
					    alert("CPF válido");
				    }
		        }
	    }
    }
}