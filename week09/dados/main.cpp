#include<iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  int sides[n];
  for (int i = 0; i < n; i++ ) cin >> sides[i];
  int rlength = sides[n-1] + 1;
  long result[rlength];
  for (int i = 0; i < rlength; i++) result[i] = 1;
  result[rlength-1] = 0;
  for (int i = n - 1 ; i >= 0; i--) {
    for (int j = sides[i] - 2; j >= 0 ; j--) {
      result[j] += result[j+1];
    }
  }

  cout << result[0] << endl;
  return EXIT_SUCCESS;
}
