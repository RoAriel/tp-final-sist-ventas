package formaDePago;

import cliente.Cliente;
import exceptions.SaldoInsuficienteCtaCteException;

public abstract class FormaDePago {
	
	public abstract void cobrar(Cliente cliente, double monto)throws SaldoInsuficienteCtaCteException;
	public abstract boolean equals(Object other);

}
