#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  long long sum, ones, zeros;
  int t;
  cin >> t;
  while ( t-- ) {
    string s;
    cin >> s;
    sum = 0;
    ones = 0;
    zeros = 0;
    for (char c : s + "1") {
      if ( c == '1' ) {
        if ( zeros > 0 ) {
          sum += ones * (zeros + 1);
        }
        zeros = 0;
        ones++;
      } else {
        zeros++;
      }
    }
    cout << sum << endl;
  }
  return EXIT_SUCCESS;
}
