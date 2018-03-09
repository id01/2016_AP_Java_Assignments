// Gavin Lo
// This program is the backend class for frequency analysis. It has functions that
// calculate the frequency of each character and attempt to crack a cipher using that
// data.

public class FrequencyAnalysis
{
	private int [] letterFrequencies;
	private double [] percents;

	public FrequencyAnalysis()
	{
		letterFrequencies = new int[26];
		percents = new double[26];
		for (int i=0; i<letterFrequencies.length; i++)
			letterFrequencies[i] = 0;
	}

	// This function adds a word to the letter frequencies. MAKE SURE THE INPUT IS ONE WORD!!!
	public void addWord(String rawword)
	{
		String word = rawword.toLowerCase().trim().replaceAll("[^a-zA-Z]", "");
		int currLetter;
		for (int i=0; i<word.length(); i++)
		{
			currLetter = (int)(word.charAt(i) - 'a');
			letterFrequencies[currLetter]++;
		}
	}

	public int[] getLetterFrequencies()
	{
		return letterFrequencies;
	}

	public void calcPercentFrequencies()
	{
		double total = 0;
		for (int letter : letterFrequencies)
			total += letter;
		for (int i=0; i<letterFrequencies.length; i++)
			percents[i] = letterFrequencies[i]/total*100;
	}

	public double[] getPercents()
	{
		return percents;
	}

	// This function tries to crack a ciphertext based on the letter frequencies
	public String crackCiphertext(double[] cipherPercents, String ciphertextraw)
	{
		double [] percents = this.percents;
		String ciphertext = ciphertextraw.toLowerCase();
		int closestindexcipher=0, closestindexplain=0;
		double smallestdifference, currdifference;
		for (int l=0; l<letterFrequencies.length; l++)
		{
			smallestdifference=100.0;
			// Find the closest
			for (int x=0; x<letterFrequencies.length; x++)
			{
				for (int y=0; y<letterFrequencies.length; y++)
				{
					currdifference = Math.abs(percents[x]-cipherPercents[y]);
					if (currdifference < smallestdifference)
					{
						closestindexcipher = y;
						closestindexplain = x;
						smallestdifference = currdifference;
					}
				}
			}
			// Replace each character with upper case plaintext equivalent
			ciphertext = ciphertext.replace((char)(closestindexcipher+'a'), (char)(closestindexplain+'A'));
			// Make sure the letters are not selected again
			percents[closestindexplain] = -1000*closestindexplain-1000;
			cipherPercents[closestindexcipher] = 1000*closestindexplain+1000;
		}
		return ciphertext;
	}
}
