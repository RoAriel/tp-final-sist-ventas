package envio;

import org.joda.time.DateTime;
import exceptions.ReprogramadoException;


public class PendienteDeEnvio extends EstadoEnvio {

	@Override
	public void reprogramar(Envio env, DateTime fecha)throws ReprogramadoException {

		env.getVenta().devolverCompra();
		env.setEstado(new Reprogramado());
		env.reprogramar(fecha);
		
	}



}
