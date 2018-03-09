// Gavin Lo
// 05-23-2017
// This program tests the StudentData class.

public class TestProgStudentData {
	public static void main(String [] args) {
		// Valid:
		double [] myData = new double[] {89.0, 78.0, 95.0, 63.0, 94.0};
		StudentData student = new StudentData("John", "Doe", myData);
		System.out.println(student);
		StudentData student2 = new StudentData("Lindsay", "Green", new double[] {88.0, 90.0, 100.0, 88.0, 90.0, 100.0});
		System.out.println(student2);
		// Exception:
		//StudentData student3 = new StudentData("Crash", "Bait", null);
		//System.out.println(student3);
		//StudentData student4 = new StudentData("Crash", "2", new double[]{});
		//System.out.println(student4);
	}
}
