package envio;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import venta.Venta;
import exceptions.EnProcesoException;
import exceptions.SaldoInsuficienteCtaCteException;

public class EstadoEnvioTest {

	private Envio env;
	private Venta vent;
	private EstadoEnvio estadoDeEnv;
	private PendienteDeEnvio pendienteDeEnvio;
	private EnProceso enProg;
	
	@Before
	public void setUp() throws Exception {
	
		estadoDeEnv = mock(EstadoEnvio.class);
		enProg = mock(EnProceso.class);
		pendienteDeEnvio = mock(PendienteDeEnvio.class);
		env = mock(Envio.class);
		vent = mock(Venta.class);
		
	}
//// NOOoOOOooOOO
	
	@Test
	public void testEnviar() throws EnProcesoException, SaldoInsuficienteCtaCteException{
		

		assertTrue(true);
	}
	
	

}
