// Gavin Lo
// March 15, 2017
// This program finds fibonacci numbers under the user types quit


import java.util.Scanner;

public class FibonacciNumbers
{
	public FibonacciNumbers()
	{
	}

	// Function to get fibonacci number
	public int fib(int num)
	{
		if (num < 1)
			return 0;
		else if (num == 1 || num == 2)
			return 1;
		else
			return fib(num-1) + fib(num-2);
	}

	public static void main(String [] args)
	{
		// Init variables
		String input = "";
		int result;
		// Create instance of self and scanner
		FibonacciNumbers fib = new FibonacciNumbers();
		Scanner stdin = new Scanner(System.in);
		// Enter loop
		while (!input.equalsIgnoreCase("quit"))
		{
			System.out.print("Enter an integer (1+) to get the fibonacci of, or 'quit' to exit: ");
			input = stdin.nextLine();
			try
			{
				result = fib.fib(Integer.parseInt(input));
			}
			catch (NumberFormatException e)
			{
				result = 0; // Exception handling!!!
			}
			if (result == 0)
				System.out.println("Invalid input");
			else
				System.out.println("Your fibbonaci is: " + result);
		}
	}
}
