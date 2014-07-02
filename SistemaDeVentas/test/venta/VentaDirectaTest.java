package venta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import producto.Presentacion;
import cliente.Cliente;
import exceptions.StockInsuficienteException;
import formaDePago.PagoEnEfectivo;

public class VentaDirectaTest {

	public VentaDirecta ventaD;
	public Presentacion pre1;
    public Presentacion pre2;
    public Cliente cliente;
  
	@Before
	public void setUp() throws Exception {

		ventaD = new VentaDirecta();
	    pre1 = mock(Presentacion.class);
	    pre2 = mock(Presentacion.class);
	}

	@Test
	public void testConstructorSinParameros(){

		assertNotNull(ventaD.getProductos());
		assertNotNull(ventaD.getProductosSinStock());
		
		assertTrue(ventaD.getFormaDePago().equals(new PagoEnEfectivo()));

	}

	
	@Test
	public void testAgregarProducto() throws StockInsuficienteException{

	    ventaD.agregarProducto(pre1, 1);
	     assertEquals(1, ventaD.getProductos().size());
	}


	 @Test
	 public void sacarProductoUnico() throws StockInsuficienteException{

	    ventaD.agregarProducto(pre1, 1);
	    ventaD.sacarProducto(pre1, 1);
	    assertEquals(0, ventaD.getProductos().size());
	 }
	 
	 @Test
     public void testSacarProductoMultiple() throws StockInsuficienteException{

	    ventaD.agregarProducto(pre1, 6);
	    ventaD.agregarProducto(pre2, 10);
	    ventaD.sacarProducto(pre1, 2);
	    assertEquals(14, ventaD.getProductos().size());
	 }

	 @Test
	 public void testSubTotal() throws StockInsuficienteException{
		 
		 Double param1 = (double)4;
		 Double param2 = (double)6;
		when(pre1.getPrecioDeVentaActual()).thenReturn(param1);
	    when(pre2.getPrecioDeVentaActual()).thenReturn(param2);

	    ventaD.agregarProducto(pre1, 1);
	    ventaD.agregarProducto(pre2, 1);
	    assertEquals((double)10, ventaD.subTotal(),0);
	 }

}
