#include <iostream>

int capacity = 1000;
bool primes[1000];

void sieve() {
	primes[1] = false;

	int limit = capacity;

	for(int i = 2; i < limit; ++i) {
		primes[i] = true;
	}

	for(int i = 2; i < limit; ++i) {
		if(primes[i]) {
			for(int j = 2; j*i < limit; ++j) {
				primes[i*j] = false;
			}
		}
	}
}

bool isPrime(int input) {
	return primes[input];
}

int main() {

	sieve();

	std::cout << isPrime(3) << std::endl;
	std::cout << isPrime(8) << std::endl;
	std::cout << isPrime(13) << std::endl;
	std::cout << isPrime(69) << std::endl;

	return 0;
}