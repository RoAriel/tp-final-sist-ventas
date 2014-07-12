package producto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnidadDeMedidaTest {
	UnidadDeMedida unidadMedida;
	@Before
	public void setUp() throws Exception {
		unidadMedida = new UnidadDeMedida("Litro", 4d);
	}

	@Test
	public void instanciamientoCorrecto() {
		assertEquals("Litro", unidadMedida.getTipo());
		assertEquals((Double)4d,unidadMedida.cantidad());
		assertEquals("Presentacion en Litro. Cantidad: 4.0",unidadMedida.tipoDeUnidadYCantidad());
	}

}
