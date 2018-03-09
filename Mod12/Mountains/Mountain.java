// Gavin Lo
// March 21, 2017
// This program is a mountain terrain. It has mountains.

public class Mountain extends Terrain
{
	private int mountains;

	public Mountain(int l, int w, int mounts)
	{
		super(l, w);
		name = "Mountain";
		mountains = mounts;
	}

	public String getNumMountains()
	{
		return mountains + " mountains";
	}
}
