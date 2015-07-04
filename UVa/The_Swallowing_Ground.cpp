#include <stdio.h>

int main() {

	int N, n, a, b, difference;
	bool yes;

	scanf("%i", &N);

	while(N--) {
		yes = true;
		scanf("%i", &n);
		scanf("%i %i", &a, &b);
		--n;
		difference = a-b;
		while(n--) {
			scanf("%i %i", &a, &b);
			if( (b+difference) != a)
				yes = false;
		}
		if(yes) 
			printf("yes\n");
		else 
			printf("no\n");
		if(N > 0)
			printf("\n");
	}

	return 0;
}