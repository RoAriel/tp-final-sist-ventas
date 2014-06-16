package producto;

class Ubicacion {
	private int pasillo;
	private int gondola;
	private int estante;

	public Ubicacion(int pasillo, int gondola, int estante) {
		this.pasillo = pasillo;
		this.gondola = gondola;
		this.estante = estante;
	}

	private int getPasillo() {
		return pasillo;
	}

	private void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}

	private int getGondola() {
		return gondola;
	}

	private void setGondola(int gondola) {
		this.gondola = gondola;
	}

	private int getEstante() {
		return estante;
	}

	private void setEstante(int estante) {
		this.estante = estante;
	}
	
	public int pasillo(){
		return this.getPasillo();
	}
	
	public int gondola(){
		return this.getGondola();
	}
	
	public int estante(){
		return this.getEstante();
	}
}
