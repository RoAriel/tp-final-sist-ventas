package envio;

import org.joda.time.DateTime;

import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;

public class PendienteDeEnvio extends EstadoEnvio {

	@Override
	public void enviar(Envio env, double cantAAbonar) throws EnProcesoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar(Envio env) throws CanceladoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reprogramar(Envio env, DateTime fecha)
			throws ReprogramadoException {
		// TODO Auto-generated method stub
		
	}



}
