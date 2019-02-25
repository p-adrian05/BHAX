#include <stdio.h>

int main()
{
	int word = 1;
	int length = 0;
	
	while(word <<= 1)
	{
		length++;
	}
	
	printf("A szó %d bites\n", length);
    
    return 0;
}
