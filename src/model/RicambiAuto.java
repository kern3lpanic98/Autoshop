package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.List;


public class RicambiAuto {

	private int id;

	private String marca;
	private String tipo;
	private double prezzo;
	private String path;
	private int qnt;
	private List ordine;

	public int getQuantità() {
		return qnt;
	}

	public void setQuantità(int qnt) {
		this.qnt = qnt;
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

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}




	public RicambiAuto(int id, String marca, double prezzo, String path, String tipo, int qnt) {
		super();
		this.id = id;
		this.path = path;
		this.marca = marca;
		this.prezzo = prezzo;
		this.tipo = tipo;
		this.qnt = qnt;
	}

	public RicambiAuto(int id, String marca, double prezzo, String path, String tipo) {
		super();
		this.id = id;
		this.path = path;
		this.marca = marca;
		this.prezzo = prezzo;
		this.tipo = tipo;
	}

	public RicambiAuto(String marca, double prezzo, String path, String tipo, int qnt) {
		super();
		this.path = path;
		this.marca = marca;
		this.prezzo = prezzo;
		this.tipo = tipo;
		this.qnt = qnt;
	}

	public RicambiAuto() {
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
