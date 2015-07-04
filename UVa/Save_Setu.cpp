#include <stdio.h>

int main() {
	
	int N, temp, total = 0;
	char in[6];

	scanf("%i", &N);
	while(N--) {
		scanf("%s", in);

		switch(in[0]) {
			case 'r':
				printf("%i\n", total);
				break;
			case 'd':
				scanf("%i", &temp);
				total += temp;
		}
	}

	return 0;
}