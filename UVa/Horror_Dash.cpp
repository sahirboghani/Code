#include <stdio.h>

int main() {

	int T, N, n = 1, i, max;

	scanf("%i", &T);
	while(T--) {
		max = 0;
		scanf("%i", &N);
		while(N--) {
			scanf("%i", &i);
			max = i > max ? i : max;
		}
		printf("Case %i: %i\n", n++, max);
	}

	return 0;
}