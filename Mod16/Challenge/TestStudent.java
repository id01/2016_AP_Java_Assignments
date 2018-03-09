// Gavin Lo
// 04-28-2017
// This program tests the student class using different elements of algorithms

public class TestStudent
{
	public static void printBook(Student [] students)
	{
		for ( Student student : students ) {
			if (student != null) {
				System.out.println(student);
			} else {
				System.out.println();
			}
		}
		System.out.println();
	}

	// Replaces a student name
	public static Student[] replaceName(Student [] students, String needle, String replacement)
	{
		for ( Student student : students ) {
			if (student != null && student.equalsFirstName(needle)) {
				student.setName(replacement);
			}
		}
		return students;
	}

	// Replaces a quiz score
	public static Student[] replaceQuiz(Student [] students, String needle, int quiz, int score)
	{
		for ( Student student : students ) {
			if (student != null && student.equalsFirstName(needle)) {
				student.setQuiz(quiz, score);
			}
		}
		return students;
	}

	// Replaces a student
	public static Student[] replaceStudent(Student [] students, String needle, String replacement, int [] quizzes)
	{
		for ( Student student : students ) {
			if (student != null && student.equalsFirstName(needle)) {
				student.setName(replacement);
				student.setAllQuizzes(quizzes);
			}
		}
		return students;
	}

	// Inserts a student before another student
	public static Student[] insertStudent(Student [] students, String needle, String replacement, int [] quizzes)
	{
		int toInsert = -1;
		for (int i=0; i<students.length; i++) {
			if (students[i] == null || students[i].equalsFirstName(needle)) {
				toInsert = i;
				i = students.length;
			}
		}
		for (int i=toInsert; i<students.length-1; i++) {
			if (students[i] != null) {
				students[i+1] = students[i]; // If Array isn't long enough this will delete the last student
			}
		}
		students[toInsert] = new Student(replacement, quizzes);
		return students;
	}

	// Deletes a students by first name
	public static Student[] deleteStudent(Student [] students, String needle)
	{
		Student[] newStudents = new Student[students.length];
		int dropped = 0;
		for (int i=0; i<students.length; i++) {
			newStudents[i-dropped] = students[i];
			if (students[i] != null && students[i].equalsFirstName(needle)) {
				dropped++; // Add 1 to dropped. This will be effective next loop
			}
		}
		return newStudents;
	}

	public static void main(String [] args)
	{
		Student [] students = new Student[] {
			new Student("Mark Kennedy", new int[] {70, 80, 90, 100, 90}),
			new Student("Max Gerard", new int[] {80, 85, 90, 85, 80}),
			new Student("Jean Smith", new int[] {50, 79, 89, 99, 100}),
			new Student("Betty Farm", new int[] {85, 80, 85, 88, 89}),
			new Student("Dilbert Gamma", new int[] {70, 70, 90, 70, 80})
		}; // Create student array

		// Test printBook
		printBook(students);

		// Test replaceName
		System.out.println("Betty Farm was adopted by the Boop family:\n");
		students = replaceName(students, "betty", "Betty Boop");
		printBook(students);

		// Test replaceQuiz
		System.out.println("Jean retook quiz #1 and got an 80:\n");
		students = replaceQuiz(students, "jean", 1, 80);
		printBook(students);

		// Test replaceStudent
		System.out.println("Dilbert left the school and Mike Kappa joined:\n");
		students = replaceStudent(students, "dilbert", "Mike Kappa", new int[]{80, 80, 80, 90, 90});
		printBook(students);

		// Test insertStudent
		System.out.println("Lily Mu joined the school in the place before Betty, pushing Mike out:\n");
		students = insertStudent(students, "betty", "Lily Mu", new int[]{85, 95, 70, 0, 100});
		printBook(students);

		// Test deleteStudent
		System.out.println("Max ditched school to help his parents on the farm:\n");
		students = deleteStudent(students, "max");
		printBook(students);

	}
}
