// Gavin Lo
// 04-25-2017
// This program tests the Candidate class using an arrayList and recursion

import java.util.ArrayList;

public class TestCandidate2
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

	public static void main(String [] args)
	{
		// Create array
		ArrayList<Candidate> election = new ArrayList<Candidate>();
		election.add(new Candidate("John Smith", 5000));
		election.add(new Candidate("Mary Miller", 4000));
		election.add(new Candidate("Michael Duffy", 6000));
		election.add(new Candidate("Tim Robinson", 2500));
		election.add(new Candidate("Joe Ashtony", 1800));

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
