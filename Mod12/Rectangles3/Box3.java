
/**
 * box demo.
 * 
 * 
 * @author R. Enger 
 * @version 5/5/2007
 * Modified by Gavin Lo
 * March 23, 2017
 */
public class Box3 extends Rectangle3
{
	// instance variables 
	private int height;

	/**
	 * Constructor for objects of class box
	 */
	public Box3(int l, int w, int h)
	{
		// call superclass
		super(l, w);
	    // initialise instance variables
		height = h;
	}

	// return the height
	public int getHeight()
	{
		return height;
	}
	public String toString()
	{
		return super.toString() + " X " + getHeight();
	}
}
