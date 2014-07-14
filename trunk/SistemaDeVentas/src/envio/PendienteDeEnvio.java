package envio;

public class PendienteDeEnvio extends EstadoEnvio {

	public PendienteDeEnvio(){
		
	}
	
	@Override
	public Boolean esPendienteDeEnvio(){
		return true;
	}

}
