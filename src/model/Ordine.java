package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.mapping.List;


public class Ordine implements Serializable {

	private String userClient;
	private int id_ricambio;
	private double totale;
	private String via;
	private String civico;
	private String cap;
	private boolean stato;
	private int quantità;
	private Client cliente ; 
	private int id;
	private List ricambi;
	

    public int getId() {
        return id;
    }
 
	

	public String getUserClient() {
		return userClient;
	}
	public void setUserClient(String userClient) {
		this.userClient = userClient;
	}
	public int getId_ricambio() {
		return id_ricambio;
	}
	public void setId_ricambio(int id_ricambio) {
		this.id_ricambio = id_ricambio;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public Ordine(String userClient, int id_ricambio, double totale, String via, String civico, String cap,
			boolean stato) {
		super();
		this.userClient = userClient;
		this.id_ricambio = id_ricambio;
		this.totale = totale;
		this.via = via;
		this.civico = civico;
		this.cap = cap;
		this.stato = stato;
	}
	public Ordine(String userClient, int id_ricambio, double totale, String via, String civico, String cap) {
		super();
		this.userClient = userClient;
		this.id_ricambio = id_ricambio;
		this.totale = totale;
		this.via = via;
		this.civico = civico;
		this.cap = cap;
		
	}
	public Ordine() {}
	
	
	
}
