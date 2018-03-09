// Gavin Lo
// March 17, 2017
// This program tests the cubs class and the box class.

public class TestCube
{
	public static void main(String [] args)
	{
		Box box = new Box(1, 2, 3);
		Cube cube = new Cube(4);
		System.out.printf("Dimensions of box: %dx%dx%d\n", box.getLength(), box.getWidth(), box.getHeight());
		System.out.printf("Dimensions of cube: %dx%dx%d\n", cube.getLength(), cube.getWidth(), cube.getHeight());
	}
}