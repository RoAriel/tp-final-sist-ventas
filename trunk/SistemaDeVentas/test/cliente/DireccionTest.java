package cliente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DireccionTest {
	Direccion direccionCasa;
	Direccion direccionDepartamento;
	
	@Before
	public void setUp() throws Exception {
		this.direccionCasa = new Direccion("Falsa","123");
		this.direccionDepartamento = new Direccion("Falsa","123", "Planta Baja", "A");
	}

	@Test
	public void correctoInstanciamientoDeCasa() {
		assertEquals("Falsa",direccionCasa.calle());
		assertEquals("123",direccionCasa.numero());
		assertEquals(" ",direccionCasa.piso());
		assertEquals(" ",direccionCasa.departamento());		
	}
	
	@Test
	public void correctoInstanciamientoDeDepartamento(){
		assertEquals("Falsa",direccionDepartamento.calle());
		assertEquals("123",direccionDepartamento.numero());
		assertEquals("Planta Baja",direccionDepartamento.piso());
		assertEquals("A",direccionDepartamento.departamento());
	}
	

}
