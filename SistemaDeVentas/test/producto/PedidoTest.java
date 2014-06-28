package producto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;

public class PedidoTest {
	Pedido pedido;
	Cliente cliente;
	Presentacion p1;
	Presentacion p2;
	Presentacion p3;

	@Before
	public void setUp() throws Exception {
		this.cliente = mock(Cliente.class);
		this.pedido = new Pedido(cliente);
		this.p1 = mock(Presentacion.class);
		this.p2 = mock(Presentacion.class);
		this.p3 = mock(Presentacion.class);
		when(p1.stock()).thenReturn(200);
		when(p2.stock()).thenReturn(200);
		when(p3.stock()).thenReturn(200);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void agregarPresentacion() {
		// Cuando a un pedido sin presentaciones cargadas le agrego una,
		// entonces tiene una unidad de la presentacion.
		pedido.agregarPresentacion(p1, 1);
		assertEquals((Integer) 1, pedido.getPresentaciones().get(p1));
		// Cuando agrego otra presentacion distinta tiene que haber 2
		// presentaciones.
		pedido.agregarPresentacion(p2, 1);
		assertEquals((Integer) 2, (Integer) pedido.getPresentaciones().size());
	}

	@Test
	public void quitarPresentacion() {
		// Cuando le digo al pedido que quite una presentacion, la quita.
		pedido.agregarPresentacion(p1, 4);
		pedido.agregarPresentacion(p2, 1);
		pedido.quitarPresentacion(p1);
		assertEquals((Integer) 1, (Integer) pedido.getPresentaciones().size());
	}

	@Test
	public void updatePedido() {
		
		// Cuando la presentacion no se encuentra en el pedido.
		pedido.agregarPresentacion(p1, 150);
		pedido.agregarPresentacion(p2, 40);
		pedido.update(p3, 199);
		String mensajeQueTieneQueMandar = "Su pedido se encuentra en stock.";
		verify(cliente,times(0)).notificacion(mensajeQueTieneQueMandar);
		
		// Cuando falta stock de una presentacion no se notifica al cliente
		pedido.agregarPresentacion(p3, 201);
		pedido.update(p3, 199);
		verify(cliente,times(0)).notificacion(mensajeQueTieneQueMandar);
		
		// Cuando a un pedido le llega el mensaje update y se satisface el
		// stock, entonces se le embia al cliente la notificacion
		pedido.agregarPresentacion(p3, 199);
		pedido.update(p3, 199);
		verify(cliente,times(1)).notificacion(mensajeQueTieneQueMandar);
		

	}
}
