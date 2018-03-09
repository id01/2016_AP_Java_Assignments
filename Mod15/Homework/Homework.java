// Gavin Lo
// Apr 6, 2017
// This program is an abstract class for Homwork. It is implemented by other classes.

public abstract class Homework
{
	// Instance vars and constructor
	int pagesRead;
	String typeHomework;

	public Homework() {
		pagesRead = 0;
		typeHomework = "none";
	}

	// Abstract createAssignment method
	public abstract void createAssignment(int p);

	// Getter/Setter methods
	public void setPagesRead(int pagesRead) {
		this.pagesRead = pagesRead;
	}
	public int getPagesRead() {
		return pagesRead;
	}
	public void setTypeHomework(String typeHomework) {
		this.typeHomework = typeHomework;
	}
	public String getTypeHomework() {
		return typeHomework;
	}
}
