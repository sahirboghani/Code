//Problem        : Twin Primes
//Language       : C++
//Compiled Using : g++
//Version        : GCC 4.8.2
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

#include <iostream>
#include <string>
#include <algorithm>
#include <climits> 

using namespace std;

bool isPrime(int);

int main() {

    int k = 0;
    
    cin >> k;
    
    int f = 0, l = 0;

    
    for(int i = k; i >= 0; i--) {
    	if(isPrime(i) && isPrime(i-2)) {
            cout << i-2 << "," << i;
            break;
        }
    }
    
    return 0;
}

bool isPrime(int num) {
	
	for (int i=2; i<num; i++)
	{
		if (num % i == 0)
		{
			return false;
		}
	}
	
	return true;	
}