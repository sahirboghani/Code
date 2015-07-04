#include <stdio.h>

int main() {

	int N, n, a, b, total;
	scanf("%i", &N);

	while(N--) {
		scanf("%i", &n);
		total = 0;
		while(n--) {
			scanf("%i %*i %i", &a, &b);
			total += a*b;
		}
		printf("%i\n", total);
	}

	return 0;
}