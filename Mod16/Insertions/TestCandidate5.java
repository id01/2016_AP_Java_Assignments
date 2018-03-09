// Gavin Lo
// 04-27-2017
// This program tests the Candidate class using an array and traversals
// It now also uses replacements and insertions.

public class TestCandidate5
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

	public static void replaceName(Candidate [] election, String needle, String replacement)
	{
		for ( Candidate person : election ) {
			if ( person.getName().equalsIgnoreCase(needle) )
				person.setName(replacement);
		}
	}

	public static void replaceVotes(Candidate [] election, String needle, int newVotes)
	{
		for ( Candidate person : election ) {
			if ( person.getName().equalsIgnoreCase(needle) )
				person.setVotes(newVotes);
		}
	}

	public static void replaceCandidate(Candidate [] election, String needle, String replacement, int newVotes)
	{
		for ( Candidate person : election ) {
			if ( person.getName().equalsIgnoreCase(needle) ) {
				person.setName(replacement);
				person.setVotes(newVotes);
			}
		}
	}

	public static Candidate[] insertPosition(Candidate [] election, int needle, String name, int votes) 
	{
		Candidate newCandidate = new Candidate(name, votes);
		Candidate [] newElection = new Candidate[election.length+1];
		int i = 0;
		for ( Candidate person : election ) {
			if ( i == needle ) {
				newElection[i] = newCandidate;
				i++;
			}
			newElection[i] = person;
			i++;
		}
		return newElection;
	}

	public static Candidate[] insertCandidate(Candidate [] election, String needle, String name, int votes) 
	{
		Candidate newCandidate = new Candidate(name, votes);
		Candidate [] newElection = new Candidate[election.length+1];
		int i = 0;
		for ( Candidate person : election ) {
			if ( person.getName().equalsIgnoreCase(needle) ) {
				newElection[i] = newCandidate;
				i++;
			}
			newElection[i] = person;
			i++;
		}
		return newElection;
	}

	public static void main(String [] args)
	{
		// Create array
		Candidate [] election = new Candidate[] {
			new Candidate("John Smith", 5000),
			new Candidate("Mary Miller", 4000),
			new Candidate("Michael Duffy", 6000),
			new Candidate("Tim Robinson", 2500),
			new Candidate("Joe Ashtony", 1800),
			new Candidate("Mickey Jones", 3000),
			new Candidate("Rebecca Morgan", 2000),
			new Candidate("Kathleen Turner", 8000),
			new Candidate("Tory Parker", 500),
			new Candidate("Ashton Davis", 100000)
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

		// Insertion Tests
		System.out.println("\n\nAdding Woody Pride;\n");
		election = insertPosition(election, 5, "Woody Pride", 19300);
		printResults(election);
		System.out.println("\n\nAdding Kathleen Turner:\n");
		election = insertCandidate(election, "Kathleen Turner", "Joy Anderson", 1100);
		printResults(election);
	}
}
