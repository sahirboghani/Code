#include <stdio.h>

int main() {

	int N, a, b;
	scanf("%i", &N);

	while(N--) {
		scanf("%i %i", &a, &b);
		if(a<b)
			printf("<\n");
		else if(a>b)
			printf(">\n");
		else 
			printf("=\n");
	}

	return 0;
}