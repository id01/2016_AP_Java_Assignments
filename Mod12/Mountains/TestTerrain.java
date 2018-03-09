// Gavin Lo
// March 21, 2017
// This program tests the different terrains and all their properties

public class TestTerrain
{
	public static void main(String [] args)
	{
		Forest forest = new Forest(100, 200, 100);
		Mountain mount = new Mountain(300, 400, 25);
		WinterMountain wint = new WinterMountain(500, 600, 15, 10.0);

		System.out.println(forest.terrainSize() + " and " + forest.getNumTrees());
		System.out.println(mount.terrainSize() + " and " + mount.getNumMountains());
		System.out.println(wint.terrainSize() + " and has " + wint.getTemperature() + " and " + wint.getNumMountains());
	}
}
