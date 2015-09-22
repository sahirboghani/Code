#include <stdio.h>
#include <cmath>
#include <string>
#include <iostream>
#include <sstream>

using namespace std;

int main() {
	
	int N;
	long int n, diagonal, terms, places;
	stringstream answer;

	scanf("%i", &N);

	while(N--) {
		scanf("%li", &n);

		answer.str(string());

		// on the nth diagonal
		diagonal = ceil( (ceil(sqrt(8*n)) - 1) / 2 );

		// # of terms prior to the nth diaognal  
		terms = (diagonal-1)*diagonal/2;

		// # of places up/down along the nth diagonal
		places = n - terms - 1;

		

		// if odd aka going up
		if(diagonal & 1)
			answer << "TERM " << n << " IS " << (diagonal-places) << "/" << (places+1) << "\n"; 
		else
			answer << "TERM " << n << " IS " << (places+1) << "/" << (diagonal-places) << "\n";

		cout << answer.str();
	}

	return 0;
}