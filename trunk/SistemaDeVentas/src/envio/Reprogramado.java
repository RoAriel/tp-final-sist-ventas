package envio;

import org.joda.time.DateTime;

import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;

public class Reprogramado extends EstadoEnvio {

	@Override
	public void enviar(Envio env, double cantAAbonar) throws EnProcesoException {

		throw new EnProcesoException("Estado del Envio Reprogramado: No se lo pede enviar hasta la nueva fecha");
	}

	@Override
	public void cancelar(Envio env) throws CanceladoException {

		env.getVenta().devolverCompra();		
	}

	@Override
	public void reprogramar(Envio env, DateTime fecha) throws ReprogramadoException{
	
		env.getVenta().devolverCompra();
		env.setFechaEnvio(fecha);
		
	}




}
