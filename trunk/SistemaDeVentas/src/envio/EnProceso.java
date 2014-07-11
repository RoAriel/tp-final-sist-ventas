package envio;


import exceptions.SaldoInsuficienteCtaCteException;

public class EnProceso extends EstadoEnvio {

	@Override
	public void enviar(Envio env, double cantAAbonar) throws SaldoInsuficienteCtaCteException {

		env.getVenta().getCliente().getCtaCte().abonar(cantAAbonar);
	}


}
