/**
 * rectangle Demo.
 * Modified to use this keyword
 * 
 * @author R. Enger 
 * @version 5/5/2007
 * Modified by: Gavin Lo
 */
public class Rectangle
{
	// instance variables 
	private int length;
	private int width;

	/**
	 * Constructor for objects of class rectangle
	 */
	public Rectangle(int length, int width)
	{
		// initialise instance variables
		this.length = length;
		this.width = width;
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
	   
}
