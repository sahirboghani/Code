#include <stdio.h>
#include <string.h>

int main() {
	
	int N, l;
	char in[200];

	scanf("%i", &N);

	while(N--) {
		scanf("%s", in);
		l = strlen(in);

		if(in[l-2] == '3' && in[l-1] == '5')
			printf("-\n");
		else if(in[0] == '9' && in[l-1] == '4')
			printf("*\n");
		else if(in[0] == '1' && in[1] == '9' && in[2] == '0')
			printf("?\n");
		else
			printf("+\n");
	}

	return 0;
}