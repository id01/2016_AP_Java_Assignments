// Gavin Lo
// 05-11-2017
// This class represents an item in a store.

public class Item
{
	String itemID, itemName; // Assignment wanted itemID to be a String
	int inStore;
	double price;

	public Item(String itemID, String itemName, int inStore, double price) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.inStore = inStore;
		this.price = price;
	}

	public void setID(String newID) {
		itemID = newID;
	}
	public String getID() {
		return itemID;
	}

	public void setName(String newName) {
		itemName = newName;
	}
	public String getName() {
		return itemName;
	}

	public void setQuantity(int newQuantity) {
		inStore = newQuantity;
	}
	public int getQuantity() {
		return inStore;
	}

	public void setPrice(double newPrice) {
		price = newPrice;
	}
	public double getPrice() {
		return price;
	}

	public String toString() {
		return inStore + " " + itemName + " in store, item id " + itemID + " $" + ((int)(price*100)/100.0) + " each";
	}
}
