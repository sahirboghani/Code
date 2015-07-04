#include <stdio.h>

int main() {
	
	int N = 1, n = 0, Emoogle = 0, temp;
	while(true) {
		scanf("%i", &N);
		if(N == 0)
			return 0;
		Emoogle = 0;
		while(N--) {
			scanf("%i", &temp);
			Emoogle = temp == 0 ? Emoogle-1 : Emoogle+1;
		}
		printf("Case %i: %i\n", ++n, Emoogle);
	}

	return 0;
}