// Gavin Lo
// April 1, 2017
// This program uses the Sieve of E. to generate prime numbers in O(n log n)!

import java.util.ArrayList;

public class SieveOfE
{
	private boolean [] possibilities;
	private int max;
	ArrayList<Integer> primeArrayList;

	public SieveOfE(int max)
	{
		this.max = max;
		this.possibilities = new boolean[max+1];
		for (int i=0; i<max+1; i++)
			this.possibilities[i] = true;
	}

	public void sieveIt()
	{
		ArrayList<Integer> primeArrayList = new ArrayList<Integer>();
		for (int i=2; i<max+1; i++) // Start from 2. 0 and 1 screw this up and aren't prime anyway
		{
			if (possibilities[i] == true)
			{
				for (int x=0; x<max+1; x+=i)
				{
					possibilities[x] = false;
				}
				primeArrayList.add(i);
			}
		}
		this.primeArrayList = primeArrayList;
	}

	public ArrayList<Integer> getPrimeArrayList()
	{
		return primeArrayList;
	}
}