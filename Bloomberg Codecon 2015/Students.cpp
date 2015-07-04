//Problem        : SI Exam Room
//Language       : C++
//Compiled Using : g++
//Version        : GCC 4.8.2
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

#include <iostream>
#include <algorithm>

using namespace std;

bool isPrime(int);

bool works(int numDesks, int numStudents, int* desks, int distance ) {
    int a = numStudents;

    a--;

    int j = 0;
    
    for(int i = 1; i<numDesks; i++) {
        if(desks[i] - desks[j] >= distance) {
        	a--;
            j = i;
    	}
    }
    return a <= 0;
}

int main() {

    int numDesks = 0;
    int numStudents = 0;
    cin >> numDesks;
    cin >> numStudents;
    
    int desks[numDesks];
    
    for(int i = 0; i < numDesks; i++) {
        cin >> desks[i];
    }
    
    sort(desks, desks+numDesks);
    
    
    for(int i = desks[numDesks-1]-1; i >= 0; i--) {
    	if(works(numDesks, numStudents, desks, i)) {
    		cout << i;
    		break; 
		}
    }
    
    return 0;
}

