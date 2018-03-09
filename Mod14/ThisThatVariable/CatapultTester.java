// Gavin Lo
// March 7, 2017
// This program is the tester class for Catapult. It finds the distances of different projectiles of different
// angles and different speeds. It then prints them in a graph

public class CatapultTester
{
	public static void main(String [] args)
	{
		// Init variables
		double [] degInput = new double[] { 25, 30, 35, 40, 45, 50 };
		double [] mphInput = new double[] { 20, 25, 30, 35, 40, 45, 50 };
		double [][] catapults = new double[degInput.length][mphInput.length];
		// Do calculations
		Catapult currentCatapult;
		for (int y=0; y<catapults[0].length; y++)
		{
			for (int i=0; i<catapults.length; i++)
			{
				currentCatapult = new Catapult(degInput[i], mphInput[y]);
				currentCatapult.convertUnits();
				currentCatapult.calcDistance();
				catapults[i][y] = currentCatapult.getDistanceTravelled();
			}
		}
		// Print to screen
		// Header
		System.out.print("   MPH    ");
		for (int i=0; i<catapults.length; i++)
		{
			System.out.printf("%-10s", degInput[i] + " deg");
		}
		System.out.println();
		for (int i=0; i<10+catapults.length*10; i++)
		{
			System.out.print("=");
		}
		System.out.println();
		for (int y=0; y<catapults[0].length; y++)
		{
			System.out.printf("%6.1f %4s", mphInput[y], "");
			for (int i=0; i<catapults.length; i++)
			{
				System.out.printf("%-10.2f", catapults[i][y]);
			}
			System.out.println();
		}
	}
}