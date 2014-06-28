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
	
	public int pasillo(){
		return pasillo;
	}
	
	public int gondola(){
		return gondola;
	}
	
	public int estante(){
		return estante;
	}
}
