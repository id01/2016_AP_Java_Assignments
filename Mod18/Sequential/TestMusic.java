// Gavin Lo
// 05-11-2017
// This program tests the music class by making a music library and searching through it using sequential search

public class TestMusic
{
	public static void printMusic(Music[] music) {
		for (Music entry : music) {
			System.out.println(entry);
		}
	}

	public static void printResults(Music[] music) {
		if (music == null) {
			System.out.println("No results found.");
		} else {
			for (Music entry : music) {
				System.out.println(entry);
			}
			System.out.println(music.length + " results found.");
		}
	}

	// Searches through a music library for all musics with a certain title.
	public static Music[] searchTitle(Music[] myMusic, String title) {
		Music[] results = new Music[myMusic.length];
		// Look through the array for all possible results and add all to results array.
		int pos = 0;
		for (Music entry : myMusic) {
			if (entry.getTitle().equalsIgnoreCase(title)) {
				results[pos] = entry;
				pos++;
			}
		}
		// Trim the array and return. If there are no elements, return null.
		if (pos == 0) {
			return null;
		} else {
			Music[] toReturn = new Music[pos];
			for (int i=0; i<toReturn.length; i++) {
				toReturn[i] = results[i];
			}
			return toReturn;
		}
	}

	// Searches through a music library for all musics with a certain year.
	public static Music[] searchYear(Music[] myMusic, int year) {
		Music[] results = new Music[myMusic.length];
		// Look through the array for all possible results and add all to results array.
		int pos = 0;
		for (Music entry : myMusic) {
			if (entry.getYear() == year) {
				results[pos] = entry;
				pos++;
			}
		}
		// Trim the array and return. If there are no elements, return null.
		if (pos == 0) {
			return null;
		} else {
			Music[] toReturn = new Music[pos];
			for (int i=0; i<toReturn.length; i++) {
				toReturn[i] = results[i];
			}
			return toReturn;
		}
	}

	// Searches through a music library for all musics with a certain singer.
	public static Music[] searchSinger(Music[] myMusic, String singer) {
		Music[] results = new Music[myMusic.length];
		// Look through the array for all possible results and add all to results array.
		int pos = 0;
		for (Music entry : myMusic) {
			if (entry.getSinger().equalsIgnoreCase(singer)) {
				results[pos] = entry;
				pos++;
			}
		}
		// Trim the array and return. If there are no elements, return null.
		if (pos == 0) {
			return null;
		} else {
			Music[] toReturn = new Music[pos];
			for (int i=0; i<toReturn.length; i++) {
				toReturn[i] = results[i];
			}
			return toReturn;
		}
	}

	public static void main(String [] args) {
		// Construct array
		Music[] myMusic = new Music[] {
			new Music("Pieces of You", 1994, "Jewel"),
			new Music("Jagged Little Pill", 1995, "Alanis Morissette"),
			new Music("What if It's You", 1995, "Reba McEntire"),
			new Music("Misunderstood", 2001, "Pink"),
			new Music("Laundry Service", 2001, "Shakira"),
			new Music("Taking the Long Way", 2006, "Dixie Chicks"),
			new Music("Under My Skin", 2004, "Avril Lavigne"),
			new Music("Let Go", 2002, "Avril Lavigne"),
			new Music("Let It Go", 2007, "TIm McGraw"),
			new Music("White Flag", 2004, "Dido")
		};
		Music[] results;

		System.out.println("Music Library:");
		printMusic(myMusic);
		System.out.println();

		// Test searchTitle
		System.out.println("\nSearching for title 'Let Go':");
		printResults(searchTitle(myMusic, "let go"));
		System.out.println("\nSearching for title 'Some Day':");
		printResults(searchTitle(myMusic, "some day"));
		System.out.println();

		// Test searchYear
		System.out.println("\nSearching for year 2001:");
		printResults(searchYear(myMusic, 2001));
		System.out.println("\nSearching for year 2003:");
		printResults(searchYear(myMusic, 2003));
		System.out.println();

		// Test searchSinger
		System.out.println("\nSearching for singer 'Avril Lavigne':");
		printResults(searchSinger(myMusic, "Avril Lavigne"));
		System.out.println("\nSearching for singer 'Tony Curtis':");
		printResults(searchSinger(myMusic, "Tony Curtis"));
	}
}
