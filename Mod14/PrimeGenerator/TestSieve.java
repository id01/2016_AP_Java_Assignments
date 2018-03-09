// Gavin Lo
// April 1, 2017
// This program tests the SieveOfE class to get a prime ArrayList up to a maximum value and print it to the screen

import java.util.ArrayList;
import java.util.Scanner;

public class TestSieve
{
	public static void main(String [] args)
	{
		// Get max number
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What number should I get primes up to?");
		final int maxPrime = Integer.parseInt(keyboard.nextLine());
		// Calculate primes and get it
		SieveOfE mySieve = new SieveOfE(maxPrime);
		mySieve.sieveIt();
		ArrayList<Integer> myPrimes = mySieve.getPrimeArrayList();
		// Print arrayList
		System.out.println("Found " + myPrimes.size() + " primes, displayed below:");
		for (int i=0; i<myPrimes.size()-1; i++)
		{
			System.out.print(myPrimes.get(i) + ",");
		}
		System.out.println(myPrimes.get(myPrimes.size()-1));
	}
}