#include <stdio.h>

int main()
{
	int word = 1;
	int length = 0;
	
	do
	{
		length++;
	} 
	while (word<<=1);
	
	
	printf("A szó %d bites\n", length);
    
    return 0;
}
