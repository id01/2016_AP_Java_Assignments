// Gavin Lo
// 05-11-2017
// This program tests the music class by making a music library and searching through it using sequential search

public class TestMusic2
{
	public static void printMusic(Music2[] music) {
		for (Music2 entry : music) {
			System.out.println(entry);
		}
	}

	public static void printResults(Music2[] music) {
		if (music == null) {
			System.out.println("No results found.");
		} else {
			for (Music2 entry : music) {
				System.out.println(entry);
			}
			System.out.println(music.length + " results found.");
		}
	}

	// This function does a selection sort on Music2
	public static Music2[] selectionSortTitle(Music2[] myMusic) {
		int afterIndex; String afterValue;
		Music2 swapper;
		for (int lengthLeft = myMusic.length; lengthLeft > 1; lengthLeft--) {
			afterIndex = 0; afterValue = "";
			for (int i=0; i<lengthLeft; i++) {
				if (myMusic[i].getTitle().compareTo(afterValue) > 0) {
					afterIndex = i;
					afterValue = myMusic[i].getTitle();
				}
			}
			swapper = myMusic[afterIndex];
			myMusic[afterIndex] = myMusic[lengthLeft-1];
			myMusic[lengthLeft-1] = swapper;
		}
		return myMusic;
	}

	// Searches through a music library for all musics with a certain title.
	public static Music2[] searchTitle(Music2[] myMusic, String title) {
		Music2[] results = new Music2[myMusic.length];
		// Look through the array for a specified title
		int pos = myMusic.length/2;
		int increment = pos/2+pos%2;
		while (pos < myMusic.length && pos >= 0) {
			if (myMusic[pos].getTitle().compareTo(title) < 0) {
				pos += increment;
			} else if (myMusic[pos].getTitle().compareTo(title) > 0) {
				pos -= increment;
			} else {
				increment = -1;
				break; // We found it!
			}
			if (increment == 1) {
				// It has already incremented. Is this it? If yes, we found it. Else, fail
				if (myMusic[pos].getTitle().compareTo(title) == 0) {
					increment = -1;
				}
				break;
			}
			increment = increment/2+increment%2;
		}
		if (increment == -1) {
			// Look for other ones adjacent to it
			int resultpos = 0;
			for (int i=pos; i>=0; i--) {
				if (myMusic[i].getTitle().compareTo(title) == 0) {
					results[resultpos] = myMusic[i];
					resultpos++;
				}
			}
			for (int i=pos+1; i<myMusic.length; i++) {
				if (myMusic[i].getTitle().compareTo(title) == 0) {
					results[resultpos] = myMusic[i];
					resultpos++;
				}
			}
			// Truncate
			int toReturnLength = 0;
			for (int i=0; i<results.length; i++) {
				if (results[i] == null) {
					toReturnLength = i;
					break;
				}
			}
			Music2[] toReturn = new Music2[toReturnLength];
			for (int i=0; i<toReturn.length; i++) {
				toReturn[i] = results[i];
			}
			return toReturn;
		} else {
			return null; // No results
		}
	}

	// This function does a selection sort on Music2
	public static Music2[] selectionSortYear(Music2[] myMusic) {
		int afterIndex, afterValue;
		Music2 swapper;
		for (int lengthLeft = myMusic.length; lengthLeft > 1; lengthLeft--) {
			afterIndex = 0; afterValue = 0;
			for (int i=0; i<lengthLeft; i++) {
				if (myMusic[i].getYear() > afterValue) {
					afterIndex = i;
					afterValue = myMusic[i].getYear();
				}
			}
			swapper = myMusic[afterIndex];
			myMusic[afterIndex] = myMusic[lengthLeft-1];
			myMusic[lengthLeft-1] = swapper;
		}
		return myMusic;
	}

	// Searches through a music library for all musics with a certain year.
	public static Music2[] searchYear(Music2[] myMusic, int year) {
		Music2[] results = new Music2[myMusic.length];
		// Look through the array for a specified title
		int pos = myMusic.length/2;
		int increment = pos/2+pos%2;
		while (pos < myMusic.length && pos >= 0) {
			if (myMusic[pos].getYear() < year) {
				pos += increment;
			} else if (myMusic[pos].getYear() > year) {
				pos -= increment;
			} else {
				increment = -1;
				break; // We found it!
			}
			if (increment == 1) {
				// It has already incremented. Is this it? If yes, we found it. Else, fail
				if (myMusic[pos].getYear() == year) {
					increment = -1;
				}
				break;
			}
			increment = increment/2+increment%2;
		}
		if (increment == -1) {
			// Look for other ones adjacent to it
			int resultpos = 0;
			for (int i=pos; i>=0; i--) {
				if (myMusic[i].getYear() == year) {
					results[resultpos] = myMusic[i];
					resultpos++;
				}
			}
			for (int i=pos+1; i<myMusic.length; i++) {
				if (myMusic[i].getYear() == year) {
					results[resultpos] = myMusic[i];
					resultpos++;
				}
			}
			// Truncate
			int toReturnLength = 0;
			for (int i=0; i<results.length; i++) {
				if (results[i] == null) {
					toReturnLength = i;
					break;
				}
			}
			Music2[] toReturn = new Music2[toReturnLength];
			for (int i=0; i<toReturn.length; i++) {
				toReturn[i] = results[i];
			}
			return toReturn;
		} else {
			return null; // No results
		}
	}

	// This function does a selection sort on Music2
	public static Music2[] selectionSortSinger(Music2[] myMusic) {
		int afterIndex; String afterValue;
		Music2 swapper;
		for (int lengthLeft = myMusic.length; lengthLeft > 1; lengthLeft--) {
			afterIndex = 0; afterValue = "";
			for (int i=0; i<lengthLeft; i++) {
				if (myMusic[i].getSinger().compareTo(afterValue) > 0) {
					afterIndex = i;
					afterValue = myMusic[i].getSinger();
				}
			}
			swapper = myMusic[afterIndex];
			myMusic[afterIndex] = myMusic[lengthLeft-1];
			myMusic[lengthLeft-1] = swapper;
		}
		return myMusic;
	}

	// Searches through a music library for all musics with a certain title.
	public static Music2[] searchSinger(Music2[] myMusic, String singer) {
		Music2[] results = new Music2[myMusic.length];
		// Look through the array for a specified title
		int pos = myMusic.length/2;
		int increment = pos/2+pos%2;
		while (pos < myMusic.length && pos >= 0) {
			if (myMusic[pos].getSinger().compareTo(singer) < 0) {
				pos += increment;
			} else if (myMusic[pos].getSinger().compareTo(singer) > 0) {
				pos -= increment;
			} else {
				increment = -1;
				break; // We found it!
			}
			if (increment == 1) {
				// It has already incremented. Is this it? If yes, we found it. Else, fail
				if (myMusic[pos].getSinger().compareTo(singer) == 0) {
					increment = -1;
				}
				break;
			}
			increment = increment/2+increment%2;
		}
		if (increment == -1) {
			// Look for other ones adjacent to it
			int resultpos = 0;
			for (int i=pos; i>=0; i--) {
				if (myMusic[i].getSinger().compareTo(singer) == 0) {
					results[resultpos] = myMusic[i];
					resultpos++;
				}
			}
			for (int i=pos+1; i<myMusic.length; i++) {
				if (myMusic[i].getSinger().compareTo(singer) == 0) {
					results[resultpos] = myMusic[i];
					resultpos++;
				}
			}
			// Truncate
			int toReturnLength = 0;
			for (int i=0; i<results.length; i++) {
				if (results[i] == null) {
					toReturnLength = i;
					break;
				}
			}
			Music2[] toReturn = new Music2[toReturnLength];
			for (int i=0; i<toReturn.length; i++) {
				toReturn[i] = results[i];
			}
			return toReturn;
		} else {
			return null; // No results
		}
	}

	public static void main(String [] args) {
		// Construct array
		Music2[] myMusic = new Music2[] {
			new Music2("Pieces of You", 1994, "Jewel"),
			new Music2("Jagged Little Pill", 1995, "Alanis Morissette"),
			new Music2("What if It's You", 1995, "Reba McEntire"),
			new Music2("Misunderstood", 2001, "Pink"),
			new Music2("Laundry Service", 2001, "Shakira"),
			new Music2("Taking the Long Way", 2006, "Dixie Chicks"),
			new Music2("Under My Skin", 2004, "Avril Lavigne"),
			new Music2("Let Go", 2002, "Avril Lavigne"),
			new Music2("Let It Go", 2007, "Tim McGraw"),
			new Music2("White Flag", 2004, "Dido")
		};
		Music2[] results;

		System.out.println("Music Library:");
		printMusic(myMusic);
		System.out.println();

		// Test searchTitle
		System.out.println("\nSorted by title: ");
		myMusic = selectionSortTitle(myMusic);
		printResults(myMusic);
		System.out.println("\nSearching for title 'Misunderstood':");
		printResults(searchTitle(myMusic, "Misunderstood"));
		System.out.println("\nSearching for title 'Under Paid':");
		printResults(searchTitle(myMusic, "Under Paid"));
		System.out.println();

		// Test searchYear
		System.out.println("\nSorted by year: ");
		myMusic = selectionSortYear(myMusic);
		printResults(myMusic);
		System.out.println("\nSearching for year 2005:");
		printResults(searchYear(myMusic, 2005));
		System.out.println("\nSearching for year 2006:");
		printResults(searchYear(myMusic, 2006));
		System.out.println();

		// Test searchSinger
		System.out.println("\nSorted by singer: ");
		myMusic = selectionSortSinger(myMusic);
		System.out.println("\nSearching for singer 'Avril Lavigne':");
		printResults(searchSinger(myMusic, "Avril Lavigne"));
		System.out.println("\nSearching for singer 'Tony Curtis':");
		printResults(searchSinger(myMusic, "Tony Curtis"));
	}
}
