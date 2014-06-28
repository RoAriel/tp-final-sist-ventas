package producto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlertaStockTest {
	AlertaStock alerta;
	Pedido pedido;
	@Before
	public void setUp() throws Exception {
		this.alerta = new AlertaStock();
		this.pedido = mock(Pedido.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void correctoInstanciamientoDeLaClase() {
		assertEquals(0,alerta.pedidos().size());
	}
	
	@Test
	public void agregarPedido(){
		alerta.agregarPedido(pedido);
		assertEquals(1,alerta.pedidos().size());
		assertTrue(alerta.pedidos().contains(pedido));
	}
	
	@Test
	public void quitarPedido(){
		alerta.agregarPedido(pedido);
		alerta.quitarPedido(pedido);
		assertEquals(0, alerta.pedidos().size());
	}
	
	@Test
	public void notificarAPedidos(){
		Presentacion presentacion = mock(Presentacion.class);
		alerta.agregarPedido(pedido);
		alerta.update(presentacion, 30);
		verify(pedido,times(1)).update(alerta,presentacion);
	}

}
