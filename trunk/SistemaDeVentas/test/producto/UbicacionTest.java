package producto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UbicacionTest {
	Ubicacion ubicacion;

	@Before
	public void setUp() throws Exception {
		this.ubicacion = new Ubicacion(2,5,4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void instanciamientoCorrecto() {
		assertEquals(2, ubicacion.pasillo());
		assertEquals(5, ubicacion.gondola());
		assertEquals(4, ubicacion.estante());
	}

}
