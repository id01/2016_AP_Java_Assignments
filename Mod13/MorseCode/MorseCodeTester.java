// Gavin Lo
// March 24, 2017
// This program tests MorseCode with a file. It prompts the user for the input file
// then opens it, reads it, and decodes it.

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class MorseCodeTester
{
	public static void decodeTest()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What file should I decode? "); // Prompt for file to decode
		Scanner fileScanner = null; // This will be initialized in the try-catch
		try {
			fileScanner = new Scanner(new File(keyboard.next()));
		} catch (IOException e) {
			System.out.println(e);
			return; // Something bad happened. Exit
		}
		ArrayList<String> myMorse = new ArrayList<String>(); // Add stuff to ArrayList
		while (fileScanner.hasNext())
		{
			myMorse.add(fileScanner.next());
		}
		System.out.println(MorseCode.convertMorseString(myMorse)); // Print final string
	}

	public static void encodeTest()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What string should I encode? ");
		String toEncode = keyboard.next();
		System.out.println("Encoded string shown below: ");
		ArrayList<String> encoded = MorseCode.convertToMorseString(toEncode);
		for (String morseLetter : encoded)
			System.out.print(morseLetter + " ");
		System.out.println();
	}

	public static void main(String [] args)
	{
		decodeTest();
		encodeTest();
	}
}
