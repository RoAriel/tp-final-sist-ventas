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
import formaDePago.FormaDePago;
import formaDePago.PagoEnEfectivo;

public class VentaDirectaTest {

	public VentaDirecta ventaD;
	public VentaDirecta ventaDCp;
	public Presentacion pre1;
    public Presentacion pre2;
    public Cliente cliente;
    public Direccion dir;
    public PagoEnEfectivo pagoEnEfectivo;
    public FormaDePago fp;
  
	@Before
	public void setUp() throws Exception {

		ventaD = new VentaDirecta();
		
	    pre1 = mock(Presentacion.class);
	    pre2 = mock(Presentacion.class);
	    cliente =mock(Cliente.class);
	    dir = mock(Direccion.class);
	    fp = mock(FormaDePago.class);
	    ventaDCp = new VentaDirecta(cliente, fp);
	    pagoEnEfectivo = mock(PagoEnEfectivo.class);
	}

	@Test
	public void testConstructorSinParameros(){

		assertNotNull(ventaD.getProductos());
		assertNotNull(ventaD.getProductosSinStock());
		
		assertEquals(ventaD.getFormaDePago(),new PagoEnEfectivo());


	}
	
	@Test
	public void testConstructorConParameros(){

		assertNotNull(ventaDCp.getProductos());
		assertNotNull(ventaDCp.getProductosSinStock());
		assertTrue(ventaDCp.getCliente().equals(cliente));
		
		assertEquals(ventaDCp.getFormaDePago(),fp);

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
	 
	 @Test
	 public void testDevolverCompra() throws StockInsuficienteException{
		 
		 ventaD.agregarProducto(pre1, 1);
		 ventaD.devolverCompra();
		 assertEquals(ventaD.getProductos().size(), 0);
	 }

	 
}
