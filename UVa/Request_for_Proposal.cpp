#include <stdio.h>
#include <string>
#include <cstring>
#include <iostream>

int main() {

	int n, p, max_met, temp_met, N=1;
	float price, temp_price;
	std::string proposal, temp_name;
	std::string t;
	bool another_line = false;

	while(true) {
		scanf("%i %i", &n, &p);
		getchar();
		if(n==0 && p==0)
			return 0;
		else if(another_line)
			printf("\n");
		max_met = 0;
		for(int i = 0; i < n; ++i)
			getline(std::cin, t);
		for(int i = 0; i < p; ++i) {
			getline(std::cin, temp_name);
			scanf("%f %i", &temp_price, &temp_met);
			getchar();
			if(temp_met > max_met) {
				price = temp_price;
				proposal = temp_name;
				max_met = temp_met;
			}
			else if(temp_met == max_met && temp_price < price) {
				price = temp_price;
				proposal = temp_name;
			}
			for(int j = 0; j < temp_met; ++j)
				getline(std::cin, t);
		}
		printf("RFP #%i\n%s\n", N++, proposal.c_str());
		another_line = true;
	}
}