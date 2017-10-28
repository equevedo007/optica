function validarNumero(e) {
	var tecla = (document.all) ? e.keyCode : e.which;
	 return ((tecla > 47 && tecla < 58) || tecla == 0 || tecla == 8);
}