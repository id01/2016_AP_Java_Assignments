#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char * argv[])
{
	if (argc == 1) { puts("Usage: ./shiftcrack [message]"); return 254; }
	char * possibility = malloc(strlen(argv[1]) + 1);
	char * userinput = malloc(16);
	strcpy(possibility, argv[1]);
	for (int attempt=1; attempt<27; attempt++)
	{
		for (int i=0; possibility[i]; i++)
		{
			possibility[i]++;
			if (possibility[i] > 'Z')
			{
				possibility[i] = 'A';
			}
		}
		printf("Attempt %d: %s\n", attempt, possibility);
		printf("Press enter to continue, CTRL+C to quit.");
		fgets(userinput, 4, stdin);
	}
}
