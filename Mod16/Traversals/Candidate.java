// Gavin Lo
// 04-25-2017
// This program represents a presidential candidate.

public class Candidate
{
	private String name;
	private int numVotes;

	public Candidate(String name, int numVotes) {
		this.name = name;
		this.numVotes = numVotes;
	}

	public Candidate(String name) {
		this.name = name;
		this.numVotes = 0;
	}

	public String getName() {
		return name;
	}

	public int getVotes() {
		return numVotes;
	}

	public void addVotes(int votes) {
		numVotes += votes;
	}

	public String toString() {
		return name;
	}
}
