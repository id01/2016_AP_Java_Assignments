// Gavin Lo
// 04-25-2017
// This program tests the Candidate class using an array and traversals
// It now also uses replacements.

import java.util.ArrayList;

public class TestCandidate4
{
	public static void printVotes(ArrayList<Candidate> election)
	{
		for ( Candidate person : election ) {
			System.out.printf("%s got %d votes\n", person.getName(), person.getVotes());
		}
	}

	public static int getTotal(ArrayList<Candidate> election)
	{
		int totalVotes = 0;
		for ( Candidate person : election ) {
			totalVotes += person.getVotes();
		}
		return totalVotes;
	}

	public static void printResults(ArrayList<Candidate> election)
	{
		int totalVotes = getTotal(election);
		System.out.printf("| %16s | %8s | %8s |\n", "name", "votes", "percent");
		System.out.println("------------------------------------------");
		for ( Candidate person : election ) {
			System.out.printf("| %16s | %8d | %8.2f%%|\n", person.getName(), person.getVotes(), 100.0*person.getVotes()/totalVotes);
		}
		System.out.printf("| %16s | %8d | %8.2f%%|\n", "Total", totalVotes, 100.0);
	}

	public static void replaceName(ArrayList<Candidate> election, String needle, String replacement)
	{
		for ( Candidate person : election ) {
			if ( person.getName().equalsIgnoreCase(needle) )
				person.setName(replacement);
		}
	}

	public static void replaceVotes(ArrayList<Candidate> election, String needle, int newVotes)
	{
		for ( Candidate person : election ) {
			if ( person.getName().equalsIgnoreCase(needle) )
				person.setVotes(newVotes);
		}
	}

	public static void replaceCandidate(ArrayList<Candidate> election, String needle, String replacement, int newVotes)
	{
		for ( Candidate person : election ) {
			if ( person.getName().equalsIgnoreCase(needle) ) {
				person.setName(replacement);
				person.setVotes(newVotes);
			}
		}
	}

	public static void main(String [] args)
	{
		// Create array
		ArrayList<Candidate> election = new ArrayList<Candidate> ();
			election.add(new Candidate("John Smith", 5000));
			election.add(new Candidate("Mary Miller", 4000));
			election.add(new Candidate("Michael Duffy", 6000));
			election.add(new Candidate("Tim Robinson", 2500));
			election.add(new Candidate("Joe Ashtony", 1800));
			election.add(new Candidate("Mickey Jones", 3000));
			election.add(new Candidate("Rebecca Morgan", 2000));
			election.add(new Candidate("Kathleen Turner", 8000));
			election.add(new Candidate("Tory Parker", 500));
			election.add(new Candidate("Ashton Davis", 100000));

		// Header
		System.out.println("Results per candidate:");
		System.out.println("-----------------------");

		// Tests printVotes
		printVotes(election);

		// 2-line Gap
		System.out.println("\n");

		// Tests printResults
		printResults(election);

		// Replacement tests
		System.out.println("\n\nReplacing Michael Duffy with John Elmos:\n");
		replaceName(election, "Michael Duffy", "John Elmos");
		printResults(election);

		System.out.println("\n\nChanging Mickey Jones' votes to 2500:\n");
		replaceVotes(election, "Mickey Jones", 2500);
		printResults(election);

		System.out.println("\n\nReplacing Kathleen Turner with John Kennedy and changing votes to 8500:\n");
		replaceCandidate(election, "Kathleen Turner", "John Kennedy", 8500);
		printResults(election);
	}
}
