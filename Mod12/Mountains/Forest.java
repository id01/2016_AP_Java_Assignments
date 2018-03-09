// Gavin Lo
// March 21, 2017
// This program is a forest terrain. It has trees.

public class Forest extends Terrain
{
	private int trees;

	public Forest(int l, int w, int ts)
	{
		super(l, w);
		name = "Forest";
		trees = ts;
	}

	public String getNumTrees()
	{
		return trees + " trees";
	}
}
