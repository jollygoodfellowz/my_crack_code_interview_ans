#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 10

struct list 
{
	struct list* next;
	struct list* prev;
	int data;
};

typedef struct list node;

node* delete_node(node* ptr, int data);
void print_list(node* ptr);
node* init();
node* create_node(int data);

void main (int argc, char** args)
{
	args++;
	int data = 0;
	data = atoi(*args);
	node* ptr;
	ptr = init();

	print_list(ptr);
	ptr = delete_node(ptr, data);
	print_list(ptr);

}

node* delete_node(node* ptr, int data)
{
	node* curr = NULL;
	curr = ptr;

	while(curr != NULL && curr->data != data)
		curr = curr->next;

	if(curr != NULL)
	{
		// The node is at the end of the list
		if(curr->next == NULL)
		{
			curr->prev->next = NULL;
		}
		//The node is at the front of the list
		else if(curr->prev == NULL)
		{
			ptr = curr->next;
			curr->next = NULL;
		}	
		// The normal case
		else
		{
			curr->prev->next = curr->next;
			curr->next->prev = curr->prev;
		}
	}
	free(curr);	
	return ptr;
}

void print_list(node* ptr)
{
	while(ptr != NULL)
	{
		printf("%d, ", ptr->data);
		ptr = ptr->next;
	}

	printf("\n");
}

node* init()
{
	node* curr = NULL;
	node* ptr  = NULL;

	ptr = create_node(0);
	curr = ptr;

	int i;
	for(i = 1; i < MAX; i++)
	{
		curr->next = create_node(i);
		curr->next->prev = curr;
		curr = curr->next;
	}
	return ptr;
}

node* create_node(int data)
{
	node* ptr = NULL;
	ptr = (node*)(malloc(sizeof(node)));
	ptr->next = NULL;
	ptr->prev = NULL;
	ptr->data = data;
	return ptr;
}