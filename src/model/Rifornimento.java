package model;

public class Rifornimento {

	private String marca;
	private String tipo;
	private String dataRichiesta;
	private String dataConsegna;
	private int numeroPezzi;
	private String userDip;
	private int id_ricambio;

	

	public Rifornimento(String marca, String tipo, String dataRichiesta, String dataConsegna, int numeroPezzi,
			String userDip) {
		super();
		this.marca = marca;
		this.tipo = tipo;
		this.dataRichiesta = dataRichiesta;
		this.dataConsegna = dataConsegna;
		this.numeroPezzi = numeroPezzi;
		this.userDip = userDip;
	}
	public Rifornimento() {}
		
	public Rifornimento(int id_ricambio,String dataRichiesta, String dataConsegna, int numeroPezzi,
			String userDip) {
		super();
		this.id_ricambio=id_ricambio;
		this.dataRichiesta = dataRichiesta;
		this.dataConsegna = dataConsegna;
		this.numeroPezzi = numeroPezzi;
		this.userDip = userDip;
	}
	
	public int getId_ricambio() {
		return id_ricambio;
	}
	public void setId_ricambio(int id_ricambio) {
		this.id_ricambio = id_ricambio;
	}
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(String dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public String getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(String dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public int getNumeroPezzi() {
		return numeroPezzi;
	}

	public void setNumeroPezzi(int numeroPezzi) {
		this.numeroPezzi = numeroPezzi;
	}

	public String getUserDip() {
		return userDip;
	}

	public void setUserDip(String userDip) {
		this.userDip = userDip;
	}



}
