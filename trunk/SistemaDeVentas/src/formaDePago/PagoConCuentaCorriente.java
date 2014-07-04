package formaDePago;

import cliente.Cliente;
import exceptions.SaldoInsuficienteCtaCteException;

public class PagoConCuentaCorriente extends FormaDePago {

	@Override
	public void cobrar(Cliente cliente, double monto) throws SaldoInsuficienteCtaCteException{
	
			cliente.getCtaCte().abonar(monto);
			
	}

	@Override
	public boolean equals(Object other) {
		 if (other == this) return true;
		   if (other == null) return false;
		   if (getClass() == other.getClass()) return true;
		return false;
	}

	

}
