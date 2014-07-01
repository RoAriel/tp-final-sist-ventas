package formaDePago;

import cliente.Cliente;

public class PagoEnEfectivo extends FormaDePago {

	@Override
	public void cobrar(Cliente cliente, double monto) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean equals(Object other) {
		 if (other == this) return true;
		   if (other == null) return false;
		   if (getClass() == other.getClass()) return true;
		return false;
	}

}
