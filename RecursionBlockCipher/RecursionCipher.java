// Gavin Lo
// 04-21-2017
// This program is a simple CBC block cipher that uses recursion. This is the backend class.
// It stores all the blocks in an ArrayList.

import java.util.ArrayList;

public class RecursionCipher
{
	// Contents
	private ArrayList<RecursionBlock> content;

	// Constructor
	public RecursionCipher() {
		content = new ArrayList<RecursionBlock>();
	}

	// Functon adds contents to the content
	public void addContents(String newContent) {
		if (newContent.length()%8 != 0) {
			throw new RuntimeException("Plaintext length must be a multiple of 8!");
		}
		char [] toAdd;
		for (int i=0; i<newContent.length()-7; i+=8) {
			toAdd = new char[8];
			for (int x=i; x<i+8; x++) {
				toAdd[x%8] = newContent.charAt(x);
			}
			content.add(new RecursionBlock(toAdd));
		}
	}

	// Demonstration of recursion using CBC-mode encryption
	// Wrappers
	public void encrypt(char [] key, char [] iv) {
		content = encryptBlock(key, iv, content.size()-1); // Encrypt with the last block
	}

	public void decrypt(char [] key, char [] iv) {
		content = decryptBlock(key, iv, content.size()-1);
	}

	// Recursive function
	public ArrayList<RecursionBlock> encryptBlock(char [] key, char [] iv, int blockNumber) {
		ArrayList<RecursionBlock> blocks; // Create arrayList of blocks to return
		RecursionBlock myBlock = content.get(blockNumber); // Get the current block
		myBlock.xorData(key); // Encrypt block with key
		if (blockNumber > 0)
		{
			// If the block is not the first block, encrypt block with previous block
			blocks = encryptBlock(key, iv, blockNumber-1);
			myBlock.xorData(blocks.get(blocks.size()-1).getData());
		}
		else // Base case
		{
			blocks = new ArrayList<RecursionBlock>();
			myBlock.xorData(iv); // If the block is the first block, encrypt block with iv
		}
		blocks.add(myBlock);
		return blocks; // Return encrypted block
	}

	// Recursive function
	public ArrayList<RecursionBlock> decryptBlock(char [] key, char [] iv, int blockNumber) {
		ArrayList<RecursionBlock> blocks; // Create arrayList of blocks to return
		RecursionBlock myBlock = content.get(blockNumber); // Get the current block
		myBlock.xorData(key); // Decrypt block with key
		if (blockNumber > 0)
		{
			// If the block is not the first block, encrypt block with encrypted previous block
			myBlock.xorData(content.get(blockNumber-1).getData()); // Decrypt with the encrypted previous block
			blocks = decryptBlock(key, iv, blockNumber-1); // Decrypt the previous blocks
		}
		else // Base case
		{
			blocks = new ArrayList<RecursionBlock>();
			myBlock.xorData(iv); // If the block is the first block, encrypt block with iv
		}
		blocks.add(myBlock);
		return blocks; // Return encrypted block
	}

	// Getter function for contents
	public ArrayList<RecursionBlock> getContents() {
		return content;
	}

	// Get contents as String
	public String getStringContents() {
		String contentString = "";
		char [] myBlockData;
		for ( RecursionBlock myBlock : content )
		{
			myBlockData = myBlock.getData();
			for ( char character : myBlockData )
				contentString += character;
		}
		return contentString;
	}
}
