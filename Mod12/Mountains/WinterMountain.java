// Gavin Lo
// March 21, 2017
// This program is a winter mountain terrian and is like the mountain terrian,
// but has a temperature too

public class WinterMountain extends Mountain
{
	private double temperature;

	public WinterMountain(int l, int w, int mounts, double temp)
	{
		super(l,w,mounts);
		name = "Winter Mountain";
		temperature = temp;
	}

	public String getTemperature()
	{
		return "temperature " + temperature;
	}
}
