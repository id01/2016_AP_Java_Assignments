// Gavin Lo
// March 16, 2017
// This program determines whether a string is a palindrome. It is the method class for RecursivePalindromeTester.

public class RecursivePalindrome
{
	/*
	public RecursivePalindrome(String candidate)
	{
		pal = candidate;
		isPalindrome = false;
	}
	*/

	/* Wrapper
	public void testPalindrome()
	{
		int finalLength = iterate(pal).length(); // Get the length of the string where stuff don't match up
		if (finalLength == 1 || finalLength == 0)
		{
			isPalindrome = true; // It is a palindrome
		}
	}*/

	public RecursivePalindrome()
	{
	}

	// Recursive method
	public String iterate(String iterString)
	{
		iterString = preProcess(iterString); // Preprocess
		if (iterString.length() <= 1)
			return iterString; // It is already a palindrome
		else if (iterString.charAt(0) != iterString.charAt(iterString.length()-1))
			return iterString; // It is not a palindrome
		else
			return iterate(iterString.substring(1, iterString.length()-1));
	}

	// Helper
	public String preProcess(String inString)
	{
		return inString.replace('.', ' ').replace(',', ' ').trim().toLowerCase();
	}

	/*public boolean getPalindrome()
	{
		return isPalindrome;
	}*/
}