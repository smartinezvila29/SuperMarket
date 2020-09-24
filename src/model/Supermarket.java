package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Supermarket {
	private AdmProduct admProduct;
	private AdmClient admClient;
	private AdmCart admCart;
	
	public AdmProduct getAdmProduct() {
		return admProduct;
	}
	public void setAdmProduct(AdmProduct admProduct) {
		this.admProduct = admProduct;
	}
	public AdmClient getAdmClient() {
		return admClient;
	}
	public void setAdmClient(AdmClient admClient) {
		this.admClient = admClient;
	}
	public AdmCart getAdmCart() {
		return admCart;
	}
	public void setAdmCart(AdmCart admCart) {
		this.admCart = admCart;
	}
	public Supermarket(AdmProduct admProduct, AdmClient admClient, AdmCart admCart) {
		super();
		this.admProduct = admProduct;
		this.admClient = admClient;
		this.admCart = admCart;
	}
	
	/*add product*/
	public boolean addProduct(int idProduct, String product, float cost)throws Exception{
		if(getProduct(idProduct)==null)throw new Exception("The product is listed.");
		int id=1;
		if(!admProduct.getLstProduct().isEmpty()) id = admProduct.getLstProduct().get(admProduct.getLstProduct().size()).getIdProduct()+1;
		return admProduct.getLstProduct().add(new Product(id, product, cost));
	}
	
	/*get product*/
	public Product getProduct(int idProduct){
		Product p = null;
		int i = 0;
		while (admProduct.getLstProduct().size() >= i && p==null){
			if (admProduct.getLstProduct().get(i).getIdProduct() == idProduct) {
				p = admProduct.getLstProduct().get(i);
			}
			i++;
		}
		return p;
	}
	/*delete product*/
	public boolean deleteProduct(int idProduct)throws Exception{
		if(getProduct(idProduct)==null)throw new Exception("The product doesnt exist.");
		return admProduct.getLstProduct().remove(admProduct.getLstProduct().get(idProduct));
	}
	
	/*add item*/
	public boolean addItemCart (Product product, int quantity)throws Exception {
		if(getProduct(product.getIdProduct())==null)throw new Exception("The product doesnt exist.");
		int idItem = 1;
		int idCart = 1;
		if(!admCart.getLstCart().isEmpty()) idCart = admCart.getLstCart().get(admCart.getLstCart().size()).getIdCart()+1;
		if (!admCart.getLstCart().get(idCart).getLstItemCart().isEmpty()) { idItem = admCart.getLstCart().get(idCart).getLstItemCart().
				get(admCart.getLstCart().get(idCart).getLstItemCart().size()).getIdItem()+1;}
		return admCart.getLstCart().get(idCart).getLstItemCart().add(new ItemCart(idItem, product, quantity));
	}
	
	/*delete item*/
	public boolean deleteItemCart (Product product, int quantity)throws Exception{
		boolean flag = false;
		int idCart = 1;
		int idItem = 1;
		while (admCart.getLstCart().size()>=idCart && !admCart.getLstCart().isEmpty()) {
			while (admCart.getLstCart().get(idCart).getLstItemCart().size()>=idItem && !admCart.getLstCart().get(idCart).getLstItemCart().isEmpty()) {
				if (admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getProduct().getIdProduct() == product.getIdProduct()) {
					if (admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getQuantity() > quantity) { /*if the quantity that i have is bigger than quantity rest quantity to that*/
						admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).setQuantity(admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getQuantity()-quantity);
						flag = true;
					}
					if (admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getQuantity() <= quantity)/*if it is less than quantity delete the item*/ {
						admCart.getLstCart().get(idCart).getLstItemCart().remove(admCart.getLstCart().get(idCart).getLstItemCart().get(idItem));
						flag = true;
					}
				}
					
				idItem++;
			}
			
			idCart++;
		}
		return flag;
	}
	
	/*calculate total*/
	public float calculateTotal() {
		int idCart = 0;
		int idItem = 0;
		float total = 0;
		while (!admCart.getLstCart().isEmpty() && admCart.getLstCart().size()>=idCart) {
			total = 0;
			while (!admCart.getLstCart().get(idCart).getLstItemCart().isEmpty() && admCart.getLstCart().get(idCart).getLstItemCart().size()<=idItem) {
				total = total + (admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getQuantity()*admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getProduct().getCost());
				idCart++;
			}
			idCart++;
			return total;
		}
		return total;
	}
	
	/*add client*/
	public boolean addClient(String client, long dni, String address)throws Exception {
		if (getClient(dni)!=null)throw new Exception ("The dni already exist.");
		int id = 1;
		if (!admClient.getLstClient().isEmpty()) id = admClient.getLstClient().get(admClient.getLstClient().size()).getIdClient()+1;
		return admClient.getLstClient().add(new Client(id, client, dni, address));
	}
	
	/*get client by dni and id*/
	public Client getClient (int idClient) {
		Client c = null;
		int i = 1;
		while (admClient.getLstClient().size() <= i && c==null) {
			if (admClient.getLstClient().get(i).getIdClient() == idClient) {
				c = admClient.getLstClient().get(i);
			}
			i++;
		}
		return c;
	}
	public Client getClient (long dni) {
		Client c = null;
		int i = 1;
		while (admClient.getLstClient().size() <= i && c==null) {
			if (admClient.getLstClient().get(i).getDni() == dni) {
				c = admClient.getLstClient().get(i);
			}
			i++;
		}
		return c;
	}
	
	/*remove client*/
	public boolean deleteClient(int idClient)throws Exception {
		if (getClient(idClient)==null)throw new Exception("The client doesnt exist.");
		int i = 0;
		while (admCart.getLstCart().size() >= i) {
			if (admCart.getLstCart().get(i).getClient().getIdClient()==idClient) {
				if (!admCart.getLstCart().get(i).getLstItemCart().isEmpty())throw new Exception("The client have products to pay.");
			}
		}
		return admClient.getLstClient().remove(admClient.getLstClient().get(idClient));
	}
	
	/*add cart*/
	public boolean addCart (LocalDate dateHour, Client client) {
		int idCart = 1;
		if (!admCart.getLstCart().isEmpty()) idCart = admCart.getLstCart().get(admCart.getLstCart().size()).getIdCart()+1;
		return admCart.getLstCart().add(new Cart(idCart, dateHour, client));
	}
	
	/*get cart*/
	public Cart getCart (int idCart) throws Exception{
		Cart c = null;
		int i = 0;
		while (i <= admCart.getLstCart().size() && c == null) {
			if (admCart.getLstCart().get(i).getIdCart()==idCart) {
				c = admCart.getLstCart().get(i);
			}
			i++;
		}
		return c;
	}
	
	/*delete cart*/
	public boolean deleteCart(int idCart)throws Exception{
		if (getCart(idCart)!=null) throw new Exception("The cart doesnt exists.");
		return admCart.getLstCart().remove(admCart.getLstCart().get(idCart));
	}
	
	/*calculate total by client*/
	public float calculateTotal(Client client)throws Exception {
		if (getClient(client.getIdClient())!=null)throw new Exception("The client doesnt exists.");
		int idCart=0;
		float total=0;
		while (admCart.getLstCart().size()>=idCart) {
			if (admCart.getLstCart().get(idCart).getClient().getIdClient()==client.getIdClient()) {
				int idItem = 0;
				while (admCart.getLstCart().get(idCart).getLstItemCart().size()>=idItem) {
					total = total + (admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getProduct().getCost()*admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getQuantity());
					deleteItemCart(admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getProduct(), admCart.getLstCart().get(idCart).getLstItemCart().get(idItem).getQuantity());
					idItem++;
				}
			}
			idCart++;
		}
		return total;
	}
	
	/*test commit*/
}
