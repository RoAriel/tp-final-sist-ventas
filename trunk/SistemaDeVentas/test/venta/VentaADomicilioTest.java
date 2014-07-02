package venta;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;

import producto.Presentacion;
import cliente.Cliente;
import exceptions.StockInsuficienteException;

public class VentaADomicilioTest {

	public VentaADomicilio ventaAD;
	public Presentacion pre1;
    public Presentacion pre2;
    public Cliente cliente;
  
	@Before
	public void setUp() throws Exception {

		ventaAD = new VentaADomicilio(null, cliente);
	    pre1 = mock(Presentacion.class);
	    pre2 = mock(Presentacion.class);
	}

     @Test (expected = StockInsuficienteException.class)
     public void testVentaADomicilioSinStock() throws StockInsuficienteException{
   
          when(pre1.decrementarStock(3)).thenThrow(new StockInsuficienteException());
   
          ventaAD.agregarProducto(pre1,3);
          assertEquals(1, ventaAD.getProductosSinStock().size());
      }

}
