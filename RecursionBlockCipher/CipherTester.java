// Gavin Lo
// 04-24-2017
// This program tests the RecursionCipher class.

public class CipherTester
{
	public static void main(String [] args) {
		RecursionCipher myCipher = new RecursionCipher();
		char [] key = new char[] { 'p', 'A', 'S', 's', 'W', 'o', 'R', 'd' }; // 8 characters array
		char [] iv = new char[] { 'I', 'n', 'V', 'e', 'C', 't', 'o', 'R' }; // 8 characters array
		String toEncrypt = "This is the plaintext to encrypt"; // Multiple of 8
		// Add contents to cipher
		myCipher.addContents(toEncrypt);
		// Demonstrate cipher
		System.out.println("Plaintext: " + myCipher.getStringContents());
		myCipher.encrypt(key,iv);
		System.out.println("Ciphertext: " + myCipher.getStringContents());
		myCipher.decrypt(key,iv);
		System.out.println("Plaintext2: " + myCipher.getStringContents());
	}
}
