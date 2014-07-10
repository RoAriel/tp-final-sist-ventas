package envio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;

import exceptions.EnProcesoException;
import exceptions.SaldoInsuficienteCtaCteException;

public class EnvioTest {

	private Envio env;
	private Envio env2;
	private Envio mockEnv;
	private EstadoEnvio estEnv;
	private double monto;
	
	@Before
	public void setUp() throws Exception {
		
		env = new Envio();
		env2 = new Envio();
		mockEnv = mock(Envio.class);
		estEnv = mock(EstadoEnvio.class);
		monto = 10d;
	}

	@Test 
	public void testEnviarRecibeElGetEstado(){
		
		when(mockEnv.getEstado()).thenReturn(estEnv);
		mockEnv.getEstado();
		verify(mockEnv).getEstado();
	}
	
	@Test 
	public void testEnviarElEstadoRecibeElEnviar() throws EnProcesoException, SaldoInsuficienteCtaCteException{
		
		estEnv.enviar(env, monto);	
		verify(estEnv).enviar(env, monto);
		
	}
	
	@Test 
	public void testEnviar() throws EnProcesoException, SaldoInsuficienteCtaCteException{
		

	}
	
	@Test
	public void testEquals(){
		
		assertTrue(env.equals(env));
		assertTrue(env.equals(env2));
		assertFalse(env.equals(null));
		assertFalse(env.equals(10d));
		
	}

}
