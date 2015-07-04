#include <stdio.h>

int main() {
	
	int N, H, W, p, a;
	long int B, min_cost;
	bool works;

	while(scanf("%i %li %i %i", &N, &B, &H, &W) != EOF) {
		min_cost = -1;
		for(int i = 0; i < H; ++i) {
			works = false;
			scanf("%i", &p);
			for(int j = 0; j < W; ++j) {
				scanf("%i", &a);
				if(a >= N)
					works = true;
			}
			if(works) {
				if((N*p < B) && (min_cost == -1 || min_cost > N*p))
					min_cost = N*p;
			}
		}
		if(min_cost == -1)
			printf("stay home\n");
		else 
			printf("%li\n", min_cost); 
	}	
	return 0;
}