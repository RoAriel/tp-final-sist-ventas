package formaDePago;

import cliente.Cliente;

public abstract class FormaDePago {
	
	public abstract void cobrar(Cliente cliente, double monto );

}
