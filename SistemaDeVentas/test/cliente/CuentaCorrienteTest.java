package cliente;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import exceptions.SaldoInsuficienteCtaCteException;

public class CuentaCorrienteTest {
	CuentaCorriente ctacte;

	@Before
	public void setUp() throws Exception {
		this.ctacte = new CuentaCorriente(mock(Cliente.class));
	}

	@Test
	public void alInstanciaLaClaseElSaldoEs0() {
		assertEquals((Double) 0d, ctacte.saldo());
	}

	@Test
	public void depositar() {
		// Cuando a una ctacte con saldo 0, le deposito 14.5d , entonces tiene
		// 14.5d de saldo.
		ctacte.depositar(14.5d);
		assertEquals((Double) 14.5d, ctacte.saldo());
		// Cuando le agrego 0.5d mas , entonces tiene 15d de saldo
		ctacte.depositar(0.5d);
		assertEquals((Double) 15d, ctacte.saldo());
	}

	@Test
	public void abonarSaldoSuficiente() throws SaldoInsuficienteCtaCteException{
		// Cuando quiero abonar una sierta cantidad de la que dispongo en la
		// ctacte, entonces lo descuenta
		ctacte.depositar(100d);
		ctacte.abonar(50d);
		assertEquals((Double)50d, ctacte.saldo());
		ctacte.abonar(50d);
		assertEquals((Double)0d, ctacte.saldo());
	}
	
	@Test (expected = SaldoInsuficienteCtaCteException.class)
	public void abonarConSaldoInsuficiente() throws SaldoInsuficienteCtaCteException{
		ctacte.abonar(1d);
	}

}
