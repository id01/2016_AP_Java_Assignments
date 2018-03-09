/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"orange", "green", "blue", "red"};
		int[] pointValues = {11, 12, 13, 15, 17};
		Deck d1 = new Deck(ranks, suits, pointValues);
		ranks = new String[]{"ace", "two", "three"};
		suits = new String[]{"orange", "red"};
		pointValues = new int[]{5, 4, 9};
		Deck d2 = new Deck(ranks, suits, pointValues);
		ranks = new String[]{};
		suits = new String[]{};
		pointValues = new int[]{};
		Deck d3 = new Deck(ranks, suits, pointValues);
		System.out.println("Deck 1 is empty: " + d1.isEmpty());
		System.out.println("Size of deck 2: " + d2.isEmpty());
		System.out.println("Deck 3 is empty: " + d3.isEmpty());
		System.out.println("Dealt card from deck 1: " + d1.deal());
		System.out.println("Dealt card from deck 3: " + d3.deal());
		System.out.println("Deck 2 as string: \n" + d2);

		// Test shuffling
		ranks = new String[]{"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king",
			"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king",
			"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king",
			"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
		suits = new String[52];
		for (int i=0; i<13; i++)
			suits[i] = "spades";
		for (int i=13; i<26; i++)
			suits[i] = "hearts";
		for (int i=26; i<39; i++)
			suits[i] = "clubs";
		for (int i=39; i<52; i++)
			suits[i] = "diamonds";
		pointValues = new int[]{11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		Deck shuffleDeck = new Deck(ranks, suits, pointValues);
		while (shuffleDeck.isEmpty() == false) {
			System.out.println("Next card: " + shuffleDeck.deal());
		}
		System.out.println("Deck empty. Shuffling again.");
		shuffleDeck.shuffle();
		while (shuffleDeck.isEmpty() == false) {
			System.out.println("Next card: " + shuffleDeck.deal());
		}
	}
}
