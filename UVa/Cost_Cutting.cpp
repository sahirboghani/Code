#include <stdio.h>

int main() {
	int N, n=1, a, b, c;

	scanf("%i", &N);

	while(N--) {
		scanf("%i %i %i", &a, &b, &c);
		if(a > b && a > c) {
			if(b > c)
				printf("Case %i: %i\n", n++, b);
			else 
				printf("Case %i: %i\n", n++, c);
		}
		else if(b > a && b > c) {
			if(a > c)
				printf("Case %i: %i\n", n++, a);
			else 
				printf("Case %i: %i\n", n++, c);
		}
		else { 	// if(c > a && c > b) 
			if(a > b)
				printf("Case %i: %i\n", n++, a);
			else 
				printf("Case %i: %i\n", n++, b);
		}
	}
	return 0;
}