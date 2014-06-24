package ofertas;

import java.util.List;

public class GranOferta extends Oferta {
	protected List<Oferta> ofertas;

	public GranOferta(List<Oferta> ofertas, int porcentajeDescuento) {
		super(porcentajeDescuento);
		this.ofertas = ofertas;
	}

	protected List<Oferta> getOfertas() {
		return ofertas;
	}

	protected void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
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
		for (Oferta current : this.getOfertas()) {
			ret += current.precioOferta();
		}
		return ret-(ret*this.descuento());
	}
}
