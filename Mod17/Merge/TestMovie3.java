// Gavin Lo
// 05-05-2017
// This program tests the Movie2 class. It uses Selection sort.

public class TestMovie3
{
	// This function prints the movies
	public static void printMovies(Movie2[] myMovies) {
		System.out.printf("|%-40s|%-8s|%-28s|\n", "Title", "Year", "Studio");
		for (Movie2 movie : myMovies) {
			if (movie != null)
				System.out.printf("|%-40s|%-8d|%-28s|\n", movie.getTitle(), movie.getYear(), movie.getStudio());
			else
				System.out.printf("|%-40s|%-8s|%-28s|\n", "null", "null", "null");
		}
	}

	// This function reverses an array
	public static Movie2[] reverseArray(Movie2[] toReverse) {
		Movie2[] reversed = new Movie2[toReverse.length];
		for (int i=0; i<toReverse.length; i++) {
			reversed[toReverse.length-i-1] = toReverse[i];
		}
		return reversed;
	}

	// This function splits a movie array into two. Returns instance of SplitMovies
	public static SplitMovies splitMovies(Movie2[] myMovies) {
		SplitMovies newMyMovies;
		Movie2[] newMyMovies1 = new Movie2[myMovies.length/2];
		Movie2[] newMyMovies2 = new Movie2[myMovies.length/2+myMovies.length%2];
		for (int i=0; i<newMyMovies1.length; i++) {
			newMyMovies1[i] = myMovies[i];
		}
		for (int i=newMyMovies1.length; i<myMovies.length; i++) {
			newMyMovies2[i-newMyMovies1.length] = myMovies[i];
		}
		newMyMovies = new SplitMovies(newMyMovies1, newMyMovies2);
		return newMyMovies;
	}

	//*****************
	// Sorting Movies by Title

	// Merges 2 arrays by title
	public static Movie2[] mergeMoviesByTitle(Movie2[] newMyMovies1, Movie2[] newMyMovies2) {
		Movie2[] mergedMyMovies = new Movie2[newMyMovies1.length + newMyMovies2.length]; // Joined array
		int i1=0, i2=0;
		while (i1 <= newMyMovies1.length && i2 <= newMyMovies2.length) {
			// If reached the end of one array, perform cleanup.
			if (i1 >= newMyMovies1.length) {
				for (i2=i2; i2<newMyMovies2.length; i2++) {
					mergedMyMovies[i1+i2] = newMyMovies2[i2];
				} break;
			} else if (i2 >= newMyMovies2.length) {
				for (i1=i1; i1<newMyMovies1.length; i1++) {
					mergedMyMovies[i1+i2] = newMyMovies1[i1];
				} break;
			} else {
				// Compare the instances at the i1 and i2 positions of the array
				if (newMyMovies1[i1].getTitle().compareTo(newMyMovies2[i2].getTitle()) < 0) {
					mergedMyMovies[i1+i2] = newMyMovies1[i1]; i1++; // Copy i1 over and increment
				} else {
					mergedMyMovies[i1+i2] = newMyMovies2[i2]; i2++; // Copy i2 over and increment
				}
			}
		}
		// Return
		return mergedMyMovies;
	}

	// This function recurses sorting titles
	public static Movie2[] recurseTitles(Movie2 [] myMovies) {
		SplitMovies myMoviesSplit = splitMovies(myMovies);
		Movie2[] returnValue;
		boolean end0 = (myMoviesSplit.index(0).length <= 1);
		boolean end1 = (myMoviesSplit.index(1).length <= 1);
		if (end0 == true && end1 == false) {
			myMoviesSplit.set(1, recurseTitles(myMoviesSplit.index(1)));
		} else if (end1 == true && end0 == false) {
			myMoviesSplit.set(0, recurseTitles(myMoviesSplit.index(0)));
		} else if (end1 == false && end0 == false) {
			myMoviesSplit.set(0, recurseTitles(myMoviesSplit.index(0)));
			myMoviesSplit.set(1, recurseTitles(myMoviesSplit.index(1)));
		}
		returnValue = mergeMoviesByTitle(myMoviesSplit.index(0), myMoviesSplit.index(1));
		return returnValue;
	}

	// This function sorts the movies by title
	public static Movie2[] sortTitles(Movie2[] myMovies, int mode) {
		myMovies = recurseTitles(myMovies);
		// If move is descending, reverse the array.
		if (mode > 1) {
			myMovies = reverseArray(myMovies);
		}
		return myMovies;
	}

	//*****************
	// Sorting Movies by Year

	// Merges 2 arrays by year
	public static Movie2[] mergeMoviesByYear(Movie2[] newMyMovies1, Movie2[] newMyMovies2) {
		Movie2[] mergedMyMovies = new Movie2[newMyMovies1.length + newMyMovies2.length]; // Joined array
		int i1=0, i2=0;
		while (i1 <= newMyMovies1.length && i2 <= newMyMovies2.length) {
			// If reached the end of one array, perform cleanup.
			if (i1 >= newMyMovies1.length) {
				for (i2=i2; i2<newMyMovies2.length; i2++) {
					mergedMyMovies[i1+i2] = newMyMovies2[i2];
				} break;
			} else if (i2 >= newMyMovies2.length) {
				for (i1=i1; i1<newMyMovies1.length; i1++) {
					mergedMyMovies[i1+i2] = newMyMovies1[i1];
				} break;
			} else {
				// Compare the instances at the i1 and i2 positions of the array
				if (newMyMovies1[i1].getYear() < newMyMovies2[i2].getYear()) {
					mergedMyMovies[i1+i2] = newMyMovies1[i1]; i1++; // Copy i1 over and increment
				} else {
					mergedMyMovies[i1+i2] = newMyMovies2[i2]; i2++; // Copy i2 over and increment
				}
			}
		}
		// Return
		return mergedMyMovies;
	}

	// This function recurses sorting years
	public static Movie2[] recurseYears(Movie2 [] myMovies) {
		SplitMovies myMoviesSplit = splitMovies(myMovies);
		Movie2[] returnValue;
		boolean end0 = (myMoviesSplit.index(0).length <= 1);
		boolean end1 = (myMoviesSplit.index(1).length <= 1);
		if (end0 == true && end1 == false) {
			myMoviesSplit.set(1, recurseYears(myMoviesSplit.index(1)));
		} else if (end1 == true && end0 == false) {
			myMoviesSplit.set(0, recurseYears(myMoviesSplit.index(0)));
		} else if (end1 == false && end0 == false) {
			myMoviesSplit.set(0, recurseYears(myMoviesSplit.index(0)));
			myMoviesSplit.set(1, recurseYears(myMoviesSplit.index(1)));
		}
		returnValue = mergeMoviesByYear(myMoviesSplit.index(0), myMoviesSplit.index(1));
		return returnValue;
	}

	// This function sorts the movies by year
	public static Movie2[] sortYears(Movie2[] myMovies, int mode) {
		myMovies = recurseYears(myMovies);
		// If move is descending, reverse the array.
		if (mode > 1) {
			myMovies = reverseArray(myMovies);
		}
		return myMovies;
	}

	//*****************
	// Sorting Movies by Studio

	// Merges 2 arrays by studio
	public static Movie2[] mergeMoviesByStudio(Movie2[] newMyMovies1, Movie2[] newMyMovies2) {
		Movie2[] mergedMyMovies = new Movie2[newMyMovies1.length + newMyMovies2.length]; // Joined array
		int i1=0, i2=0;
		while (i1 <= newMyMovies1.length && i2 <= newMyMovies2.length) {
			// If reached the end of one array, perform cleanup.
			if (i1 >= newMyMovies1.length) {
				for (i2=i2; i2<newMyMovies2.length; i2++) {
					mergedMyMovies[i1+i2] = newMyMovies2[i2];
				} break;
			} else if (i2 >= newMyMovies2.length) {
				for (i1=i1; i1<newMyMovies1.length; i1++) {
					mergedMyMovies[i1+i2] = newMyMovies1[i1];
				} break;
			} else {
				// Compare the instances at the i1 and i2 positions of the array
				if (newMyMovies1[i1].getStudio().compareTo(newMyMovies2[i2].getStudio()) < 0) {
					mergedMyMovies[i1+i2] = newMyMovies1[i1]; i1++; // Copy i1 over and increment
				} else {
					mergedMyMovies[i1+i2] = newMyMovies2[i2]; i2++; // Copy i2 over and increment
				}
			}
		}
		// Return
		return mergedMyMovies;
	}

	// This function recurses sorting studios
	public static Movie2[] recurseStudios(Movie2 [] myMovies) {
		SplitMovies myMoviesSplit = splitMovies(myMovies);
		Movie2[] returnValue;
		boolean end0 = (myMoviesSplit.index(0).length <= 1);
		boolean end1 = (myMoviesSplit.index(1).length <= 1);
		if (end0 == true && end1 == false) {
			myMoviesSplit.set(1, recurseStudios(myMoviesSplit.index(1)));
		} else if (end1 == true && end0 == false) {
			myMoviesSplit.set(0, recurseStudios(myMoviesSplit.index(0)));
		} else if (end1 == false && end0 == false) {
			myMoviesSplit.set(0, recurseStudios(myMoviesSplit.index(0)));
			myMoviesSplit.set(1, recurseStudios(myMoviesSplit.index(1)));
		}
		returnValue = mergeMoviesByStudio(myMoviesSplit.index(0), myMoviesSplit.index(1));
		return returnValue;
	}

	// This function sorts the movies by title
	public static Movie2[] sortStudios(Movie2[] myMovies, int mode) {
		myMovies = recurseStudios(myMovies);
		// If move is descending, reverse the array.
		if (mode > 1) {
			myMovies = reverseArray(myMovies);
		}
		return myMovies;
	}

	public static void main(String [] args)
	{
		Movie2 [] myMovies = new Movie2[] {
			new Movie2("The Muppets Take Manhattan", 2001, "Columbia Tristar"),
			new Movie2("Mulan Special Edition", 2004, "Disney"),
			new Movie2("Shrek 2", 2004, "Dreamworks"),
			new Movie2("The Incredibles", 2004, "Pixar"),
			new Movie2("Nanny McPhee", 2006, "Universal"),
			new Movie2("The Curse of the Were-Rabbit", 2006, "Aardman"),
			new Movie2("Ice Age", 2002, "20th Century Fox"),
			new Movie2("Lilo & Stitch", 2002, "Disney"),
			new Movie2("Robots", 2005, "20th Century Fox"),
			new Movie2("Monsters Inc.", 2001, "Pixar")
		};

		System.out.println("List of Movies: ");
		printMovies(myMovies);

		System.out.println("\nSorted by title: ");
		myMovies = sortTitles(myMovies, 1);
		printMovies(myMovies);
		System.out.println("\nSorted by descending title: ");
		myMovies = sortTitles(myMovies, 2);
		printMovies(myMovies);

		System.out.println("\nSorted by year: ");
		myMovies = sortYears(myMovies, 1);
		printMovies(myMovies);
		System.out.println("\nSorted by descending year: ");
		myMovies = sortYears(myMovies, 2);
		printMovies(myMovies);

		System.out.println("\nSorted by studio: ");
		myMovies = sortStudios(myMovies, 1);
		printMovies(myMovies);
		System.out.println("\nSorted by descending studio: ");
		myMovies = sortStudios(myMovies, 2);
		printMovies(myMovies);
	}
}
