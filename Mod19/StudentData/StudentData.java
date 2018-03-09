// Gavin Lo
// 5-23-2017
// This program demonstrates usage of exceptions. It represents the data for a particular
// student in a particular course.

public class StudentData {
	String firstName, lastName;
	double [] testScores;
	char grade;

	public StudentData(String firstName, String lastName, double[] testScores) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.testScores = testScores;
		courseGrade(testScores);
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double[] getTestScores() {
		return testScores;
	}
	public char getGrade() {
		return grade;
	}
	public void setTestScores(double [] newScores) {
		testScores = newScores;
	}

	public void courseGrade(double [] list) {
		if (list == null || list.length == 0) {
			throw new IllegalArgumentException("List must have at least one entry and must not be null.");
		}
		int average = 0;
		for (double a : list) {
			average += a;
		}
		average /= list.length;
		if (average >= 90) {
			grade = 'A';
		} else if (average >= 80) {
			grade = 'B';
		} else if (average >= 70) {
			grade = 'C';
		} else if (average >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
	}

	public String toString() {
		String toReturn = firstName+"\t"+lastName+"\t";
		for (double a : testScores) {
			toReturn += a + " ";
		}
		toReturn += grade;
		return toReturn;
	}
}
