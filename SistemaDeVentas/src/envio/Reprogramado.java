package envio;

import org.joda.time.DateTime;
import exceptions.ReprogramadoException;

public class Reprogramado extends EstadoEnvio {


/**
 * Envia estado Cancelar el msj cancelar 
 * @param env es un envio que es el mismos que envia el mensaje
 * 
 */
	@Override
	public void reprogramar(Envio env, DateTime fecha) throws ReprogramadoException{
	
		env.getVenta().devolverCompra();
		env.setFechaEnvio(fecha);
		
	}




}
