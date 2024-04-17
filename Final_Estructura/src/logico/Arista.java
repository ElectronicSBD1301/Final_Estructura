package logico;

public class Arista {
	private int peso;
	private int tiempo;

	public Arista(int peso, int tiempo) {
		this.peso = peso;
		this.tiempo = tiempo;
	}

	public int getPeso() {
		return peso;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}
