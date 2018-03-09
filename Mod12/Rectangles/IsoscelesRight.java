// Gavin Lo
// March 17, 2017
// This class symbolizes an isoceles right triangle.

public class IsoscelesRight extends Triangle
{
	public IsoscelesRight(double side)
	{
		super(side, side, side*Math.sqrt(2));
	}
}