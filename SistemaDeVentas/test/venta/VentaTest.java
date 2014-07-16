package venta;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import cliente.CuentaCorriente;
import exceptions.SaldoInsuficienteCtaCteException;
import formaDePago.FormaDePago;

public class VentaTest {

	private Cliente cliente;
	private FormaDePago fp;
	private Venta venta;
	private CuentaCorriente ctct;
	
	@Before
	public void setUp() throws Exception {
		
		ctct = mock(CuentaCorriente.class);
		venta = new Venta();
		fp= mock(FormaDePago.class);
		cliente = mock(Cliente.class);
		 
		
	}
	
	@Test
	public void esVentaADomicilio(){
		assertFalse(venta.esVentaADomicilio());
	}

	@Test (expected = SaldoInsuficienteCtaCteException.class)
	public void testCobrarConException() throws SaldoInsuficienteCtaCteException{

		when(venta.getFormaDePago()).thenReturn(fp);
		when(ctct.saldo()).thenReturn(0d);
		when(venta.subTotal()).thenReturn(10000d);
		doThrow(new SaldoInsuficienteCtaCteException()).when(fp).cobrar(cliente, venta.subTotal());
		
		venta.cobrar();
		
		
	
	
	}

}
