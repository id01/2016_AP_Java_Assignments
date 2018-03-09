// Gavin Lo
// 05-23-2017
// This program represents a cash register.

public class CashRegister {
	int cashOnHand;

	public CashRegister() {
		cashOnHand = 500;
	}
	public CashRegister(int newCashOnHand) {
		if (newCashOnHand > 0)
			cashOnHand = newCashOnHand;
		else
			throw new IllegalArgumentException("Cash must be greater than 0!");
	}

	public void cashRegister(int newCashOnHand) {
		if (newCashOnHand > 0)
			cashOnHand = newCashOnHand;
		else
			throw new IllegalArgumentException("Cash must be greater than 0!");
	}
	public void acceptAmount(int addToCash) {
		if (addToCash > 0)
			cashOnHand += addToCash;
		else
			throw new IllegalArgumentException("Cash must be greater than 0!");
	}
}
