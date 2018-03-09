// Gavin Lo
// 05-23-2017
// This program represents a candy machine and tests the other two programs

public class CandyMachine {
	public static void sellProduct(Dispenser dispenser, CashRegister cashRegister, int amount) {
		if (dispenser == null || cashRegister == null) {
			throw new NullPointerException("Either Dispenser or CashRegister inputted is null");
		}
		if (amount > dispenser.getCount()) {
			System.out.println("Out of stock: Cannot sell " + amount + " candies because there are only " + dispenser.getCount() + " left.");
		} else {
			System.out.println("Collect your item at the bottom and enjoy.");
			for (int i=0; i<amount; i++) {
				dispenser.makeSale();
				cashRegister.acceptAmount(dispenser.getProductCost());
			}
		}
	}

	public static void main(String [] args) {
		Dispenser mnms = new Dispenser();
		Dispenser skittles = new Dispenser(100, 25);
		//Dispenser exception = new Dispenser(-1, 10);
		//CashRegister exceptionRegister = new CashRegister(-1);
		CashRegister myCashRegister = new CashRegister(100);
		System.out.println("Selling 100 mnms");
		sellProduct(mnms, myCashRegister, 100);
		// Exception!
//		sellProduct(skittles, null, 10);
		System.out.println("Selling 10 skittles, then 90, then 1 more: ");
		sellProduct(skittles, myCashRegister, 10);
		sellProduct(skittles, myCashRegister, 90);
		sellProduct(skittles, myCashRegister, 1);
	}
}
