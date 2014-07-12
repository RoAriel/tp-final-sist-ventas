package sucursal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cliente.Cliente;
import producto.Presentacion;
import producto.Producto;
import venta.Venta;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class SucursalTest {

	Sucursal sucursal;
	List<Presentacion> lp;
	Map<Cliente, List<Venta>> reg;
	Cliente cliente1 = mock(Cliente.class);
	Cliente cliente2 = mock(Cliente.class);
	Venta venta1 = mock(Venta.class);
	Venta venta2 = mock(Venta.class);
	Producto prod1;
	Presentacion pre1 = mock(Presentacion.class);
	Presentacion pre2 = mock(Presentacion.class);
	DateTime fecha1;
	DateTime fecha2;
	DateTime fecha3;
	DateTime fecha4;
	

	@Before
	public void SetUp() {
		
		prod1 = mock(Producto.class);
		List<Presentacion> presentacionesList = new ArrayList<Presentacion>();
		presentacionesList.add(pre1);
		presentacionesList.add(pre2);
		List<Producto> productoList = new ArrayList<Producto>();
		productoList.add(prod1);
		when(prod1.presentaciones()).thenReturn(presentacionesList);
		lp = new ArrayList<Presentacion>();
		reg = new HashMap<Cliente, List<Venta>>();
		sucursal = new Sucursal(productoList, reg);
		fecha1 = new DateTime(2014, 6, 1, 6, 1);
		fecha2 = new DateTime(2014, 6, 3, 6, 1);
		fecha3 = new DateTime(2014, 6, 5, 6, 1);
		fecha4 = new DateTime(2014, 6, 7, 6, 1);
		
	}

	@Test
	public void registrarVenta() {
		// Cuando a una sucursal sin venta, se le registra una veta entonces
		// pasa a tener una nueva venta
		sucursal.registrarVenta(cliente1, venta1);
		// Se encuentra el cliente en las ventas
		assertTrue(sucursal.getRegistroVenta().containsKey(cliente1));
		// El cliente tiene una sola venta asociada.
		assertEquals(1, sucursal.getRegistroVenta().get(cliente1).size());

		// Cuando se le agrega una nueva venta pasa a tener 2
		sucursal.registrarVenta(cliente1, venta2);
		assertEquals(2, sucursal.getRegistroVenta().get(cliente1).size());
	}

	@Test
	public void ventasDesdeHasta() {
		when(venta1.subTotal()).thenReturn(10.0);
		when(venta2.subTotal()).thenReturn(20.0);
		sucursal.registrarVenta(cliente1, venta1);
		sucursal.registrarVenta(cliente1, venta2);

		// Cuando pido las ventas desde 21.0 hasta 33.0 entonces me da una lista
		// de ventas vacia
		List<Venta> lista = sucursal.ventasDesdeHastaMonto(21.0, 33.0, cliente1);
		assertEquals(0, lista.size());
		// Cuando pido las ventas desde 5.0 hasta 11.0 me da una lista de ventas
		// con una sola venta.
		lista = sucursal.ventasDesdeHastaMonto(5.0, 11.0, cliente1);
		assertEquals(1, lista.size());
		assertTrue(lista.contains(venta1));
		// Cuando pido las ventas desde 5.0 hasta 21.0 entonces me da una lista
		// de
		// 2 ventas.
		lista = sucursal.ventasDesdeHastaMonto(5.0, 21.0, cliente1);
		assertEquals(2, lista.size());
		assertTrue(lista.contains(venta1));
		assertTrue(lista.contains(venta2));

		// Cuendo pido las ventas desde 12.0 hasta 22.0 entonces me da una lista
		// solamente con la venta 2
		lista = sucursal.ventasDesdeHastaMonto(12.0, 22.0, cliente1);
		assertEquals(1, lista.size());
		assertTrue(lista.contains(venta2));
	}
	
	@Test
	public void ventasDesdeHastaFecha(){
		/**
		 * fecha1 = 1/6/2014
		 * fecha2 = 3/6/2014
		 * fecha3 = 5/6/2014
		 * fecha4 = 7/6/2014
		 */
		when(venta1.getFechaDeSolicitudDeCompra()).thenReturn(new DateTime(2014, 6, 2, 6, 1));
		when(venta2.getFechaDeSolicitudDeCompra()).thenReturn(new DateTime(2014, 6, 6, 6, 1));		
		sucursal.registrarVenta(cliente1, venta1);
		sucursal.registrarVenta(cliente1, venta2);
		
		List<Venta> lista = sucursal.ventaDesdeHastaFecha(fecha2, fecha3, cliente1);
		assertEquals(0, lista.size());
		
		
		// Cuando pido las ventas desde 1/6/2015 hasta 3/6/2014 me da una lista de ventas
		// con una sola venta.
		lista = sucursal.ventaDesdeHastaFecha(fecha1, fecha2, cliente1);
		assertEquals(1, lista.size());
		assertTrue(lista.contains(venta1));
		
		
		// Cuando pido las ventas desde 1/6/2014 hasta 7/6/2014 entonces me da una lista
		// de
		// 2 ventas.
		lista = sucursal.ventaDesdeHastaFecha(fecha1, fecha4, cliente1);
		assertEquals(2, lista.size());
		assertTrue(lista.contains(venta1));
		assertTrue(lista.contains(venta2));

		
		// Cuendo pido las ventas desde 5/6/2014 hasta 7/6/2014 entonces me da una lista
		// solamente con la venta 2
		lista = sucursal.ventaDesdeHastaFecha(fecha3, fecha4, cliente1);
		assertEquals(1, lista.size());
		assertTrue(lista.contains(venta2));


	}

	@Test
	public void agregarPresentacion(){
		Presentacion pre3 = mock(Presentacion.class);
		sucursal.agregarPresentacion(prod1, pre3);
		verify(prod1, times(1)).agregarPresentacion(pre3);
	}
	
	@Test
	public void prodructosPorDebajoDelStockMinimo(){
		
		when(pre1.stockMinimo()).thenReturn(10);
		when(pre1.stock()).thenReturn(11);
		when(pre2.stockMinimo()).thenReturn(10);
		when(pre2.stock()).thenReturn(9);
		assertEquals(1, sucursal.productosPorDebajoDeStockMinimo().size());
	}
	
	@Test
	public void productosPorDebajoDelStockCritico(){
		when(pre1.stockMinimo()).thenReturn(6);
		when(pre1.stock()).thenReturn(11);
		when(pre2.stockCritico()).thenReturn(4);
		when(pre2.stock()).thenReturn(1);
		assertEquals(1, sucursal.productosPorDebajoDeStockCritico().size());
	}
	

	
	
	
}
