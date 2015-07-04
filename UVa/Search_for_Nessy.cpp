#include <stdio.h>
#include <math.h>

int main() {
	
	int N, r, c;
	scanf("%i", &N);

	while(N--) {
		scanf("%i %i", &r, &c);
		r-=2; // since borders don't matter
		c-=2; // since borders don't matter and the first 3 rows are accounted for
		printf("%i\n", (int)ceil(r/3.0) * (int)ceil(c/3.0));
	}

	return 0;
}

/*
int main() {
	
	int N, r, c;
	scanf("%i", &N);

	std::stringstream ss;

	while(N--) {
		scanf("%i %i", &r, &c);
		r-=2; // since borders don't matter
		c-=2; // since borders don't matter and the first 3 rows are accounted for
		ss << (int)ceil(r/3.0) * (int)ceil(c/3.0) << '\n';
	}

	printf(ss.str().c_str());
	return 0;
}*/