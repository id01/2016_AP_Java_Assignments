// Gavin Lo
// March 24, 2017
// This program has the capability to convert morse code into text

import java.util.ArrayList;

public class MorseCode
{
	// This function converts a letter of morse code
	public static char convertMorseLetter(String morse)
	{
		String [] possibleLetters = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
			"..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
			"..-", "...-", ".--", "-..-", "-.--", "--.." }; // All the letters in alphabetical order
		for (int i=0; i<possibleLetters.length; i++)
			if (possibleLetters[i].equals(morse))
				return (char)(i + 'A'); // Check if this is a letter
		String [] possibleNumbers = new String[] { "-----", ".----", "..---", "...--", "....-", ".....",
			"-....", "--...", "---..", "----." }; // All the digits in numberical order
		for (int i=0; i<possibleNumbers.length; i++)
			if (possibleNumbers[i].equals(morse))
				return (char)(i + '0'); // Check if this is a number
		return '?'; // Unknown char
	}

	// This function converts a number of morse code
	public static String convertToMorseLetter(char letter)
	{
		String [] possibleLetters = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
			"..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
			"..-", "...-", ".--", "-..-", "-.--", "--.." }; // All the letters in alphabetical order
		if (letter >= 'a' && letter <= 'z')
			letter += 'A'-'a'; // Change letter to upper case
		if (letter >= 'A' && letter <= 'Z')
			return possibleLetters[letter-'A']; // Return the index equal to the character's position relative to A
		String [] possibleNumbers = new String[] { "-----", ".----", "..---", "...--", "....-", ".....",
			"-....", "--...", "---..", "----." }; // All the digits in numberical order
		if (letter >= '0' && letter <= '9')
			return possibleNumbers[letter-'0']; // Return the index equal to the character's position relative to 0
		return "?"; // Unknown char
	}

	// This program converts an entire arrayList of morse letters into a string
	public static String convertMorseString(ArrayList<String> morseLetters)
	{
		String decodedLetters = "";
		for (String morseLetter : morseLetters)
			decodedLetters += convertMorseLetter(morseLetter);
		return decodedLetters;
	}


	// This program converts a string into an arrayList of morse letters
	public static ArrayList<String> convertToMorseString(String myString)
	{
		ArrayList<String> morseLetters = new ArrayList<String>();
		for (int i=0; i<myString.length(); i++)
			morseLetters.add(convertToMorseLetter(myString.charAt(i))); // Convert each character into a morse letter
		return morseLetters;
	}
}
