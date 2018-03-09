// Gavin Lo
// 05-23-2017
// This program represents a dispenser.

public class Dispenser {
	private int numberOfItems, cost;

	public Dispenser() {
		numberOfItems = 50;
		cost = 50;
	}
	public Dispenser(int newNumberOfItems, int newCost) {
		if (newNumberOfItems >= 0 && newCost > 0) {
			numberOfItems = newNumberOfItems;
			cost = newCost;
		} else {
			throw new IllegalArgumentException("numberOfItems must be greater than or equal to 0, and cost must be greater than 0!");
		}
	}

	public int getCount() {
		return numberOfItems;
	}
	public int getProductCost() {
		return cost;
	}
	public void makeSale() {
		if (numberOfItems > 0)
			numberOfItems--;
		else
			throw new RuntimeException("Out of stock.");
	}
}
