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
	// Creo una fecha para comparar luego
		DateTime f2 = new DateTime(2014, 7, 11, 12, 30);
		
		// A los mocks digo que devolver en cada metodo
		when(env.getVenta()).thenReturn(vent);
		when(env.getFechaEnvio()).thenReturn(fecha);
		
		//Utilizo el metodo reprogramar(env, fecha)
		repro.reprogramar(env, fecha);
		
		//verifico las llamadas de los metodos
		verify(env).getVenta();
		verify(vent).devolverCompra();
		
		//Verifico que el metodo reprogramar haya cambiado la fecha efectivamente
		assertNotEquals(env.getFechaEnvio(), f2);

	}
}
