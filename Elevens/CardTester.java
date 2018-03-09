/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card carda = new Card("ace", "hearts", 1);
		Card cardb = new Card("two", "spades", 2);
		Card cardc = new Card("five", "clubs", 5);
		System.out.println("card a: " + carda);
		System.out.println("card b: " + cardb);
		System.out.println("card c: " + cardc);
		System.out.println("card a rank: " + carda.rank());
		System.out.println("card b suit: " + cardb.suit());
		System.out.println("card c pointValue: " + cardc.pointValue());
		System.out.println("card a matches card b: " + carda.matches(cardb));
		System.out.println("card c matches card c: " + cardc.matches(cardc));
	}
}
