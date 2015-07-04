#include <stdio.h>

int main() {
	
	int N, l, w, h, n = 0;
	scanf("%i", &N);

	while(N--) {
		scanf("%i %i %i", &l, &w, &h);
		if(l > 20 || w > 20 || h > 20)
			printf("Case %i: bad\n", ++n);
		else 
			printf("Case %i: good\n", ++n);
	}

	return 0;
}