package Model;

public class Drug {
	String name;
	double price;
	int quantity;
	static int id;
	String ID = "000" + id++;
	
	public Drug(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Drug() {
		
	}
	public Drug(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getID() {
		return ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	
}
