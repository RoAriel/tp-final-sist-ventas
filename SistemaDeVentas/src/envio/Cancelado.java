package envio;

import org.joda.time.DateTime;

import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;

public class Cancelado extends EstadoEnvio {

	public void enviar(Envio env) throws EnProcesoException{
		
		throw new EnProcesoException
			("Estado del Envio Cancelado: No se lo pede enviar");

	}

	public void cancelar(Envio env) {
		
		env.getVenta().devolverCompra();

	}

	public void reprogramar(Envio env, DateTime fecha) throws ReprogramadoException{
		throw new ReprogramadoException
		("Estado del Envio Cancelado: No se lo pede reprogramar");

	}


}
