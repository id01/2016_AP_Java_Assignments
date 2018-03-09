// Gavin Lo
// March 16, 2017
// This program is the tester class for RecursivePalindrome. It takes in an input from the user
// and determines whether it is a palindrome.

import java.util.Scanner;

public class RecursivePalindromeTester
{
	public static void main(String [] args)
	{
		// Init variables
		RecursivePalindrome p = new RecursivePalindrome();
		String userInput = new String();
		Scanner keyboard = new Scanner(System.in);
		int finalLength;
		// Print header
		System.out.println("This program finds if a string is a palindrome.");
		System.out.println("Type 'quit' to exit.");
		System.out.println("Just in case you're wondering, 'quit' is not a palindrome.");
		// Main loop
		while (!userInput.equalsIgnoreCase("quit"))
		{
			// Get input
			System.out.print("Test a string: ");
			userInput = keyboard.nextLine();
			// Check palindromeness
			finalLength = p.iterate(userInput).length();
			if (finalLength <= 1)
				System.out.println("This is a palindrome.");
			else
				System.out.println("This is not a palindrome.");
		}
	}
}