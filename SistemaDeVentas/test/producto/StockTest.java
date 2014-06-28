package producto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import exceptions.StockInsuficienteException;

public class StockTest {
	Stock stock;

	@Before
	public void setUp() throws Exception {
		this.stock = new Stock(200, 50, 25);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testeoCantidadesDeStock() {
		assertEquals(200, stock.stock());
		assertEquals(50, stock.minimo() );
		assertEquals(25, stock.critico());
	}

	@Test
	public void decrementoStock() throws StockInsuficienteException {
		// Cuando el stock tiene 200 unidades y lo decremento en 50, entonces,
		// tiene que tener 150.
		stock.decrementarStock(50);
		assertEquals(150, stock.stock());
	}
	
	@Test (expected = StockInsuficienteException.class)
	public void decrementoStockInsuficienteException() throws StockInsuficienteException{
		//Cuando quiero decrementar el stock en una cantidad mayor a la que se tiene
		stock.decrementarStock(stock.stock()+1);
	}
	
	@Test
	public void agregarStock() {
		// Cuando el stock tiene 200 unidades y le agrego 1,
		// tiene que tener 201.
		stock.agregarStock(1);
		assertEquals(201, stock.stock());
	}
}
