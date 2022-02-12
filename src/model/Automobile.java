package model;

public class Automobile {

	
	private int id;
	private String marca;
	private String modello;
	private double prezzo;
	private String path;

	/*
	 * public autoNuove() { this.id = -1; this.marca = ""; this.modello = "";
	 * this.anno = 0; this.motore = ""; this.peso = 0; this.altezza = 0;
	 * this.lunghezza = 0; this.larghezza = 0; this.posti = 0; this.prezzo = 0; }
	 */
	public Automobile() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public double getPrezzo() {
		return prezzo;
	}
	

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Automobile(int id, String marca, String modello, double prezzo, String path) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;

		this.prezzo = prezzo;
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
