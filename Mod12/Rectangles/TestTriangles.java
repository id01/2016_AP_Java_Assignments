// Gavin Lo
// March 17, 2017
// This program tests the triangle classes

public class TestTriangles
{
	public static void main(String [] args)
	{
		Triangle tri = new Triangle(4, 5, 6);
		Equilateral equ = new Equilateral(5);
		IsoscelesRight iso = new IsoscelesRight(1.5);
		System.out.printf("Triangle has sides A = %.1f, B = %.1f, C = %.1f\n", tri.getSideA(), tri.getSideB(), tri.getSideC());
		System.out.printf("Equilateral Triangle has sides A = %.1f, B = %.1f, C = %.1f\n", equ.getSideA(), equ.getSideB(), equ.getSideC());
		System.out.printf("Isosceles Right Triangle has sides A = %.1f, B = %.1f, C = %.1f\n", iso.getSideA(), iso.getSideB(), iso.getSideC());
	}
}