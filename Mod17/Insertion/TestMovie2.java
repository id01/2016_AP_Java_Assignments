// Gavin Lo
// 05-04-2017
// This program tests the Movie2 class. It uses Insertion sort.

public class TestMovie2
{
	// This function prints the movies
	public static void printMovies(Movie2[] myMovies) {
		System.out.printf("|%-40s|%-8s|%-28s|\n", "Title", "Year", "Studio");
		for (Movie2 movie : myMovies) {
			if (movie != null)
				System.out.printf("|%-40s|%-8d|%-28s|\n", movie.getTitle(), movie.getYear(), movie.getStudio());
		}
	}

	// This function moves everything up after point in array
	public static Movie2[] moveUp(Movie2[] toMove, int fromIndex) {
		Movie2[] moved = new Movie2[toMove.length];
		int increment = 0;
		for (int i=0; i<toMove.length; i++) {
			if (i == fromIndex)
				increment = 1;
			if (toMove[i] == null)
				break;
			moved[i+increment] = toMove[i];
		}
		return moved;
	}

	// This function reverses an array
	public static Movie2[] reverseArray(Movie2[] toReverse) {
		Movie2[] reversed = new Movie2[toReverse.length];
		for (int i=0; i<toReverse.length; i++) {
			reversed[toReverse.length-i-1] = toReverse[i];
		}
		return reversed;
	}

	// This function sorts the movies by title
	public static Movie2[] sortTitles(Movie2[] myMovies, int mode) {
		Movie2[] newMyMovies = new Movie2[myMovies.length];
		// Do this for every movie
		for (Movie2 movie : myMovies) {
			// Iterate through newMyMovies to place that one movie
			for (int i=0; i<newMyMovies.length; i++) {
				// If movie is null or newMyMovies is less than movie alphabetically
				if (newMyMovies[i] == null || newMyMovies[i].getTitle().compareTo(movie.getTitle()) > 0) {
					newMyMovies = moveUp(newMyMovies, i); // Move everything after it up
					newMyMovies[i] = movie; // Replace that one movie
					i=newMyMovies.length+1; // Stop
				}
			}
		}
		// If move is descending, reverse the array.
		if (mode > 1) {
			newMyMovies = reverseArray(newMyMovies);
		}
		return newMyMovies;
	}

	// This function sorts the movies by year
	public static Movie2[] sortYears(Movie2[] myMovies, int mode) {
		Movie2[] newMyMovies = new Movie2[myMovies.length];
		// Do this for every movie
		for (Movie2 movie : myMovies) {
			// Iterate through newMyMovies to place that one movie
			for (int i=0; i<newMyMovies.length; i++) {
				// If movie is null or newMyMovies is less than movie alphabetically
				if (newMyMovies[i] == null || newMyMovies[i].getYear() < movie.getYear()) {
					newMyMovies = moveUp(newMyMovies, i); // Move everything after it up
					newMyMovies[i] = movie; // Replace that one movie
					i=newMyMovies.length+1; // Stop
				}
			}
		}
		// If move is descending, reverse the array.
		if (mode > 1) {
			newMyMovies = reverseArray(newMyMovies);
		}
		return newMyMovies;
	}

	// This function sorts the movies by studio
	public static Movie2[] sortStudios(Movie2[] myMovies, int mode) {
		Movie2[] newMyMovies = new Movie2[myMovies.length];
		// Do this for every movie
		for (Movie2 movie : myMovies) {
			// Iterate through newMyMovies to place that one movie
			for (int i=0; i<newMyMovies.length; i++) {
				// If movie is null or newMyMovies is less than movie alphabetically
				if (newMyMovies[i] == null || newMyMovies[i].getStudio().compareTo(movie.getStudio()) > 0) {
					newMyMovies = moveUp(newMyMovies, i); // Move everything after it up
					newMyMovies[i] = movie; // Replace that one movie
					i=newMyMovies.length+1; // Stop
				}
			}
		}
		// If move is descending, reverse the array.
		if (mode > 1) {
			newMyMovies = reverseArray(newMyMovies);
		}
		return newMyMovies;
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
