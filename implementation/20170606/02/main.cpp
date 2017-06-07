#include<iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  long long x, y, l, r, count, max = 0;
  cin >> x >> y >> l >> r;
  bool unlucky[r+2];
  unlucky[r+1] = true;
  for (long long current = 1; current < r; current *= x) {
    if (current < l-1) continue;
    for (long long second = 1; (current + second) <= r; second *= y) {
      unlucky[current + second] = true;
    }
  }
  for (long long current = 1; current < r; current *= y) {
    if (current < l-1) continue;
    for (long long second = 1; (current + second) <= r; second *= x) {
      unlucky[current + second] = true;
    }
  }
  count = 0;
  for(long long i = l; i <= r+1; i++) {
    if (unlucky[i]) {
      max = max > count ? max : count;
      count = -1;
    }
    count++;
  }
  cout << max << endl;
  return 0;
}
