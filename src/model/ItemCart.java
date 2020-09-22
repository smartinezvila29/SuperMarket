package model;

public class ItemCart {
	private int idItem;
	private Product product;
	private int quantity;
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ItemCart(int idItem, Product product, int quantity) {
		super();
		this.idItem = idItem;
		this.product = product;
		this.quantity = quantity;
	}
	
	
	
}
