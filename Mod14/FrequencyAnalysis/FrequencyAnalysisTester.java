// Gavin Lo
// This program takes in a file of plaintext and a file of ciphertext.
// It outputs the frequency analysis for both, and then tries to crack the ciphertext.

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class FrequencyAnalysisTester
{
	public static void main(String [] args)
	{
		// Initialize variables
		final String plaintextFileName = "plaintext";
		final String ciphertextFileName = "secretmessage";
		FrequencyAnalysis plaintextfreq = new FrequencyAnalysis();
		FrequencyAnalysis ciphertextfreq = new FrequencyAnalysis();
		// Calculate frequencies of files
		try {
			// Analyze all the frequencies
			Scanner plaintextReader = new Scanner(new File(plaintextFileName + ".txt"));
			Scanner ciphertextReader = new Scanner(new File(ciphertextFileName + ".txt"));
			while (plaintextReader.hasNext())
				plaintextfreq.addWord(plaintextReader.next());
			while (ciphertextReader.hasNext())
				ciphertextfreq.addWord(ciphertextReader.next());
			plaintextfreq.calcPercentFrequencies();
			ciphertextfreq.calcPercentFrequencies();
			ciphertextReader.close();
			plaintextReader.close();
		} catch (IOException e) {
			System.out.println("Something went wrong... Are you sure the files exist?");
			System.exit(1);
		}
		// Print output
		System.out.println("Letter frequencies for plaintext: ");
		System.out.println("Letter: Total|Percent");
		for (int i=0; i<plaintextfreq.getLetterFrequencies().length; i++)
			System.out.printf("%-6c: %5d|%5.2f\n", (char)(i+'A'), plaintextfreq.getLetterFrequencies()[i], plaintextfreq.getPercents()[i]);
		System.out.println("\n");
		System.out.println("Letter frequencies of ciphertext: ");
		System.out.println("Letter: Total|Percent");
		for (int i=0; i<ciphertextfreq.getLetterFrequencies().length; i++)
			System.out.printf("%-6c: %5d|%5.2f\n", (char)(i+'A'), ciphertextfreq.getLetterFrequencies()[i], ciphertextfreq.getPercents()[i]);
		// Write output to file
		try {
			PrintWriter plaintextWriter = new PrintWriter(new File(plaintextFileName + "freq.txt"));
			PrintWriter ciphertextWriter = new PrintWriter(new File(ciphertextFileName + "freq.txt"));
			for (int i=0; i<plaintextfreq.getLetterFrequencies().length; i++)
				plaintextWriter.printf("%-6c %5d %5.2f\n", (char)(i+'A'), plaintextfreq.getLetterFrequencies()[i], plaintextfreq.getPercents()[i]);
			for (int i=0; i<ciphertextfreq.getLetterFrequencies().length; i++)
				ciphertextWriter.printf("%-6c %5d %5.2f\n", (char)(i+'A'), ciphertextfreq.getLetterFrequencies()[i], ciphertextfreq.getPercents()[i]);
			plaintextWriter.close();
			ciphertextWriter.close();
		} catch (IOException e) {
			System.out.println("Couldn't open output file\n");
			System.exit(2);
		}
		// Crack ciphertext
		String ciphertext = "";
		try {
			Scanner ciphertextReader = new Scanner(new File(ciphertextFileName + ".txt"));
			while (ciphertextReader.hasNext())
				ciphertext += ciphertextReader.next() + " ";
			ciphertextReader.close();
		} catch (IOException e) {
			System.out.println("Something very very wrong happened.\n");
			System.exit(3);
		}
		System.out.println("Decoded ciphertext:");
		String crackedCiphertext = plaintextfreq.crackCiphertext(ciphertextfreq.getPercents(), ciphertext);
		// Prompt user to replace characters
		System.out.println(crackedCiphertext);
		String userInput = " ", userInput2;
		Scanner keyboard = new Scanner(System.in);
		while (!userInput.equals(""))
		{
			System.out.println("Not right? Type a letter and what to replace it with, or enter to exit.");
			userInput = keyboard.next();
			if (!userInput.equals(" "))
			{
				userInput2 = keyboard.next();
				// Swap the 2 letters around
				crackedCiphertext = crackedCiphertext.replace(userInput.toUpperCase(), userInput2.toLowerCase());
				crackedCiphertext = crackedCiphertext.replace(userInput2.toUpperCase(), userInput.toUpperCase());
				crackedCiphertext = crackedCiphertext.toUpperCase();
				System.out.println("New cracked ciphertext: ");
				System.out.println(crackedCiphertext);
			}
		}
	}
}
