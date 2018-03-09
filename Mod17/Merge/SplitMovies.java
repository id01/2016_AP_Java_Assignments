// Gavin Lo
// 05-10-2017
// This class represents 2 movie arrays that were split
// Used instead of a 2-d array (fixed length required)

public class SplitMovies {
	private Movie2[] array1;
	private Movie2[] array2;

	public SplitMovies(Movie2[] a1, Movie2[] a2) {
		array1 = a1;
		array2 = a2;
	}

	public Movie2[] index(int x) {
		if (x <= 0)
			return array1;
		else
			return array2;
	}

	public void set(int x, Movie2[] newValue) {
		if (x <= 0)
			array1 = newValue;
		else
			array2 = newValue;
	}
}
