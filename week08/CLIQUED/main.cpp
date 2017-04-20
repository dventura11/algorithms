#include<iostream>
#include<vector>
#include<queue>
#include<map>

using namespace std;

struct node {
  int id;
  long long value;
  node (int i, long v) {
    id = i;
    value = v;
  }
};

bool operator<(const node& a, const node& b) {
  return a.value > b.value;
}

int main () {
  ios::sync_with_stdio(false);
  int t, n, k, x, m, s, a, b, c, sum;
  cin >> t;
  while ( t-- > 0 ) {
    cin >> n >> k >> x >> m >> s;
    s--;
    sum = 0;
    map<int,map<int,int>> graph;
    priority_queue<node> vertexs;
    long long distance[n];
    for (int i = 0; i < n; i++ ) {
      distance[i] = -1;
      for (int j = 0; i < k && j < k ; j++ ) {
        if ( i == j) continue;
        graph[i][j] = x;
      }
    }
    while ( m-- > 0 ) {
      cin >> a >> b >> c;
      a--;
      b--;
      graph[a][b] = c;
      graph[b][a] = c;
    }
    vertexs.push(node(s,0));
    while ( ! vertexs.empty() ) {
      node closest = vertexs.top();
      vertexs.pop();
      if ( distance[closest.id] >= 0 ) continue;
      distance[closest.id] = closest.value;
      sum++;
      if ( sum == n ) break;
      for (const auto& entry : graph[closest.id] ) {
        if ( distance[entry.first] >= 0 ) continue;
        vertexs.push( node(entry.first, closest.value + entry.second) );
      }
    }
    for (int i = 0; i < n; i++ ) cout << distance[i] << " ";
    cout << endl;
  }
  return EXIT_SUCCESS;
}
