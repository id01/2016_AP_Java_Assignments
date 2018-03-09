// Gavin Lo
// 04-25-2017
// This program tests the Candidate class using an array and recursion

public class TestCandidate
{
	public static void printVotes(Candidate [] election)
	{
		for ( Candidate person : election ) {
			System.out.printf("%s got %d votes\n", person.getName(), person.getVotes());
		}
	}

	public static int getTotal(Candidate [] election)
	{
		int totalVotes = 0;
		for ( Candidate person : election ) {
			totalVotes += person.getVotes();
		}
		return totalVotes;
	}

	public static void printResults(Candidate [] election)
	{
		int totalVotes = getTotal(election);
		System.out.printf("| %16s | %8s | %8s |\n", "name", "votes", "percent");
		System.out.println("------------------------------------------");
		for ( Candidate person : election ) {
			System.out.printf("| %16s | %8d | %8.2f%%|\n", person.getName(), person.getVotes(), 100.0*person.getVotes()/totalVotes);
		}
		System.out.printf("| %16s | %8d | %8.2f%%|\n", "Total", totalVotes, 100.0);
	}

	public static void main(String [] args)
	{
		// Create array
		Candidate [] election = new Candidate[] {
			new Candidate("John Smith", 5000),
			new Candidate("Mary Miller", 4000),
			new Candidate("Michael Duffy", 6000),
			new Candidate("Tim Robinson", 2500),
			new Candidate("Joe Ashtony", 1800)
		};

		// Header
		System.out.println("Results per candidate:");
		System.out.println("-----------------------");

		// Tests printVotes
		printVotes(election);

		// 2-line Gap
		System.out.println("\n");

		// Tests printResults
		printResults(election);
	}
}
