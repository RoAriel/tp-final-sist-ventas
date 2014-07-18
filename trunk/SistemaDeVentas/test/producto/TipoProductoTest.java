package producto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TipoProductoTest {
	TipoProducto tipo;
	@Before
	public void setUp() throws Exception {
		tipo = new TipoProducto("Tecnologia");
	}

	@Test
	public void correctoInstanciamiento() {
		assertEquals(tipo.getTipo(),"Tecnologia");
	}

}
