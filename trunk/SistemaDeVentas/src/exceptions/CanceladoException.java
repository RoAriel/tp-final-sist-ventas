package exceptions;

public class CanceladoException extends EstadoEnvioException {

	public CanceladoException(){}
	
	public CanceladoException(String mensajeError){
		System.out.println(mensajeError);
	}
}
