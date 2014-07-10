package envio;

import org.joda.time.DateTime;
import exceptions.ReprogramadoException;

public class Reprogramado extends EstadoEnvio {

	@Override
	public void reprogramar(Envio env, DateTime fecha) throws ReprogramadoException{
	
		env.getVenta().devolverCompra();
		env.setFechaEnvio(fecha);
		
	}




}
