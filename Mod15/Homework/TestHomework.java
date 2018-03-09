// Gavin Lo
// Apr 6, 2017
// This program is the tester class for all the homework classes.

import java.util.ArrayList;

public class TestHomework
{
	public static void main(String [] args)
	{
		ArrayList<Homework> hw = new ArrayList<Homework>();
		hw.add(new MyMath());
		hw.add(new MyScience());
		hw.add(new MyEnglish());
		hw.add(new MyJava());
		hw.get(0).createAssignment(4);
		hw.get(1).createAssignment(6);
		hw.get(2).createAssignment(10);
		hw.get(3).createAssignment(5);
		for (Homework currHw : hw)
		{
			System.out.println("Must read " + currHw);
		}
	}
}
