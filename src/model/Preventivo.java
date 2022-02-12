package model;

public class Preventivo {

	private int id_auto;
	public int getId_auto() {
		return id_auto;
	}
	public void setId_auto(int id_auto) {
		this.id_auto = id_auto;
	}
	public String getUserClient() {
		return userClient;
	}
	public void setUserClient(String userClient) {
		this.userClient = userClient;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	private String userClient;
	private String data;
	public Preventivo(int id_auto, String userClient, String data) {
		
		super();
		this.id_auto = id_auto;
		this.userClient = userClient;
		this.data = data;
	}
	public Preventivo() {}
}
