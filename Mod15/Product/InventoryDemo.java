// Gavin Lo
// 04-19-2017
// This program demonstrates an inventory of different-classed items.

import java.util.ArrayList;

public class InventoryDemo
{
	public static void takeInventory(ArrayList<Product> products, String name)
	{
		double totalCost = 0; int quantity = 0;
		for ( Product product : products )
		{
			if (product.getName().equals(name))
			{
				totalCost += product.getCost();
				quantity++;
			}
		}
		System.out.printf("%s: Quantity = %d, Total Cost = %.2f\n", name, quantity, totalCost);
	}

	public static void main(String [] args)
	{
		// Constrcut ArrayList
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Car("Jaguar", 1000000));
		products.add(new Truck("Neon", 17000));
		products.add(new Tool("JigSaw", 149.18));
		products.add(new Car("Jaguar", 1100000));
		products.add(new Truck("Neon", 17500));
		products.add(new Truck("Neon", 17875.32));
		products.add(new Car("RAM", 35700.00));
		products.add(new Tool("CircularSaw", 200));
		products.add(new Tool("CircularSaw", 150));
		// Test ArrayList
		takeInventory(products, "Jaguar");
		takeInventory(products, "jigSaw");
		takeInventory(products, "Neon");
		takeInventory(products, "RAM");
		takeInventory(products, "CircularSaw");
		// Test compareTo
		Tool saw1 = new Tool("Saw", 52.1);
		Tool saw2 = new Tool("Saw", 51.2);
		if (saw1.compareTo(saw2) < 0) {
			System.out.println("The second saw is more expensive");
		} else if (saw1.compareTo(saw2) == 0) {
			System.out.println("The saws have the same price");
		} else {
			System.out.println("The first saw is more expensive");
		}
	}
}
