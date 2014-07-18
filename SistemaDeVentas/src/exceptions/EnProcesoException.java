package exceptions;

public class EnProcesoException extends EstadoEnvioException {

	public EnProcesoException(String mensajeError) {
		System.out.println(mensajeError);
	}

}
