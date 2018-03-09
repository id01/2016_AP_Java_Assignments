/**
 * Blank terrain.
 * 
 * 
 * @author R. Enger 
 * @version 5/5/2007
 * Modified by: Gavin Lo
 * March 21, 2017
 */
public class Terrain
{
	String name;
	// instance variables 
	private int length, width;

	/**
	 * Constructor for objects of class terrain
	 */
	public Terrain(int l, int w)
	{
		// initialise instance variables
		name = "";
		length = l;
		width = w;
	}


	public String terrainSize()
	{
		return name + " Land has dimensions " + length + " X " + width;
	}
}
