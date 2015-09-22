#include <stdio.h>
#include <iostream>
#include <sstream>
#include <cmath>

using namespace std;

int main() {
	
	int budget, party_size, i, j;
	int party_cost[100], party_fun[100];
	int answer_array[501];
	stringstream ss;

	answer_array[0] = 0;

	while(true) {
		scanf("%i %i", &budget, &party_size);

		if(!budget && !party_size)
			break;

		// input
		for(i = 0; i != party_size; ++i) {
			cin >> party_cost[i] >> party_fun[i];
			answer_array[i+1] = 0;
		}

		// for each budget
		for(i = 1; i != budget+1; ++i) {
			
			// initially you have the same fun at this budget as you do in the previous budget
			answer_array[i] = answer_array[i-1];

			// for each party
			for(j = 0; j != party_size; ++j) {
				// if it costs less than the budget && it adds more fun, attend
				if(party_cost[j] < i && answer_array[i] < (answer_array[i-party_cost[j]] + party_fun[j]))
					answer_array[i] = answer_array[i-party_cost[j]] + party_fun[j];
			}
		}
	}
	return 0;
}