#include <iostream>
#include <string>
#include <map>
#include <set>
#include <climits>
#include <algorithm>

using namespace std;

int minChunks(string s, int k, char last, map<string,int> &cache) {
  if ( s.length() == 0) {
    return 0;
  }
  string cacheKey = last+s;
  if (cache[cacheKey]) {
    return cache[cacheKey];
  }
  int result = INT_MAX;
  string next = s.substr(k);
  s = s.substr(0, k);
  set<char> chars;
  for (char c : s) {
    if ( c == last ) continue;
    chars.insert(c);
  }
  for (char c : chars) {
    result = min(result, minChunks(next, k, c, cache));
  }
  if (chars.size() == 0) {
    result = minChunks(next, k, last, cache);
  }
  cache[cacheKey] = chars.size() + result;
  return cache[cacheKey];
}

int main () {
  ios_base::sync_with_stdio (false);
  string s;
  int k, cases;
  cin >> cases;
  while ( cases-- > 0 ) {
    cin >> k;
    cin >> s;
    map<string, int> cache;
    cout << minChunks(s, k, ' ', cache) << "\n";
  }
  return 0;
}
