#include <stdio.h>

int g(long int);

int main() {
	long n;
	while(true) {
		scanf("%ld", &n);
		if(n == 0)
			return 0;
		printf("%i\n", g(n));
	}
}

int g(long int n) {
	if(n < 10)
		return n;
	int temp = 0;
	while(n > 0) {
		temp += n%10;
		n /= 10;
	}
	return g(temp);
}