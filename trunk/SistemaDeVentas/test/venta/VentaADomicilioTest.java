package venta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import producto.Presentacion;
import cliente.Cliente;
import envio.Envio;
import exceptions.StockInsuficienteException;
import formaDePago.FormaDePago;


public class VentaADomicilioTest {

	public VentaADomicilio ventaAD;
	public Presentacion pre1;
    public Presentacion pre2;
    public Cliente cliente;
    public Envio envio;
    public DateTime fch;
    public FormaDePago fp;
    
	@Before
	public void setUp() throws Exception {

		fch = new DateTime();
		fp = mock(FormaDePago.class);
		cliente = mock(Cliente.class);
		ventaAD = new VentaADomicilio(fch,cliente, fp);
	    pre1 = mock(Presentacion.class);
	    pre2 = mock(Presentacion.class);
	    envio = mock(Envio.class);
	    
	    
	}

	@Test
	public void testConstructorSinParameros(){

		assertNotNull(ventaAD.getProductos());
		assertNotNull(ventaAD.getProductosSinStock());
		
		assertTrue(ventaAD.getFormaDePago().equals(fp));

	}
	
	
     @Test 
     public void testVentaADomicilioSinStock() throws StockInsuficienteException{
           
          doThrow(new StockInsuficienteException()).when(pre1).decrementarStock(3);
          ventaAD.agregarProducto(pre1,3);
          assertEquals(3, ventaAD.getProductosSinStock().size());
      }
     
     
	@Test 
	public void testSacarProductoDelPedidoSinStock(){
		
		ventaAD.agregarProductoSinStock(pre1, 1);
		ventaAD.sacarProductosDelLosPedidosSinStock(pre1, 1);
		assertEquals(ventaAD.getProductosSinStock().size(), 0);
		
	}

}
