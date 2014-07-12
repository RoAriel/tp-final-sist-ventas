package ofertas;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import producto.Presentacion;

public class ProductoEnOfertaTest {
	ProductoEnOferta oferta;
	Presentacion presentacion;
	Double porcentajeDescuento;
	
	@Before
	public void setUp() throws Exception {
		presentacion = mock(Presentacion.class);
		when(presentacion.precioDeVenta()).thenReturn(100d);
		porcentajeDescuento = 15d;
		oferta = new ProductoEnOferta(presentacion, porcentajeDescuento); 
	}

	@Test
	public void precioNormal() {
		assertEquals((Double)100d,oferta.precioNormal());
	}
	
	@Test
	public void precioOferta(){
		//Cuando a un producto de 100d se le aplica un descuento del 15% tiene que costar 85d;
		assertEquals((Double)85d,oferta.precioOferta());
	}

}
