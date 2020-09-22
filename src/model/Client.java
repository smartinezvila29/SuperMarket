package model;

public class Client {
	private int idClient;
	private String client;
	private long dni;
	private String address;
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Client(int idClient, String client, long dni, String address) {
		super();
		this.idClient = idClient;
		this.client = client;
		this.dni = dni;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", client=" + client + ", dni=" + dni + ", address=" + address + "]";
	}
	
}
