package formaDePago;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import producto.Presentacion;
import venta.VentaADomicilio;
import cliente.Cliente;
import cliente.CuentaCorriente;

public class PagoEnEfectivoTest {

	

	public PagoEnEfectivo pagoEfectivo;
	public PagoEnEfectivo pagoEfectivo2;
	public Cliente cliente;
	public VentaADomicilio venta;
	public DateTime fecha;
	public CuentaCorriente cTaCte;
	public Presentacion pre1;
	
	@Before
	public void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		pagoEfectivo = new PagoEnEfectivo();
		pagoEfectivo2 = new PagoEnEfectivo();
		
	}
	
	@Test
	public void testCobrar(){
		
		pagoEfectivo.cobrar(cliente, 100d);
		verify(cliente).pagar(100d);
	}
	
	@Test
	public void testEquals(){
		
		assertTrue(pagoEfectivo.equals(pagoEfectivo));
		assertTrue(pagoEfectivo.equals(pagoEfectivo2));
		assertFalse(pagoEfectivo.equals(null));
		assertFalse(pagoEfectivo.equals(10d));
		
	}

}
