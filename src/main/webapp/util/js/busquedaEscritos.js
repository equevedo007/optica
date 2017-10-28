function manejoPasarARevision(xhr, status, args) {
	if (args.pasarCorrecto) {
		confirmationrevision.show();
	}
}

function manejoRechazar(xhr, status, args) {
	if (args.rechazarCorrecto) {
		confirmationrechazar.show();
	}
}

function manejoAprobar(xhr, status, args) {
	if (args.aprobarCorrecto) {
		confirmationaprobar.show();
	}
}

function manejoEditar(xhr, status, args) {
	if (args.editarCorrecto) {
		DEditDatDoc.show();
	}
}