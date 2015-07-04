#include <stdio.h>

int main() {
	
	char in[5];
	int n = 0;

	while(true) {
		scanf("%s", in);
		if(in[0] == '*')
			return 0;
		else if(in[0] == 'H')
			printf("Case %i: Hajj-e-Akbar\n", ++n);
		else 
			printf("Case %i: Hajj-e-Asghar\n", ++n);
	}
	return 0;
}