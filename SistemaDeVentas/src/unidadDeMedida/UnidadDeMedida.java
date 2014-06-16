package unidadDeMedida;

public abstract class UnidadDeMedida {
	private String tipo;
	private int cantidad;

	protected UnidadDeMedida(String tipo,int cantidad){
		this.tipo=tipo;
		this.cantidad=cantidad;
	}
	protected int getCantidad() {
		return cantidad;
	}

	protected void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	private String getTipo() {
		return tipo;
	}
	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	private String cantidad(){
		return ((Integer)this.getCantidad()).toString();
	}
	public String tipoDeUnidadYCantidad(){
		return  "Presentacion en "+this.getTipo()+". Cantidad: "+this.getCantidad();
	}
	
}
