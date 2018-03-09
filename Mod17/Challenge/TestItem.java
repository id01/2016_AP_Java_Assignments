// Gavin Lo
// 05-11-2017
// This program tests the item class using a sorting algorithm

public class TestItem
{
	// This method prints the inventory stored in the array hardware.
	public static void printInventory(Item [] hardware) {
		for ( Item item : hardware ) {
			System.out.println(item);
		}
	}

	// This method sorts the array using itemID. Uses Selection sort
	public static Item[] sortID(Item [] hardware) {
		int afterIndex, afterValue;
		Item temp;
		for (int ll=hardware.length; ll>2; ll--) {
			afterIndex = 0; afterValue = 0;
			for (int i=0; i<ll; i++) {
				if (Integer.parseInt(hardware[i].getID()) > afterValue) {
					afterIndex = i;
					afterValue = Integer.parseInt(hardware[i].getID());
				}
			}
			temp = hardware[afterIndex];
			hardware[afterIndex] = hardware[ll-1];
			hardware[ll-1] = temp;
		}
		return hardware;
	}

	// These methods sort the array using itemName. Uses Insertion sort
	public static Item[] moveUp(Item [] toMove, int fromIndex) {
		Item[] moved = new Item[toMove.length];
		int increment = 0;
		for (int i=0; i<toMove.length; i++) {
			if (i == fromIndex)
				increment = 1;
			if (toMove[i] == null)
				break;
			moved[i+increment] = toMove[i];
		}
		return moved;
	}
	public static Item[] sortName(Item [] hardware) {
		Item[] newHardware = new Item[hardware.length];
		for (Item item : hardware) {
			for (int i=0; i<newHardware.length; i++) {
				if (newHardware[i] == null || hardware[i].getName().compareTo(item.getName()) > 0) {
					newHardware = moveUp(newHardware, i);
					newHardware[i] = item;
					i = newHardware.length+1;
				}
			}
		}
		return newHardware;
	}

	// This method sorts the array using inStore. Uses Selection sort
	public static Item[] sortQuantity(Item [] hardware) {
		int afterIndex, afterValue;
		Item temp;
		for (int ll=hardware.length; ll>2; ll--) {
			afterIndex = 0; afterValue = 0;
			for (int i=0; i<ll; i++) {
				if (hardware[i].getQuantity() > afterValue) {
					afterIndex = i;
					afterValue = hardware[i].getQuantity();
				}
			}
			temp = hardware[afterIndex];
			hardware[afterIndex] = hardware[ll-1];
			hardware[ll-1] = temp;
		}
		return hardware;
	}

	// These methods sort the array using price. They use merge sort.
	public static Item[] mergeItems(Item[] array1, Item[] array2) {
		Item[] newInventory = new Item[array1.length + array2.length];
		int i1=0, i2=0;
		while (i1 <= array1.length && i2 <= array2.length) {
			if (i1 >= array1.length) {
				for (i2=i2; i2<array2.length; i2++) {
					newInventory[i1+i2] = array2[i2];
				} break;
			} else if (i2 >= array2.length) {
				for (i1=i1; i1<array1.length; i1++) {
					newInventory[i1+i2] = array1[i1];
				} break;
			} else {
				if (array1[i1].getPrice() < array2[i2].getPrice()) {
					newInventory[i1+i2] = array1[i1]; i1++;
				} else {
					newInventory[i1+i2] = array2[i2]; i2++;
				}
			}
		}
		return newInventory;
	}
	public static Item[][] splitItems(Item[] toSplit) {
		Item[][] splitArray = new Item[2][];
		Item[] splitArray1 = new Item[toSplit.length/2];
		Item[] splitArray2 = new Item[toSplit.length/2+toSplit.length%2];
		for (int i=0; i<splitArray1.length; i++) {
			splitArray1[i] = toSplit[i];
		}
		for (int i=splitArray1.length; i<toSplit.length; i++) {
			splitArray2[i-splitArray1.length] = toSplit[i];
		}
		splitArray[0] = splitArray1;
		splitArray[1] = splitArray2;
		return splitArray;
	}
	public static Item[] recurseItems(Item[] hardware) {
		Item[][] splitArray = splitItems(hardware);
		Item[] returnValue;
		boolean end0 = (splitArray[0].length <= 1);
		boolean end1 = (splitArray[1].length <= 1);
		if (end0 == true && end1 == false) {
			splitArray[1] = recurseItems(splitArray[1]);
		} else if (end1 == true && end0 == false) {
			splitArray[0] = recurseItems(splitArray[0]);
		} else if (end1 == false && end0 == false) {
			splitArray[0] = recurseItems(splitArray[0]);
			splitArray[1] = recurseItems(splitArray[1]);
		}
		returnValue = mergeItems(splitArray[0], splitArray[1]);
		return returnValue;
	}
	public static Item[] sortPrice(Item[] hardware) {
		return recurseItems(hardware);
	}

	public static void main(String [] args) {
		// Construct array
		Item[] hardware = new Item[] {
			new Item("1011", "Air Filters", 200, 10.5),
			new Item("1034", "Door Knobs", 60, 21.5),
			new Item("1101", "Hammers", 90, 9.99),
			new Item("1600", "Levels", 80, 19.99),
			new Item("1500", "Ceiling Fans", 100, 59.0),
			new Item("1201", "Wrench Sets", 55, 80.0)
		};
		
		// Print array
		printInventory(hardware);

		// Sort by ID (Selection)
		System.out.println("\nSorted By ID:");
		hardware = sortID(hardware);
		printInventory(hardware);

		// Sort by Name (Insertion)
		System.out.println("\nSorted By Name:");
		hardware = sortName(hardware);
		printInventory(hardware);

		// Sort by Quantity (Selection)
		System.out.println("\nSorted By Quantity:");
		hardware = sortQuantity(hardware);
		printInventory(hardware);

		// Sort by Cost (Merge)
		System.out.println("\nSorted By Price:");
		hardware = sortPrice(hardware);
		printInventory(hardware);
	}
}
