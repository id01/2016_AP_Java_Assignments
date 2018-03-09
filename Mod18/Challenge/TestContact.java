// Gavin Lo
// 05-18-2017
// This program tests the Contact class.

public class TestContact
{
	// Function to print contacts
	public static void printContacts(Contact [] myContacts) {
		for (Contact c : myContacts) {
			System.out.println(c);
		}
	}

	// Functions to print results
	public static void printResult(Contact contact) {
		if (contact == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found:\n" + contact);
		}
	}
	public static void printResults(Contact [] contact) {
		if (contact == null || contact.length == 0 || contact[0] == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found:");
			for (Contact c : contact) {
				if (c != null) {
					System.out.println(c);
				}
			}
		}
	}

	// This function does a selection sort on myContacts
	public static Contact[] selectionSortName(Contact[] myContacts) {
		int afterIndex; String afterValue;
		Contact swapper;
		for (int lengthLeft = myContacts.length; lengthLeft > 1; lengthLeft--) {
			afterIndex = 0; afterValue = "";
			for (int i=0; i<lengthLeft; i++) {
				if (myContacts[i].getName().compareTo(afterValue) > 0) {
					afterIndex = i;
					afterValue = myContacts[i].getName();
				}
			}
			swapper = myContacts[afterIndex];
			myContacts[afterIndex] = myContacts[lengthLeft-1];
			myContacts[lengthLeft-1] = swapper;
		}
		return myContacts;
	}

	// This function does a binary search on myContacts for the name
	public static Contact findByName(Contact[] myContacts, String name) {
		// Look through the array for a specified name
		int pos = myContacts.length/2;
		int increment = pos/2+pos%2;
		while (pos < myContacts.length && pos >= 0) {
			if (myContacts[pos].getName().compareTo(name) < 0) {
				pos += increment;
			} else if (myContacts[pos].getName().compareTo(name) > 0) {
				pos -= increment;
			} else {
				increment = -1;
				break; // We found it!
			}
			if (increment == 1) {
				// It has already incremented. Is this it? If yes, we found it. Else, fail
				if (myContacts[pos].getName().compareTo(name) == 0) {
					increment = -1;
				}
				break;
			}
			increment = increment/2+increment%2;
		}
		if (increment == -1) {
			return myContacts[pos]; // Return result
		} else {
			return null; // No results
		}
	}

	// This function does a selection sort on myContacts
	public static Contact[] selectionSortEmail(Contact[] myContacts) {
		int afterIndex; String afterValue;
		Contact swapper;
		for (int lengthLeft = myContacts.length; lengthLeft > 1; lengthLeft--) {
			afterIndex = 0; afterValue = "";
			for (int i=0; i<lengthLeft; i++) {
				if (myContacts[i].getEmail().compareTo(afterValue) > 0) {
					afterIndex = i;
					afterValue = myContacts[i].getEmail();
				}
			}
			swapper = myContacts[afterIndex];
			myContacts[afterIndex] = myContacts[lengthLeft-1];
			myContacts[lengthLeft-1] = swapper;
		}
		return myContacts;
	}

	// This function does a sequential search on myContacts for relation
	public static Contact[] findByRelation(Contact[] myContacts, String relation) {
		Contact [] results = new Contact[myContacts.length];
		int pos=0;
		for (Contact contact : myContacts) {
			if (contact.getRelation().equals(relation)) {
				results[pos] = contact;
				pos++;
			}
		}
		Contact [] toReturn = new Contact[pos];
		for (int i=0; i<toReturn.length; i++) {
			toReturn[i] = results[i];
		}
		return toReturn;
	}

	// This function does a sequential search for all the birthdays of a month
	public static Contact[] findByBMonth(Contact[] myContacts, String bmonth) {
		Contact [] results = new Contact[myContacts.length];
		int pos=0;
		for (Contact contact : myContacts) {
			if (contact.getBDay().substring(0, contact.getBDay().indexOf(' ')).equals(bmonth)) {
				results[pos] = contact;
				pos++;
			}
		}
		Contact [] toReturn = new Contact[pos];
		for (int i=0; i<toReturn.length; i++) {
			toReturn[i] = results[i];
		}
		return toReturn;
	}

	// This function does a sequential search for all the contacts with a phone number
	public static Contact[] findByPhone(Contact[] myContacts, String phone) {
		Contact [] results = new Contact[myContacts.length];
		int pos=0;
		for (Contact contact : myContacts) {
			if (contact.getPhone().equals(phone)) {
				results[pos] = contact;
				pos++;
			}
		}
		Contact [] toReturn = new Contact[pos];
		for (int i=0; i<toReturn.length; i++) {
			toReturn[i] = results[i];
		}
		return toReturn;
	}

	// This function does a binary search on myContacts for the email
	public static Contact findByEmail(Contact[] myContacts, String email) {
		// Look through the array for a specified email
		int pos = myContacts.length/2;
		int increment = pos/2+pos%2;
		while (pos < myContacts.length && pos >= 0) {
			if (myContacts[pos].getEmail().compareTo(email) < 0) {
				pos += increment;
			} else if (myContacts[pos].getEmail().compareTo(email) > 0) {
				pos -= increment;
			} else {
				increment = -1;
				break; // We found it!
			}
			if (increment == 1) {
				// It has already incremented. Is this it? If yes, we found it. Else, fail
				if (myContacts[pos].getEmail().compareTo(email) == 0) {
					increment = -1;
				}
				break;
			}
			increment = increment/2+increment%2;
		}
		if (increment == -1) {
			return myContacts[pos]; // Return result
		} else {
			return null; // No results
		}
	}

	public static void main(String [] args) {
		// Construct contact array
		Contact[] myContacts = new Contact[]{
			new Contact("John Carter", "brother", "Mar 3", "(342) 555-7069", "jcarter@carter.com"),
			new Contact("Elise Carter", "mom", "Apr 19", "(342) 555-7011", "carterMom@carter.com"),
			new Contact("Ellie Carter", "me", "Jun 10", "(342) 555-8102", "ecarter@carter.com"),
			new Contact("Sue Ellen", "friend", "Mar 9", "(341) 555-9182", "susieE@hotmail.com"),
			new Contact("Frank Carter", "dad", "Dec 1", "(342) 555-7011", "carterDad@carter.com"),
			new Contact("Johnnie", "friend", "Jan 21", "(341) 555-7789", "jDawg5555@yahoo.com")
		};

		printContacts(myContacts);

		// Test name binary search
		System.out.println();
		myContacts = selectionSortName(myContacts);
		System.out.println("Searching for name 'Johnnie':");
		printResult(findByName(myContacts, "Johnnie"));
		System.out.println("Searching for name 'Sam Parker':");
		printResult(findByName(myContacts, "Same Parker"));

		// Test relation sequential search
		System.out.println();
		System.out.println("Searching for relation 'friend':");
		printResults(findByRelation(myContacts, "friend"));
		System.out.println("Searching for relation 'Aunt':");
		printResults(findByRelation(myContacts, "Aunt"));

		// Test birth month sequential search
		System.out.println();
		System.out.println("Searching for birth month 'May':");
		printResults(findByBMonth(myContacts, "May"));
		System.out.println("Searching for birth month 'Mar':");
		printResults(findByBMonth(myContacts, "Mar"));

		// Test phone number sequential search
		System.out.println();
		System.out.println("Searching for phone number (342) 555-7011:");
		printResults(findByPhone(myContacts, "(342) 555-7011"));
		System.out.println("Searching for phone number (333) 555-8989:");
		printResults(findByPhone(myContacts, "(333) 555-8989"));

		// Test email binary search
		System.out.println();
		myContacts = selectionSortEmail(myContacts);
		System.out.println("Searching for email 'rgoodman@hotmail.com':");
		printResult(findByEmail(myContacts, "rgoodman@hotmail.com"));
		System.out.println("Searching for email 'susieE@hotmail.com':");
		printResult(findByEmail(myContacts, "susieE@hotmail.com"));
	}
}
