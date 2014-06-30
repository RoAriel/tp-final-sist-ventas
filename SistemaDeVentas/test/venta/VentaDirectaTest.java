package venta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

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

		Cliente cliente = mock(Cliente.class);
		ventaD = new VentaDirecta();
	    pre1 = mock(Presentacion.class);
	    pre2 = mock(Presentacion.class);
	}

	@Test
	public void testConstructorSinParameros(){

		assertNotNull(ventaD.getProductos());
		assertNotNull(ventaD.getProductosSinStock());
		
		assertEquals(ventaD.getFormaDePago() , PagoEnEfectivo.class);

	}

	
	@Test
	public void testAgregarProducto() throws StockInsuficienteException{

	    ventaD.agregarProducto(pre1, 1);
	     assertEquals(1, ventaD.getProductos().size());
	}


	    /**
	    *  @throws StockInsuficienteException 
	     * @Test (expected = StockInsuficienteException.class)
	    *  public void testVentaADomicilioSinStock() throws StockInsuficienteException{
	    *
	    *       when(pre.decrementarStock(3)).thenThrow(StockInsuficienteException.class);
	    *
	    *       ventaD.agregarProducto(pre1,3);
	    *       assertEquals(1, ventaD.getProductosSinStock().size());
	    *   }
	    **/

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
	 public void testSubTotal(){

	    When(pre1.getPrecioDeVentaActual()).theReturn((double)4);
	    When(pre2.getPrecioDeVentaActual()).theReturn((double)6);

	    assertEquals((double)10, ventaD.subTotal(),0);
	 }

}
