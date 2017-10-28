var teclasPulsadas = 0;

function alertarCambioMagistrado(){
	teclasPulsadas = teclasPulsadas + 1;
	if(teclasPulsadas == 2){
		jQuery('#spAlertaCambioMagistrado').css('visibility','visible');
	}
}