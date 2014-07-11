package envio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import venta.Venta;
import cliente.Cliente;
import cliente.CuentaCorriente;
import exceptions.SaldoInsuficienteCtaCteException;

public class EnProcesoTest {

	private EnProceso enProceso;
	private Envio envio;
	private Cliente cliente;
	private CuentaCorriente ctCt;
	private Venta venta;
	
	
	@Before
	public void setUp() throws Exception {
	
		enProceso = new EnProceso();
		envio = mock(Envio.class);
		envio.setEstado(enProceso);
		cliente =mock(Cliente.class);
		ctCt = mock(CuentaCorriente.class);
		venta = mock(Venta.class);
		
	}

	@Test
	public void  testEnviar() throws SaldoInsuficienteCtaCteException{
		// A cada uno de mis Mock's les asigno que devolver
		when(envio.getVenta()).thenReturn(venta);
		when(venta.getCliente()).thenReturn(cliente);
		when(cliente.getCtaCte()).thenReturn(ctCt);
		when(ctCt.saldo()).thenReturn(110d);
		
		// utilizo el metodo a testear 
		enProceso.enviar(envio, 1000d);
		
		//verifico que cada mock devolvi lo correcto
		verify(envio).getVenta();
		verify(venta).getCliente();
		verify(cliente).getCtaCte();
		verify(ctCt).abonar(1000d);
		
		
	}

}
