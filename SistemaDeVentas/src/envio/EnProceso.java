package envio;

import exceptions.EnProcesoException;
import exceptions.SaldoInsuficienteCtaCteException;

public class EnProceso extends EstadoEnvio {

	@Override
	public void enviar(Envio env, double cantAAbonar) throws EnProcesoException, SaldoInsuficienteCtaCteException {

		env.getVenta().getCliente().getCtaCte().abonar(cantAAbonar);
	}


}
