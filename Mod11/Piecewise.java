// Gavin Lo
// March 15, 2017
// This class includes a few recursive piecewise functions.

public class Piecewise
{
	public Piecewise()
	{
	}

	// Function for question 1
	public int f1(int x)
	{
		if (x > 10)
			return f1(x-4)+2;
		else
			return -7;
	}

	// Function for question 2
	public double f2(double x)
	{
		if (x>25.0)
			return f2(x/12+5)-3;
		else
			return 20.0;
	}

	// Function for question 4
	public int f4(int x)
	{
		if (x>20)
			return -100;
		else
			return f4(x*2)-4;
	}
}
