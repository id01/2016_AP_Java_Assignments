// Gavin Lo
// March 15, 2017
// This class invokes a few piecewise functions from the Piecewise class.

public class PiecewiseTester
{
	public static void main(String [] args)
	{
		Piecewise funcs = new Piecewise();
		System.out.printf("f1(25) = %d\n", funcs.f1(25));
		System.out.printf("f2(30) = %.2f\n", funcs.f2(30));
		System.out.printf("f4(500) = %d\n", funcs.f4(500));
	}
}
