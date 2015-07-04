/*
ID: sboghani
PROG: milk2
LANG: C++   
*/
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

int main() {
    
    ofstream fout ("milk2.out");
    ifstream fin ("milk2.in");
    int N;
    unsigned long a, b;
    	
	// cin >> N;

    fin >> N;
    
    vector<pair<unsigned long, unsigned long> > v;

    while(N--) {
    //	cin >> a >> b;
        fin >> a >> b;
    	v.push_back(make_pair(a, b));
    }

    sort(v.begin(), v.end());
    // fout << a+b << endl;

//    for(a = 0; a != v.size(); ++a) 
//        cout << v[a].first << " " << v[a].second << endl;


    unsigned long start = v[0].first, end = v[0].second, continuous = end - start, noncontinuous = 0;

//    cout << start << " " << end << endl;

//    cout << v[1].first << " " << v[1].second << endl;

    for(a = 1; a != v.size(); ++a) {
        if(v[a].first <= end) {
            if(v[a].second > end)
                end = v[a].second;
           // cout << a << ": " << v[a].first << " " << v[a].second << " " << continuous;
        }
        else {
            continuous = continuous > end-start ? continuous : end-start;
            start = v[a].first;
            noncontinuous = noncontinuous > start-end ? noncontinuous : start-end;
            end = v[a].second;
        }
    }        

    continuous = continuous > end-start ? continuous : end-start;

    // cout << continuous << " " << noncontinuous;
    fout << continuous << " " << noncontinuous << endl;

    return 0;
}