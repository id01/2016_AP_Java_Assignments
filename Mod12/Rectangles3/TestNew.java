// Gavin Lo
// March 23, 2017
// This program tests the new rectangle classes using polymorphism.

public class TestNew
{
	public TestNew()
	{
	}

	public void showEffectBoth(Rectangle3 r)
	{
		Cube3 testCube = new Cube3(4);
		System.out.println(r);
		if (testCube.equals(r))
			System.out.println(r + " is the same as " + testCube);
		else
			System.out.println(r + " is not the same as " + testCube);
	}

	public static void main(String [] args)
	{
		TestNew tester = new TestNew();
		Rectangle3 [] rects = new Rectangle3[4];
		rects[0] = new Rectangle3(5, 10);
		rects[1] = new Box3(4, 4, 4);
		rects[2] = new Box3(4, 10, 5);
		rects[3] = new Cube3(4);
		for (Rectangle3 rect : rects)
		{
			tester.showEffectBoth(rect);
		}
	}
}
