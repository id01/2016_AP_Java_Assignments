// Gavin Lo
// 05-03-2017
// This is the class representing a movie

public class Movie2
{
	private String title, studio;
	private int year;

	public Movie2(String title, int year, String studio)
	{
		this.title = title;
		this.year = year;
		this.studio = studio;
	}

	// Getter + Setter methods
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}
}