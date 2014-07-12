package ofertas;

import producto.Presentacion;

public class ProductoEnOferta extends Oferta {

	private Presentacion enOFerta;

	public ProductoEnOferta(Presentacion enOferta, Double porcentajeDescuento) {
		super(porcentajeDescuento);
		this.enOFerta = enOferta;
	}

	protected Presentacion getEnOFerta() {
		return enOFerta;
	}

	@Override
	public Double precioNormal() {
		return this.getEnOFerta().precioDeVenta();
	}

	@Override
	public Double precioOferta() {
		double cantidadDeDescuento = (this.precioNormal()*(this.descuento()/100));
		return this.precioNormal()- cantidadDeDescuento;
	}

}
