package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrello implements Serializable{

	private int id_ricambio;
	private double prezzo;
	private int quantit�;
	private ArrayList<Integer> id_ricambi;
	private double totale;
	private String userClient;

	public String getUserClient() {
		return userClient;
	}

	public void setUserClient(String userClient) {
		this.userClient = userClient;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Carrello() {
		id_ricambi = new ArrayList<Integer>(50);
		prezzo = 0;
		quantit�= 0;
		id_ricambio = 0;
	}

	public ArrayList<Integer> getRicambi() {
		return id_ricambi;
	}

	public void addRicambi(int id_ricambio, String userClient, int quantit�, double prezzo) {
		this.id_ricambio = id_ricambio;
		this.prezzo = prezzo;
		this.quantit�= quantit�;
		this.userClient = userClient;

	}

	public int getId_ricambio() {
		return id_ricambio;
	}

	public void setId_ricambio(int id_ricambio) {
		this.id_ricambio = id_ricambio;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit�= quantit�;
	}

	

}
