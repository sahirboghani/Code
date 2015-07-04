#include <stdio.h>
#include <utility>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	
	int N, a, b, i = 0;
	int times[10001] = {0};

	vector<pair<int, int> > v;

	scanf("%i", &N);

	while(N--) {
		scanf("%i %i", &a, &b);
		v.push_back(make_pair(a, b));
	}

	sort(v.begin(), v.end());

	long long answer = 0;

	for(i = v.size()-1; i >= 0; --i) {
		b = v[i].second;
		while(b) {
			if(!times[b]) {
				++times[b];
				answer += v[i].first;
				break;
			}
			--b;
		}
	}

	printf("%lld", answer);
	return 0;
}