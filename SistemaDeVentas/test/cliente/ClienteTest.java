package cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import producto.Presentacion;

public class ClienteTest {
	Cliente cliente;

	@Before
	public void setUp() throws Exception {
		this.cliente = new Cliente("Pepe", "Fernandez", "20123789",
				mock(Direccion.class));
	}

	@Test
	public void correctoInstanciamientoDeLaClase() {
		assertEquals("Pepe", cliente.nombre());
		assertEquals("Fernandez", cliente.apellido());
		assertEquals("20123789", cliente.dni());
		assertNotNull(cliente.direccion());
	}

	@Test
	public void devolverProducto() {
		Presentacion p1 = mock(Presentacion.class);
		when(p1.precioDeVenta()).thenReturn(123d);
		cliente.devolverProducto(p1);
		assertEquals((Double) 123d, cliente.getCtaCte().saldo());
	}

	@Test
	public void equals() {
		Cliente cli2 = new Cliente("Pepe", "Fernandez", "20123789",
				mock(Direccion.class));
		assertTrue(cliente.equals(cliente));
		assertTrue(cliente.equals(cli2));
		assertFalse(cliente.equals(null));
		assertFalse(cliente.equals(10d));

	}

	@Test
	public void cambiarDireccion() {
		// DA MAL EL SETER
		Direccion nueva = new Direccion("1","123","1","A");
		cliente.cambiarDireccion(nueva);
		assertEquals(nueva, cliente.direccion());
	}

	@Test
	public void notificacion() {
		cliente.notificacion("Hola. Disfruta tu dia!");
		// como testeo que se imprime en pantalla?
	}
	
	@Test
	public void pagar(){
		cliente.pagar(100d);
		// como testeo que se imprime en pantalla?
	}
	
	
}
