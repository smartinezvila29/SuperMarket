package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int idCart;
	private LocalDate dateHour;
	private List<ItemCart> lstItemCart = new ArrayList();
	private Client client;
	
	public Cart(int idCart, LocalDate dateHour, Client client) {
		super();
		this.idCart = idCart;
		this.dateHour = dateHour;
		this.lstItemCart = lstItemCart;
		this.client = client;
	}
	public int getIdCart() {
		return idCart;
	}
	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}
	public LocalDate getDateHour() {
		return dateHour;
	}
	public void setDateHour(LocalDate dateHour) {
		this.dateHour = dateHour;
	}
	public List<ItemCart> getLstItemCart() {
		return lstItemCart;
	}
	public void setLstItemCart(List<ItemCart> lstItemCart) {
		this.lstItemCart = lstItemCart;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
