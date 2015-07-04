#include <iostream>
#include <cstdlib>

int main() {
	
	int a = 1, b = 1, c = 1, d = 1, degrees = 1;

	while(a || b || c || d) {
			scanf("%i %i %i %i", &a, &b, &c, &d);
			if((a || b || c || d)) {
				degrees = 1080;
				degrees += a > b ? ((float)(a - b)/40*360) : ((float)(40 - b + a)/40*360);
				degrees += c > b ? ((float)(c - b)/40*360) : ((float)(40 - b + c)/40*360);
				degrees += c > d ? ((float)(c - d)/40*360) : ((float)(40 - d + c)/40*360);
				printf("%i\n", degrees); 
			}
	}
	return 0;
}