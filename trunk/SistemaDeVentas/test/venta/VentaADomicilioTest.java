package venta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import producto.Presentacion;
import cliente.Cliente;
import envio.Envio;
import exceptions.StockInsuficienteException;
import formaDePago.PagoConCuentaCorriente;

public class VentaADomicilioTest {

	public VentaADomicilio ventaAD;
	public Presentacion pre1;
    public Presentacion pre2;
    public Cliente cliente;
    public Envio envio;
  
	@Before
	public void setUp() throws Exception {

		ventaAD = new VentaADomicilio(null, cliente);
	    pre1 = mock(Presentacion.class);
	    pre2 = mock(Presentacion.class);
	    envio = mock(Envio.class);
	}

	@Test
	public void testConstructorSinParameros(){

		assertNotNull(ventaAD.getProductos());
		assertNotNull(ventaAD.getProductosSinStock());
		
		assertEquals(ventaAD.getEnvio(), envio);
		
		assertTrue(ventaAD.getFormaDePago().equals(new PagoConCuentaCorriente()));

	}
	
	
     @Test (expected = StockInsuficienteException.class)
     public void testVentaADomicilioSinStock() throws StockInsuficienteException{
   
  
          when(pre1.decrementarStock(3)).thenThrow(new StockInsuficienteException());
   
          ventaAD.agregarProducto(pre1,3);
          assertEquals(1, ventaAD.getProductosSinStock().size());
      }
     
     
	@Test 
	public void testSacarProductoDelPedidoSinStock(){
		
		ventaAD.agregarProductoSinStock(pre1, 1);
		ventaAD.sacarProductosDelLosPedidosSinStock(pre1, 1);
		assertTrue(ventaAD.getProductosSinStock().size() ==  0);
		
	}

	public void testPostergarEnvio(){

	}
}
