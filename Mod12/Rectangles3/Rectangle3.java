/**
 * rectangle Demo.
 * 
 * 
 * @author R. Enger 
 * @version 5/5/2007
 * Modified by: Gavin Lo
 * March 23, 2017
 */
public class Rectangle3
{
	// instance variables 
	private int length;
	private int width;

	/**
	 * Constructor for objects of class rectangle
	 */
	public Rectangle3(int l, int w)
	{
		// initialise instance variables
		length = l;
		width = w;
	}

	// return the height
	public int getLength()
	{
		return length;
	}
	public int getWidth()
	{
	    return width;
	}
	public String toString()
	{
		return getClass().getName() + " - " + getLength() + " X " + getWidth();
	}
	public int getHeight()
	{
		return 0; // A rectangle has no height
	}
	public boolean equals(Rectangle3 testRect)
	{
		if (getLength() == testRect.getLength() && getWidth() == testRect.getWidth() && getHeight() == testRect.getHeight())
			return true;
		return false;
	}
}
