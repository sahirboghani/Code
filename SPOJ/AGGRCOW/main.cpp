// AGGRCOW

#include <iostream>
#include <algorithm>

bool process(int, int, int, int*);
int binCowSearch(int, int, int*);
int main() {

	// process input
	int numCase;
	std::cin >> numCase;

	for(int i = 0; i < numCase; i++) {
		int numCow, numStall;
		std::cin >> numStall >> numCow;
		int *stalls = new int[numStall];
		for(int j = 0; j < numStall; j++) {
			std::cin >> stalls[j];
		}
		std::sort(stalls, stalls+numStall);
		std::cout << binCowSearch(numCow, numStall, stalls) << std::endl;
		delete []stalls;
	}
	return 0;
}

bool process(int distance, int numCow, int numStall, int* stalls) {
	int temp = numCow-1;
	int counter = 0;
	for(int i = 1; i < numStall; i++) {
		if(stalls[i] - stalls[counter] >= distance) {
			temp--;
			counter = i;
		}
	}
	return temp <= 0;
}

int binCowSearch(int numCow, int numStall, int* stalls) {
	int min = 1, max = stalls[numStall-1]-stalls[0];
	int mid = (min+max)/2;
	while(min < max) {
		mid = (min+max)/2;
		if(process(mid, numCow, numStall, stalls)) {
			min = mid;
		}
		else {
			max = mid;
		}
		if(mid+1 == max)
			return process(max, numCow, numStall, stalls) ? max : min;
	}
	return min;
}
