package producto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.StockInsuficienteException;

public class presentacionTest {
	Presentacion presentacion;
	DateTime fechaDeHoy;


	@Before
	public void setUp() throws Exception {
		this.presentacion = new Presentacion("123456789", mock(UnidadDeMedida.class),
				200, 50, 25, 10d, 9d, mock(Ubicacion.class));

		DateTime t = new DateTime();
		this.fechaDeHoy = new DateTime(t.getYear(), t.getMonthOfYear(),
				t.getDayOfMonth(), 0, 0, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void correctoInstanciamientoDeClase() {
		assertEquals("123456789", presentacion.codigoDeBarras());
		assertNotNull(presentacion.unidadDeMedida());
		//assertNotNull(presentacion.getStock());
		assertNotNull(presentacion.ubicacion());
		assertEquals((Double) 10d, presentacion.precioDeVenta());
		assertEquals((Double) 9d, presentacion.precioDeCompra());
	}

	@Test
	public void cambioPrecioPrecioDeCompra() {
		presentacion.nuevoPrecioCompra(10d);
		assertEquals((Double) 10d, presentacion.precioDeCompra());
		assertTrue(presentacion.historialDePreciosCompra().containsKey(
				fechaDeHoy));
	}

	@Test
	public void cambioPrecioPrecioDeVenta() {
		presentacion.nuevoPrecioVenta(11d);
		assertTrue(presentacion.historialDePrecios().containsKey(fechaDeHoy));
		assertEquals((Double) 11d, presentacion.precioDeVenta());
	}
	
	@Test
	public void corroboroDatosDeStock(){
		assertEquals(200,presentacion.stock());
		assertEquals(50,presentacion.stockMinimo());
		assertEquals(25,presentacion.stockCritico());
	}
	
	@Test
	public void aumentoStock(){
		//Cuando el stock es de 200, si agrego 20 unidades entonces el stock es de 220
		
		presentacion.aumentarStock(20); // Agrego las 20 unidades
		assertEquals(220,presentacion.stock());
	}
	
	@Test
	public void decrementarStock()throws StockInsuficienteException{
		//Cuando el stock es de 200, si lo quiero decrementar en 50, entonces el stock pasa a ser de 150
		presentacion.decrementarStock(50);
		assertEquals(150, presentacion.stock());
	}
	
	@Test (expected = StockInsuficienteException.class)
	public void decreentarStockExeption()throws StockInsuficienteException{
		//Cuando el stock es de 200, si lo quiero decrementar en 201 unidades, entonces arroja una exception
		presentacion.decrementarStock(201);

	}

}
