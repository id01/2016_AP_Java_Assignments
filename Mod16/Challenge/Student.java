// Gavin Lo
// 04-28-2017
// This program represents a student with 5 quizzes
// Used an array for quizzes. Much more portable and easier to handle than a bunch of vars named with numbers

public class Student
{
	private String name;
	private int [] qz;

	public Student(String name, int qzlen) {
		this.name = name;
		qz = new int[qzlen];
	}

	public Student(String name, int [] qz) {
		this.name = name;
		this.qz = qz;
	}

	public int getNumQuizzes() {
		return qz.length;
	}

	public int getQuiz(int index) {
		return qz[index];
	}

	public void setQuiz(int index, int score) {
		qz[index] = score;
	}

	public int[] getAllQuizzes() {
		return qz;
	}

	public void setAllQuizzes(int[] newquizzes) {
		qz = newquizzes;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public boolean equalsFirstName(String test) {
		return name.substring(0, name.indexOf(' ')).equalsIgnoreCase(test);
	}

	public String toString() {
		String toReturn = name + "'s scores:";
		for (int x : qz)
			toReturn += " " + x;
		return toReturn;
	}
}
