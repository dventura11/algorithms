#include <iostream>
#include <string>
#include <sstream>
#include <set>
#include <vector>

using namespace std;

int main() {
  ios_base::sync_with_stdio(false);
  string line;
  stringstream ss;
  int  t, n, k, ingredient;
  set<int> ingredients;
  cin >> t;
  while ( t-- > 0 ) {
    cin >> n >> k;
    getline(cin, line);
    while ( n-- > 0 ) {
      getline(cin, line);
      ss.clear();
      ss << line;
      while ( ss >> ingredient ) {
        ingredients.insert(ingredient);
      }
      if ( ingredients.size() == k) {
        break;
      }
    }
    cout << (ingredients.size() == k ? n == 0 ? "all" : "some" : "sad" ) << endl;
    while ( n-- > 0 ) {
      getline(cin, line);
    }
    ingredients.clear();
  }
  return 0;
}
