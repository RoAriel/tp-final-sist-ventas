package cliente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DireccionTest {

	Direccion direccion;
	
	@Before
	public void setUp() throws Exception {
		this.direccion = new Direccion("Falsa","123", "Planta Baja", "A");
	}
	
	@Test
	public void correctoInstanciamientoDeDepartamento(){
		assertEquals("Falsa",direccion.calle());
		assertEquals("123",direccion.numero());
		assertEquals("Planta Baja",direccion.piso());
		assertEquals("A",direccion.departamento());
	}
	

}
