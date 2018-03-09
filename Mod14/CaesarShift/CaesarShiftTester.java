// Gavin Lo
// April 01, 2017
// This program uses the caesar shift to encrypt data. It uses the CaesarShiftEncryption class.

import java.util.Scanner;

public class CaesarShiftTester
{
	final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("This program encrypts via caesar shift.");
		System.out.println("Would you want to:");
		System.out.println("[1] Encrypt");
		System.out.println("[2] Decrypt");
		String input = keyboard.next();
		final int option = Integer.parseInt(input);
		System.out.print("Type amount of shift here: ");
		input = keyboard.next();
		final int number = Integer.parseInt(input);
		final String shiftAlphabet = alphabet.substring(number) + alphabet.substring(0, number);
		System.out.println("Shift alphabet: " + shiftAlphabet);
		System.out.println("Type string to encrypt.\nExample input: MYMESSAGE");
		while (!input.equalsIgnoreCase("quit"))
		{
			System.out.print("Input here: ");
			input = keyboard.next().toLowerCase();
			if (!input.equalsIgnoreCase("quit"))
			{
				if (option == 1)
					System.out.println("Encrypted message: " + CaesarShiftEncryption.encryptString(input, shiftAlphabet));
				else
					System.out.println("Decrypted message: " + CaesarShiftDecryption.decryptString(input, shiftAlphabet));
			}
		}
	}
}