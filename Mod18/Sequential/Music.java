// Gavin Lo
// 05-11-2017
// This program represents a simple entry in a music library

public class Music
{
	String title, singer;
	int year;

	public Music(String title, int year, String singer) {
		this.title = title;
		this.year = year;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getSinger() {
		return singer;
	}

	public String toString() {
		return title + ", " + year + ", " + singer;
	}
}
