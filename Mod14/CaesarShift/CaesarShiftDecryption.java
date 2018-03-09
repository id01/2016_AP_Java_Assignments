// Gavin Lo
// April 01, 2017
// This program contains the encryption methods for a simple caesar shift.

public class CaesarShiftDecryption
{
	final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

	public static String decryptString(String toDecrypt, String shiftAlphabet)
	{
		String decrypted = "";
		for (int i=0; i<toDecrypt.length(); i++)
		{
			decrypted += alphabet.charAt( shiftAlphabet.indexOf(toDecrypt.substring(i, i+1)) );
		}
		return decrypted;
	}
}