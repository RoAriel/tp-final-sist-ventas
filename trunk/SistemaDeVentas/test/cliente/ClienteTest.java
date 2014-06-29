package cliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import producto.Presentacion;

public class ClienteTest {
	Cliente cliente;
	
	@Before
	public void setUp() throws Exception {
		this.cliente= new Cliente("Pepe", "Fernandez",20123789,mock(Direccion.class));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void correctoInstanciamientoDeLaClase() {
		assertEquals("Pepe",cliente.nombre());
		assertEquals("Fernandez",cliente.apellido());
		assertEquals((Integer)20123789,cliente.dni());
		assertNotNull(cliente.direccion());
	}
	
	@Test
	public void devolverProducto(){
		Presentacion p1 = mock(Presentacion.class);
		when(p1.precioDeVenta()).thenReturn(123d);
		cliente.devolverProducto(p1);
		// COMO VERIFICO QUE SE AGREGA EL SALDO
		assertEquals((Double)123d,cliente.getCtaCte().saldo());
	}

}
