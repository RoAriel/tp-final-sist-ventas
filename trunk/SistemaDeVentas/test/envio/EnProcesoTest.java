package envio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import cliente.CuentaCorriente;

public class EnProcesoTest {

	private EnProceso enProceso;
	private Envio envio;
	private Cliente cliente;
	private CuentaCorriente ctCt;
	
	
	@Before
	public void setUp() throws Exception {
	
		enProceso = new EnProceso();
		envio = mock(Envio.class);
		envio.setEstado(enProceso);
		cliente =mock(Cliente.class);
		ctCt = mock(CuentaCorriente.class);
		
	}

	@Test
	public void  testEnviar(){
		
		assertTrue(true);
		
		
		
	}

}
