// Gavin Lo
// April 01, 2017
// This program contains the encryption methods for a simple caesar shift.

public class CaesarShiftEncryption
{
	final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

	public static String encryptString(String toEncrypt, String shiftAlphabet)
	{
		String encrypted = "";
		for (int i=0; i<toEncrypt.length(); i++)
		{
			encrypted += shiftAlphabet.charAt( alphabet.indexOf(toEncrypt.substring(i, i+1)) );
		}
		return encrypted;
	}
}