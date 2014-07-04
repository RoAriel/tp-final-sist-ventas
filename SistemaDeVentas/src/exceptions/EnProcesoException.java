package exceptions;

public class EnProcesoException extends EstadoEnvioException {

	public EnProcesoException(){}
	
	public EnProcesoException(String mensajeError){
		System.out.println(mensajeError);
	}
	
}
