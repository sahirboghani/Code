#include <stdio.h>
#include <string.h>

int main() {
	
	int N;
	char letter[5];

	scanf("%i", &N);

	while(N--) {
		scanf("%s", letter);
		if(strlen(letter) == 5)
			printf("3\n");
		else {
			if(letter[0] == 'o')
				printf("1\n");
			else if(letter[0] == 't')
				printf("2\n");
			else if(letter[1] == 'n')
				printf("1\n");
			else
				printf("2\n");
		}
	}
	return 0;
}