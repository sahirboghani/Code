#include <iostream>
#include <string>
#include <sstream>

using namespace std;

void solve(char[], string, int, int);

int main() {
	
	string s;
	char input[100];
	int limit, underscoreCount, previousUnderscore;
	bool capitalLetter;

	while(cin >> s) {
		limit = s.size();
		underscoreCount = 0;
		capitalLetter = false;
		previousUnderscore = false;

		for(int i=0; i != limit; ++i) {
			if(s[i] == '_') {
				if(previousUnderscore) {		// consecutive underscores == error
					break;
				}
				input[i] = 'u';				// underscore
				++underscoreCount;
				previousUnderscore = true;
			}
			else if(s[i] > 96) {
				input[i] = 'l';				// lowercase letter
				previousUnderscore = false;
			}
			else {
				input[i] = 'c';				// capital letter 
				capitalLetter = true;
				previousUnderscore = false;
			}
		}
		// first is underscore OR last is underscore OR consecutive underscore OR first letter capital OR has capital letter(s) and underscore(s) == Error!
		if(previousUnderscore || input[0] == 'u' || input[0] == 'c' || (capitalLetter && underscoreCount))		
			cout << "Error!" << endl;
		else
			solve(input, s, limit, underscoreCount);
	}

	return 0;
}

void solve(char *input, string s, int limit, int underscoreCount) {
	stringstream ss;
	ss.put(s[0]);
		
	if(underscoreCount) {	// c++ to java
		for(int i=1; i!= limit; ++i) {
			if(input[i] == 'u') {
				ss.put(s[++i]-32); // make it capital
			}
			else 
				ss.put(s[i]);
		}
	}
	else {					// java to c++ OR same (i.e. 'name')
		for(int i = 1; i != limit; ++i) {
			if(input[i] == 'c') {
				ss.put('_').put(s[i]+32);
			}
			else 
				ss.put(s[i]);
		}
	}

	cout << ss.str() << endl;
}

/*

restrictions: all char's are either a letter or underscore

invalid c++: 
	-first/last char is underscore
	-any capital letter
	-consecutive underscore

invalid java:
	-any underscores
	-first letter capital
*/