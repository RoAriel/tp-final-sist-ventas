package venta;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import exceptions.SaldoInsuficienteCtaCteException;
import formaDePago.FormaDePago;

public class VentaTest {

	private Cliente cliente;
	private FormaDePago fp;
	private Venta venta;
	
	@Before
	public void setUp() throws Exception {
		
		venta = mock(Venta.class);
		fp= mock(FormaDePago.class);
		cliente = mock(Cliente.class);
		 
		
	}

	@Test (expected = SaldoInsuficienteCtaCteException.class)
	public void testCobrarConException() throws SaldoInsuficienteCtaCteException{

		when(venta.subTotal()).thenReturn(100d);
		doThrow(new SaldoInsuficienteCtaCteException()).when(fp).cobrar(cliente, venta.subTotal());
		venta.cobrar();
		
	}

}
