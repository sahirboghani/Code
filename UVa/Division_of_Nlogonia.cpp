#include <stdio.h>

int main() {
	
	int N = 1, X, Y, x, y;

	while(N) {
		scanf("%i", &N);
		if(N!=0) {
			scanf("%i %i", &X, &Y);

			while(N--) {
				scanf("%i %i", &x, &y);
				if(x==X || y==Y)
					printf("divisa\n");
				else if(x>X) {
					if(y>Y)
						printf("NE\n");
					else
						printf("SE\n");
				}
				else {
					if(y>Y)
						printf("NO\n");
					else 
						printf("SO\n");
				}
			}
		}
	}
}