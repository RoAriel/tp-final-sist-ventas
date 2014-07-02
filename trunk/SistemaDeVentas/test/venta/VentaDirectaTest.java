package venta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import producto.Presentacion;
import cliente.Cliente;
import cliente.Direccion;
import exceptions.StockInsuficienteException;
import formaDePago.PagoEnEfectivo;

public class VentaDirectaTest {

	public VentaDirecta ventaD;
	public VentaDirecta ventaDCp;
	public Presentacion pre1;
    public Presentacion pre2;
    public Cliente cliente;
    public Direccion dir;
  
	@Before
	public void setUp() throws Exception {

		ventaD = new VentaDirecta();
		ventaDCp = new VentaDirecta(cliente);
	    pre1 = mock(Presentacion.class);
	    pre2 = mock(Presentacion.class);
	    cliente =mock(Cliente.class);
	    dir = mock(Direccion.class);
	}

	@Test
	public void testConstructorSinParameros(){

		assertNotNull(ventaD.getProductos());
		assertNotNull(ventaD.getProductosSinStock());
		
		assertTrue(ventaD.getFormaDePago().equals(new PagoEnEfectivo()));

	}
	
	@Test
	public void testConstructorConParameros(){

		assertNotNull(ventaDCp.getProductos());
		assertNotNull(ventaDCp.getProductosSinStock());
		assertTrue(ventaDCp.getCliente().equals(new Cliente()));
		
		assertTrue(ventaDCp.getFormaDePago().equals(new PagoEnEfectivo()));

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
