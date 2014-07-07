package envio;

import org.joda.time.DateTime;

import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;
import exceptions.SaldoInsuficienteCtaCteException;

public abstract class EstadoEnvio {

	public abstract void enviar(Envio env, double cantAAbonar)  throws EnProcesoException, SaldoInsuficienteCtaCteException;
	
	public abstract void cancelar(Envio env) throws CanceladoException;
	
	public abstract void reprogramar(Envio env, DateTime fecha) throws ReprogramadoException;
	
}
