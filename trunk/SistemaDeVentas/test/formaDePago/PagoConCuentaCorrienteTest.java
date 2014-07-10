package formaDePago;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import producto.Presentacion;
import venta.VentaADomicilio;
import cliente.Cliente;
import cliente.CuentaCorriente;
import exceptions.SaldoInsuficienteCtaCteException;

public class PagoConCuentaCorrienteTest {


	public PagoConCuentaCorriente pCtaCte;
	public PagoConCuentaCorriente pCtaCte2;
	public Cliente cliente;
	public VentaADomicilio venta;
	public DateTime fecha;
	public CuentaCorriente cTaCte;
	public Presentacion pre1;
	
	@Before
	public void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		cTaCte= mock(CuentaCorriente.class); 
		pCtaCte = new PagoConCuentaCorriente();
		pCtaCte2 = new PagoConCuentaCorriente();
	}
	
	@Test (expected = SaldoInsuficienteCtaCteException.class)
	public void testCobrarConException() throws SaldoInsuficienteCtaCteException{
		
		when(cliente.getCtaCte()).thenReturn(cTaCte);
		doThrow(new SaldoInsuficienteCtaCteException()).when(cTaCte).abonar(1000d);
		
		pCtaCte.cobrar(cliente, 1000d);
	
		verify(cliente).getCtaCte();
		verify(cTaCte).abonar(1000d);
	}
	
	@Test
	public void testCobrarSimple() throws SaldoInsuficienteCtaCteException{
		
		when(cliente.getCtaCte()).thenReturn(cTaCte);
		
		pCtaCte.cobrar(cliente, 1000d);
	
		verify(cliente).getCtaCte();
		verify(cTaCte).abonar(1000d);
	}
	
	
	@Test
	public void testEquals(){
		
		assertTrue(pCtaCte.equals(pCtaCte));
		assertTrue(pCtaCte.equals(pCtaCte2));
		assertFalse(pCtaCte.equals(null));
		assertFalse(pCtaCte.equals(10d));
		
	}
	
}
