// Gavin Lo
// March 17, 2017
// This class is an object that symbolizes a triangle.

public class Triangle
{
	double sideA, sideB, sideC;

	public Triangle(double a, double b, double c)
	{
		sideA = a;
		sideB = b;
		sideC = c;
	}

	public double getSideA()
	{
		return sideA;
	}

	public double getSideB()
	{
		return sideB;
	}

	public double getSideC()
	{
		return sideC;
	}
}