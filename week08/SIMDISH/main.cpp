#include <iostream>
#include <string>
#include <set>

using namespace std;

int main () {
  ios_base::sync_with_stdio(false);
  int i, sum, t;
  string ingredient;
  cin >> t;
  set<string> dish;
  while ( t-- > 0) {
    sum = 0;
    dish.clear();
    for ( i = 0; i < 4; i++ ) {
      cin >> ingredient;
      dish.insert(ingredient);
    }
    for ( i = 0; i < 4; i++ ) {
      cin >> ingredient;
      if ( dish.count(ingredient) ) {
        sum++;
      }
    }
    cout << ( sum > 1 ? "similar" : "dissimilar" ) << endl;
  }
  return 0;
}
