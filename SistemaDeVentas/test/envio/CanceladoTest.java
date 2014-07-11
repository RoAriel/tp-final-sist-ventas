package envio;

import static org.mockito.Mockito.mock;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;
public class CanceladoTest {

	private Cancelado cancelado;
	private Envio mockEnvio;
	private double monto;
	private DateTime fecha;
	
	@Before
	public void setUp(){
		
		cancelado = new Cancelado();
		monto = 10d;
		fecha = new DateTime();
		mockEnvio = mock(Envio.class);
		
	}
	
	//Testeo que lanzo la exception
	@Test(expected = CanceladoException.class)
	public void testCancelar() throws CanceladoException {
		
		cancelado.cancelar(mockEnvio);

	}
	
	//Testeo que lanzo la exception
	@Test(expected = EnProcesoException.class)
	public void testEnviar() throws EnProcesoException {
		
		cancelado.enviar(mockEnvio, monto );

	}
	
	//Testeo que lanzo la exception
	@Test(expected = ReprogramadoException.class)
	public void testReprogramar() throws ReprogramadoException {
		
		cancelado.reprogramar(mockEnvio, fecha);

	}
	

}
