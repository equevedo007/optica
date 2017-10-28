$(function() { // Equals $(document).ready
	$('#dlgAsignarPlantilla').resize(function() {
		var height = $('#dlgAsignarPlantilla').height();
		$('#divLisPlantillas').height(height - 120);
	});
	
	$('#dlgAsignarPlantilla .ui-dialog-titlebar-maximize').click(function(){
		setTimeout(function(){
			var height = $('#dlgAsignarPlantilla').height();
			$('#divLisPlantillas').height(height - 120);
		},2);
	});
});


function manejoRecibidoGal(xhr, status, args) {
	if (args.recibidoGalCorrecto) {
		$('#frmDialogRecepcionArea\\:btnRecepArea').show();
		$('#frmDialogRecepcionArea\\:btnRecepNot').hide();
		dlgConfirmarRecepcionVar.show();
	}
}

function manejoAsignarPlantilla(xhr, status, args) {
	if (args.asignarCorrecto) {
		var widthWindow = $(window).width();
		var heightWindow = $(window).height();
		var widDiv = widthWindow - 400;
		var heightDiv = heightWindow - 300;
		var heightTabla = heightDiv - 120; 
		$('#dlgAsignarPlantilla').width(widDiv);
		$('#dlgAsignarPlantilla').height(heightDiv);
		$('#divLisPlantillas').height(heightTabla);
		dlgVarAsignarPlantilla.show();
	}
}

function manejoCrearEscritos(xhr, status, args){
	if (args.escritoCorrecto) {
		dlgVarAsignarPlantilla.hide();
	}
}

function manejoRecepcion(xhr, status, args) {
	if (args.recepcionCorrecto) {
		$('#frmDialogRecepcionArea\\:btnRecepArea').hide();
		$('#frmDialogRecepcionArea\\:btnRecepNot').show();
		dlgConfirmarRecepcionVar.show();
	}
}