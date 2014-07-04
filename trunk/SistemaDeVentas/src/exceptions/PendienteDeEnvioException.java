package exceptions;

public class PendienteDeEnvioException extends EstadoEnvioException {

	public PendienteDeEnvioException(){}
	
	public PendienteDeEnvioException(String mensajeError){
		System.out.println(mensajeError);
	}
}
