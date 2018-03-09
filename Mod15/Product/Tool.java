// Gavin Lo
// 04-19-2017
// This program is another class that extends to Product class.

public class Tool implements Product, Comparable<Tool>
{
	private String name;
	private double cost;

	public Tool(String name, double cost)
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

	public int compareTo(Tool other)
	{
		return (int)getCost() - (int)other.getCost();
	}
}
