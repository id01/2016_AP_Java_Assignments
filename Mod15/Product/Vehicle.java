// Gavin Lo
// 04-19-2017
// This program represents a veichle. It is an abstract class.

public abstract class Vehicle implements Product
{
	private String name;
	private double cost;

	public Vehicle(String name, double cost)
	{
		this.name = name;
		this.cost = cost;
	}

	public String getName()
	{
		return name;
	}

	public double getCost()
	{
		return cost;
	}
}
