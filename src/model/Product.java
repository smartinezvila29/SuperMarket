package model;

public class Product {
	private int idProduct;
	private String product;
	private float cost;
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Product(int idProduct, String product, float cost) {
		super();
		this.idProduct = idProduct;
		this.product = product;
		this.cost = cost;
	}
	
	

}
