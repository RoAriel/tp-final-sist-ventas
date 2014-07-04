package exceptions;

public class ReprogramadoException extends EstadoEnvioException {

	public ReprogramadoException(){}
	
	public ReprogramadoException(String mensajeError){
		System.out.println(mensajeError);
	}
}
