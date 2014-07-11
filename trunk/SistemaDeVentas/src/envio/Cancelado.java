package envio;

import org.joda.time.DateTime;

import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;

public class Cancelado extends EstadoEnvio {
/**
 * Envia estado Cancelar el msj enviar 
 * @param env es un envio que es el mismos que envia el mensaje
 * @param cantAAbonar que es un nonto que tiene que abonar el cliente en su domicilio 
 * 
 */
	public void enviar(Envio env, double cantAAbonar) throws EnProcesoException{
		
		throw new EnProcesoException
			("Estado del Envio Cancelado: No se lo pede enviar");

	}

/**
 * Envia estado Cancelar el msj cancelar 
 * @param env es un envio que es el mismos que envia el mensaje
 * 
 */
	public void cancelar(Envio env) throws CanceladoException {
		
		throw new CanceladoException
		("Estado del Envio Cancelado: No se lo pede volver a cancelar");

	}

/**
 *  Envia estado Cancelar el msj reprogramar 
 * @param env es un envio que es el mismos que envia el mensaje
 * @param fecha es la nueva fecha del enivio
 * 
 * 
 */
	public void reprogramar(Envio env, DateTime fecha) throws ReprogramadoException{
		throw new ReprogramadoException
		("Estado del Envio Cancelado: No se lo pede reprogramar");

	}


}
