package ofertas;

import producto.Presentacion;

public class ProductoEnOferta extends Oferta {

	private Presentacion enOFerta;

	public ProductoEnOferta(Presentacion enOferta, int porcentajeDescuento) {
		super(porcentajeDescuento);
		this.enOFerta = enOferta;
	}

	protected Presentacion getEnOFerta() {
		return enOFerta;
	}

	protected void setEnOFerta(Presentacion enOFerta) {
		this.enOFerta = enOFerta;
	}

	@Override
	public Double precioNormal() {
		return this.getEnOFerta().precioDeVenta();
	}

	@Override
	public Double precioOferta() {
		return this.precioNormal()-(this.precioNormal()*this.getPorcentajeDescuento());
	}

}
