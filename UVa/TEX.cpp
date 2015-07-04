#include <iostream>
#include <cstdlib>

int main() {

	char ch;
	bool first = true;
	while(scanf("%c", &ch) != EOF) {
		if(ch=='"') {
			if(first) 
				printf("%c%c", '`','`');
			else 
				printf("%c%c", '\'','\'');
			first = !first;
		}
		else 
			printf("%c", ch);
	} 
	return 0;	
}