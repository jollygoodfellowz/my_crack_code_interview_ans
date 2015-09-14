#include <stdio.h>
#include <stdlib.h>

char* reverse(char* str);
char* rec_reverse(char* str, int i, int j);
char* swap (char* str, int i, int j);

void main(int argc, char** args)
{
	args++;
	printf("input %s\n", *args);
	printf("input reversed %s\n", reverse(*args));
}


char* reverse(char* str)
{
	int j;
	for(j = 0; str[j] != '\0'; j++){}

	return rec_reverse(str,0,j-1);
}

char* rec_reverse(char* str, int i, int j)
{
	if(i == j || i > j)
		return str;

	swap(str,i,j);
	return rec_reverse(str,i+1,j-1);
}

char* swap (char* str, int i, int j)
{
	char temp = str[i];
	str[i] = str[j];
	str[j] = temp;
	return str;
}
