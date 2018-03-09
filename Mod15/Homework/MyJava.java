// Gavin Lo
// Apr 6, 2017
// This program is a class that implements the Homework class.

public class MyJava extends Homework
{
	public MyJava() {
		super();
	}

	public void createAssignment(int p) {
		super.setPagesRead(p);
		super.setTypeHomework("Java");
	}

	public String toString() {
		return super.getPagesRead() + " pages of " + super.getTypeHomework() + " homework.";
	}
}
