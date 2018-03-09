#include <stdio.h>

int main()
{
	printf("Convert (0) ASCII to Text or (1) Text to ASCII? ");
	int choice;
	scanf("%d", &choice);
	if (choice == 0)
	{
		printf("Please input string of numbers, NULL terminator to end: ");
		int asciivalue = 1;
		while (asciivalue > 0)
		{
			scanf("%d", &asciivalue);
			if (asciivalue < 0 || asciivalue > 254)
			{
				printf("\nInvalid ascii value. Exitting...\n");
				break;
			}
			printf("%c", (char)asciivalue);
		}
		printf("\n");
	}
	else
	{
		printf("Please input string, enter to end: ");
		int asciivalue = 1;
		scanf("%c", &asciivalue);
		asciivalue = 1;
		while (asciivalue != 0x0A)
		{
			scanf("%c", &asciivalue);
			printf("%d ", asciivalue);
		}
		printf("\n");
	}
}
