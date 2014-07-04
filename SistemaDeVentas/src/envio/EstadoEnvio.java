package envio;

import org.joda.time.DateTime;

import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;

public abstract class EstadoEnvio {

	public abstract void enviar(Envio env)  throws EnProcesoException;
	
	public abstract void cancelar(Envio env) throws CanceladoException;
	
	public abstract void reprogramar(Envio env, DateTime facha) throws ReprogramadoException;
	
}
