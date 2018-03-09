// Gavin Lo
// March 7, 2017
// This program finds the distance of different projectiles with different speeds and degrees.
// This program is the main calculation class.
// Note: AngleIn should be specified in degrees, speedIn should be specified in mph.
// DistanceTravelled is in ft.
// March 1, 2017
// This program was modified to use the this keyword.

public class Catapult
{
	// Variables
	private final double gravity = 9.8; // Gravity (Constant on Earth)
	private double launchSpeed;
	private double launchAngle;
	private double distanceTravelled;

	// This initializes the variables
	public Catapult(double launchAngle, double launchSpeed)
	{
		this.launchSpeed = launchSpeed;
		this.launchAngle = launchAngle;
	}

	// This converts units
	public void convertUnits()
	{
		launchSpeed = launchSpeed * 0.447;
		launchAngle = Math.toRadians(launchAngle);
	}

	// This calculates the distance
	public void calcDistance()
	{
		double numerator = Math.pow(launchSpeed, 2)*Math.sin(2*launchAngle);
		double distanceTravelledMeters = numerator/gravity;
		distanceTravelled = distanceTravelledMeters * 3.28084;
	}

	// This returns the distance travelled
	public double getDistanceTravelled()
	{
		return distanceTravelled;
	}
}