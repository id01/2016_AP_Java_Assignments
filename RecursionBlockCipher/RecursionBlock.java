// Gavin Lo
// 04-21-2017
// This program represents a single block in the block cipher. It can do simple operations like get, set, and xor.

public class RecursionBlock
{
	// Char array of 8 characters representing content
	private char [] content;

	// Default constructor
	public RecursionBlock() {
		content = new char[8];
	}

	// Constructor that also sets data
	public RecursionBlock(char [] input) {
		if (input.length != 8)
			throw new RuntimeException("Wrong size block!");
		content = input;
	}

	// Sets the block data
	public void setData(char [] input) {
		if (input.length != 8)
			throw new RuntimeException("Wrong size block!");
		content = input;
	}

	// Xors the content with another block
	public void xorData(char [] input) {
		if (input.length != 8)
			throw new RuntimeException("Wrong size block!");
		for (int i=0; i<8; i++) {
			content[i] ^= input[i]; // Xor content with input
		}
	}

	// Returns the block data
	public char[] getData() {
		return content;
	}
}