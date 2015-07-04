#include <stdio.h>

int main() {
	
	int L;
	int y, z;
	char primary, sign, ch;

	while(true) {
		scanf("%i", &L);
		getchar();
		if(L == 0)
			return 0;
		y = z = 0;
		primary = 'a';
		for(int i = 1; i < L; ++i) {
			scanf("%c%c", &sign, &ch);
			getchar();
			if(sign != 'N') {
				if(primary == 'a')
					primary = ch;
				if(ch == 'y') {
					if(sign == '+')
						++y;
					else 	
						--y;
				}
				else {
					if(sign == '+')
						++z;
					else 
						--z;
				}
			}
			//printf("\nPrimary %c\nz %i \ny %i\n", primary, z, y);000
		}
		// printf("\nPrimary %c\nz %i \ny %i\n", primary, z, y);
		if(primary == 'a')
			printf("+x\n");
		else {
			bool neg;
			if(primary == 'y') {
				neg = y < 0;
				if(neg)
					y *= -1;
				y %= 4;
				if(y == 2)
					printf("-x\n");
				else if(y == 1) {
					if(neg)
						printf("-y\n");
					else
						printf("+y\n");
				}
				else if(y == 3) {
					if(neg)
						printf("+y\n");
					else
						printf("-y\n");
				}
				else 
					printf("+x\n");
			}
			else {
				neg = z < 0;
				if(neg)
					z *= -1;
				z %= 4;
				if(z == 2)
					printf("-x\n");
				else if(z == 1) {
					if(neg)
						printf("-z\n");
					else
						printf("+z\n");
				}
				else if(z == 3) {
					if(neg)
						printf("+z\n");
					else
						printf("-z\n");
				}
				else 
					printf("+x\n");
			}
		}
	}
}