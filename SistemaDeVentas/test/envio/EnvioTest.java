package envio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import venta.Venta;
import cliente.Cliente;
import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;
import exceptions.SaldoInsuficienteCtaCteException;

public class EnvioTest {

	private Envio env;
	private EstadoEnvio estEnv;
	private double monto;

	private DateTime fecha;
	private Venta venta;
	private Cliente cliente;

	@Before
	public void setUp() throws Exception {

		fecha = new DateTime();
		venta = mock(Venta.class);
		cliente = mock(Cliente.class);
		estEnv = mock(EstadoEnvio.class);
		env = new Envio(cliente, venta, fecha);
		env.setEstado(estEnv);
		monto = 10d;
	}

	//Simplemente verifico la llegada del mensaje
	@Test
	public void testEnviarSeEjecuta() throws EnProcesoException,
			SaldoInsuficienteCtaCteException {
		env.enviar(monto);
		verify(estEnv).enviar(env, monto);

	}
	
	//Simplemente verifico la llegada del mensaje
	@Test
	public void testCancelarSinException() throws CanceladoException{
		env.cancelar();
		verify(estEnv).cancelar(env);
		
	}

	//Testeo que se lanzo la exception
	@Test (expected = CanceladoException.class)
	public void testCanclarConException() throws CanceladoException{
	
		Cancelado envCancel = mock(Cancelado.class);
		env.setEstado(envCancel);
		doThrow(new CanceladoException()).when(envCancel).cancelar(env);
		env.cancelar();
		
	}
	
	@Test
	public void testReprogramarSinExcepion() throws ReprogramadoException{
		
		env.reprogramar(fecha);
		verify(estEnv).reprogramar(env, fecha);
	}
	
	@Test (expected = ReprogramadoException.class)
	public void testReprogramadoConException() throws ReprogramadoException{
		
		Reprogramado envRepro = mock(Reprogramado.class);
		env.setEstado(envRepro);
		// utilizo el doThrow para poder testear un metodo void
		doThrow(new ReprogramadoException()).when(envRepro).reprogramar(env, fecha);
		env.reprogramar(fecha);
	}

	@Test
	public void testEquals() {
		Envio env2 = new Envio(mock(Cliente.class), mock(Venta.class),
				new DateTime());
		assertTrue(env.equals(env));
		assertTrue(env.equals(env2));
		assertFalse(env.equals(null));
		assertFalse(env.equals(10d));

	}

}
