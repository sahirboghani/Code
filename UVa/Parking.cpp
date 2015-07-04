#include <stdio.h>

int main() {

	int N, n, l, r, temp;
	scanf("%i", &N);

	while(N--) {
		scanf("%i", &n);
	
		l = 99;
		r = 0;
		while(n--) {
			scanf("%i", &temp);
			if(temp < l)
				l = temp;
			if(temp > r)
				r = temp;
		}

		printf("%i\n", 2*(r-l));
	}

	return 0;
}