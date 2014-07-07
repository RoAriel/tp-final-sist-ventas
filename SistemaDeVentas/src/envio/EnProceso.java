package envio;

import org.joda.time.DateTime;

import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;
import exceptions.SaldoInsuficienteCtaCteException;

public class EnProceso extends EstadoEnvio {

	@Override
	public void enviar(Envio env, double cantAAbonar) throws EnProcesoException, SaldoInsuficienteCtaCteException {

		env.getVenta().getCliente().getCtaCte().abonar(cantAAbonar);
	}

	@Override
	public void cancelar(Envio env) throws CanceladoException {

		env.getVenta().devolverCompra();
		
	}

	@Override
	public void reprogramar(Envio env, DateTime fecha)throws ReprogramadoException{
		
		env.getVenta().devolverCompra();
		env.setFechaEnvio(fecha);
		
	}



}
