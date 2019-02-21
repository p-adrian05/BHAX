#include<stdio.h>

int main()
{
		int a = 3;
		int b = 8;
		printf("a=%d b=%d\n",a,b);
		
		
		//segedvaltozo nelkül
		b = b-a;
		a = a+b;
		b = a-b;
		printf("a=%d b=%d\n",a,b);
		
		//exorra
		
		//a = 8-> 0001
		//b = 3-> 1100
		
		a = a^b; //1101
		b = a^b; //0001
		a = a^b; //1100
		
		printf("a=%d b=%d\n",a,b);
}
