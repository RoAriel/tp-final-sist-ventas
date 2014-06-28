package producto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ProductoTest {
	Producto producto;
	
	@Before
	public void setUp() throws Exception {
		this.producto= new Producto("Pepitos", "Arcor", "Galletitas para todas las edades."); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void correctoInstanciamientoDeLaClase() {
		assertEquals("Pepitos", producto.nombre());
		assertEquals("Arcor", producto.marca());
		assertEquals("Galletitas para todas las edades.", producto.descripcion());
		assertEquals(0, producto.presentaciones().size());
	}
	
	@Test
	public void agregoUnaPresentacionAlProducto(){
		producto.agregarPresentacion(mock(Presentacion.class));
		assertEquals(1, producto.presentaciones().size());
	}
	
	@Test
	public void quitarPresentacion(){
		Presentacion p = mock(Presentacion.class);
		producto.agregarPresentacion(p);
		producto.quitarPresentacion(p);
		assertEquals(0,producto.presentaciones().size());
	}

}
