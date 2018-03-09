// Gavin Lo
// 04-27-2017
// This program tests the Candidate class using an array and traversals
// It now also uses replacements and insertions

import java.util.ArrayList;

public class TestCandidate6
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

	public static void insertPosition(ArrayList<Candidate> election, int needle, String name, int votes)
	{
		election.add(needle, new Candidate(name, votes)); // That was easy
	}

	public static void insertCandidate(ArrayList<Candidate> election, String needle, String name, int votes)
	{
		int locationToAdd = election.size();
		for (int i=0; i<election.size(); i++) {
			if ( election.get(i).getName().equalsIgnoreCase(needle) )
				locationToAdd = i;
		}
		election.add(locationToAdd, new Candidate(name, votes));
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

		// Insertion Tests
		System.out.println("\n\nAdding Woody Pride;\n");
		insertPosition(election, 5, "Woody Pride", 19300);
		printResults(election);
		System.out.println("\n\nAdding Kathleen Turner:\n");
		insertCandidate(election, "Kathleen Turner", "Joy Anderson", 1100);
		printResults(election);
	}
}
