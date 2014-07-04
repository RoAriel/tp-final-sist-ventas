package formaDePago;

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
	public Cliente cliente;
	public VentaADomicilio venta;
	public DateTime fecha;
	public CuentaCorriente cTaCte;
	public Presentacion pre1;
	
	@Before
	public void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		pagoEfectivo = new PagoEnEfectivo();
		
	}
	
	@Test
	public void testCobrar(){
		
		pagoEfectivo.cobrar(cliente, 100d);
		verify(cliente).pagar(100d);
	}

}
