package envio;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import exceptions.ReprogramadoException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import venta.Venta;

public class ReprogramadoTest {

	private Envio env;
	private Reprogramado repro;
	private Venta vent;
	private DateTime fecha;
	
	
	@Before
	public void setUp() throws Exception {
		
		env = mock(Envio.class);
		repro = new Reprogramado();
		vent = mock(Venta.class);
		fecha = new DateTime(2014, 7, 11, 12, 0);
	}

	@Test
	public void testReprogramar() throws ReprogramadoException {
	
		DateTime f2 = new DateTime(2014, 7, 11, 12, 30);
			
		when(env.getVenta()).thenReturn(vent);
		when(env.getFechaEnvio()).thenReturn(fecha);
		
		repro.reprogramar(env, fecha);
		
		verify(env).getVenta();
		verify(vent).devolverCompra();
		
		assertNotEquals(env.getFechaEnvio(), f2);

	}
}
