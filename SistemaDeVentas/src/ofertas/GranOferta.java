package ofertas;

import java.util.List;

public class GranOferta extends Oferta {
	protected List<Oferta> ofertas;

	public GranOferta(List<Oferta> ofertas, Double porcentajeDescuento) {
		super(porcentajeDescuento);
		this.ofertas = ofertas;
	}

	protected List<Oferta> getOfertas() {
		return ofertas;
	}

	@Override
	public Double precioNormal() {
		Double ret = 0.00d;
		for (Oferta current : this.getOfertas()) {
			ret += current.precioNormal();
		}
		return ret;
	}

	@Override
	public Double precioOferta() {
		Double ret = 0.00d;
		List<Oferta> ofertas = this.getOfertas();
		for (Oferta current : ofertas) {
			ret += current.precioOferta();
		}

		return ret-(ret*(this.descuento()/100d));
	}
}
