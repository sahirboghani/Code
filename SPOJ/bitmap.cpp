#include <stdio.h>
#include <queue>
#include <utility>
#include <iostream>
#include <string.h>
#include <algorithm>

using namespace std;

string reader;
int N, r, c, i, j, x, y, m;

bool isValid(int a, int b) {
	if(a < 0 || a == r || b < 0 || b == c)
		return false;
	return true;
}

int main() {

	cin >> N;

	while(N--) {

		scanf("%i %i", &r, &c);

		char arr[r][c];
		int answer[r][c];
		bool visited [r][c];

		queue<pair<int, int> > q;

		for(i=0; i != r; ++i) {
			cin >> reader;
			for(j=0; j != c; ++j) {
				if(reader[j]=='1') {
					answer[i][j] = 0;
					visited[i][j] = true;
					q.push(make_pair(i, j));
				}
				else {
					visited[i][j] = false;
				}
			}
		}

		// BFS

		while(!q.empty()) {
			i = q.front().first;
			j = q.front().second;

			q.pop();

			visited[i][j] = true;

			for(x = -1; x != 2; ++x) {
				for(y = -1; y != 2; ++y) {
					if((!x && !y) || (x && y))
						continue;
					if(isValid(i+x, j+y) && !visited[i+x][j+y]) {
						answer[i+x][j+y] = answer[i][j]+1;
						visited[i+x][j+y] = true;
						q.push(make_pair(i+x, j+y));
					}
				}
			}
		}

		for(i=0; i!=r; ++i) {
			printf("%i", answer[i][0]);
			for(j=1; j!=c; ++j)
				printf(" %i", answer[i][j]);
			printf("\n");
		}
	}

	return 0;
}