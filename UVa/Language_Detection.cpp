#include <stdio.h>
#include <string.h>
#include <string>

int main() {
	
	int n = 1;
	char str[16];

	while(true) {
		scanf("%s", &str);	
		if(strcmp(str, "#") == 0)
			return 0;
		if(strcmp(str, "HELLO") == 0)
			printf("Case %i: ENGLISH\n", n++);
		else if(strcmp(str, "HOLA") == 0)
			printf("Case %i: SPANISH\n", n++);
		else if(strcmp(str, "HALLO") == 0)
			printf("Case %i: GERMAN\n", n++);
		else if(strcmp(str, "BONJOUR") == 0)
			printf("Case %i: FRENCH\n", n++);
		else if(strcmp(str, "CIAO") == 0)
			printf("Case %i: ITALIAN\n", n++);
		else if(strcmp(str, "ZDRAVSTVUJTE") == 0)
			printf("Case %i: RUSSIAN\n", n++);
		else 
			printf("Case %i: UNKNOWN\n", n++);
	}
}