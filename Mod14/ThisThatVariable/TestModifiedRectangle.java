// Gavin Lo
// April 01, 2017
// This program tests the modified rectangle class and box class.

public class TestModifiedRectangle
{
	public static void main(String [] args)
	{
		Box box = new Box(1, 2, 3);
		Rectangle rect = new Rectangle(4, 5);
		System.out.println("Dimensions of box: (" + box.getLength() + "," + box.getWidth() + "," + box.getHeight() + ")");
		System.out.println("Dimensions of rect: (" + rect.getLength() + "," + rect.getWidth() + ")");
	}
}