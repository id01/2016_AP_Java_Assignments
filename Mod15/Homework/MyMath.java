// Gavin Lo
// Apr 6, 2017
// This program is a class that implements the Homework class.

public class MyMath extends Homework
{
	public MyMath() {
		super();
	}

	public void createAssignment(int p) {
		super.setPagesRead(p);
		super.setTypeHomework("Math");
	}

	public String toString() {
		return super.getPagesRead() + " pages of " + super.getTypeHomework() + " homework.";
	}
}
