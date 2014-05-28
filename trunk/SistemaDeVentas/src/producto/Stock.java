package producto;

class Stock {
	int stock;
	int critico;
	int minimo;

	protected Stock(int stock, int critico, int minimo) {
		this.stock = stock;
		this.critico = critico;
		this.minimo = minimo;
	}
	
	private int getStock() {
		return stock;
	}

	private void setStock(int stock) {
		this.stock = stock;
	}

	private int getCritico() {
		return critico;
	}

	private void setCritico(int critico) {
		this.critico = critico;
	}

	private int getMinimo() {
		return minimo;
	}

	private void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int stock() {
		return this.getStock();
	}

	public boolean enStock(int cantidad) {
		return this.getStock() >= cantidad;
	}

	public void decrementarStock(int cantidad) {
		this.setStock(this.getStock() - cantidad);
	}

	public int critico() {
		return this.getCritico();
	}

	public int minimo() {
		return this.getMinimo();
	}
}
