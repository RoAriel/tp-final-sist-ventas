package envio;


import exceptions.SaldoInsuficienteCtaCteException;

public class EnProceso extends EstadoEnvio {

	

/**
 * Envia estado Cancelar el msj enviar 
 * @param env es un envio que es el mismos que envia el mensaje
 * @param cantAAbonar que es un nonto que tiene que abonar el cliente en su domicilio 
 * 
 */
	@Override
	public void enviar(Envio env, double cantAAbonar) throws SaldoInsuficienteCtaCteException {

		env.getVenta().getCliente().getCtaCte().abonar(cantAAbonar);
	}


}
