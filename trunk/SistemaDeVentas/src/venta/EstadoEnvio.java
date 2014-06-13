package venta;

import org.joda.time.DateTime;

public abstract class EstadoEnvio {

	public abstract void enviar(Envio env);
	
	public abstract void cancelar(Envio env);
	
	public abstract void reprogramar(Envio env, DateTime facha);
	
}
