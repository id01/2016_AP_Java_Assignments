// Gavin Lo
// March 21, 2017
// This program tests the polygons.
// It has a method that accepts any one of the classes derived
// from circle and prints its center using the getcenter method.

import java.util.ArrayList;

public class TestPoly2
{
	// Constructor
	public TestPoly2()
	{
	}

	// Polymorphic method
	public String showCenter(Circle myCircle) // Doesn't have to be a circle
	{
		return "For " + myCircle.getClass().getName() + "@" + System.identityHashCode(myCircle) + ", " + myCircle.center();
	}

	// Main method
	public static void main(String [] args)
	{
		// Create instances
		TestPoly2 tester = new TestPoly2();
		ArrayList<Circle> circleList = new ArrayList<Circle>();
		circleList.add(new Circle(10, 20, 5));
		circleList.add(new Cylinder(30, 20, 5, 10));
		circleList.add(new Oval(-5, -18, 6, 20));
		circleList.add(new OvalCylinder(-100, 10, 8, 16, 12));
		
		// Print results
		for (Circle cir : circleList)
		{
			System.out.println(tester.showCenter(cir));
		}
	}
}
