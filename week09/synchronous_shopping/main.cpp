#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
#include <memory.h>
#include <stdio.h>

using namespace std;

typedef pair<int,int> ii;
typedef pair<ii, int> node;

const int MAX_FISH_TYPES = 1003;
const int KInf  = 2e9;

int mask[MAX_FISH_TYPES];
int dis[MAX_FISH_TYPES << 1][MAX_FISH_TYPES];
deque <ii> graph[MAX_FISH_TYPES];

int main() {
  ios::sync_with_stdio(false);
  int n, m, k;

  //Read centers, roads and fishes
  cin >> n >> m >> k;

  //Read fishes in each store
  for(int i=0; i<n; ++i) {
    int types, fish;
    cin >> types;
    while(types--) {
      cin >> fish;
      --fish;
      mask[i] |= ( 1<<fish );
    }
  }

  //Read roads and weights
  while ( m-- ) {
    int u, v, w;
    cin >> u >> v >> w;
    --u; --v;
    graph[u].push_back( make_pair(v, w) );
    graph[v].push_back( make_pair(u, w) );
  }

  // Calculate Dijkstra with different mask;
  memset(dis, -1, sizeof dis);
  priority_queue <node, deque<node>, greater<node> > heap;
  heap.push(make_pair(make_pair(0,mask[0]),0));
  dis[mask[0]][0] = 0;

  while( ! heap.empty() ) {
    int oldMask = heap.top().first.second;
    cout << "maks: " << oldMask << endl;
    int u = heap.top().second;
    heap.pop();
    for(int i=0; i < graph[u].size(); ++i) {
      int v = graph[u][i].first;
      int w = graph[u][i].second;
      int newMaks = oldMask | mask[v];
      if(  (dis[newMaks][v] == -1) ||
          ((dis[oldMask][u]+w) < dis[newMaks][v])
        ) {
        dis[newMaks][v] = dis[oldMask][u] + w;
        heap.push( make_pair( make_pair(dis[newMaks][v], newMaks), v) );
      }
    }
  }

  int answer = KInf;
  // Make all possible combinations and take the best
  for(int i = 0; i < (1 << k); ++i ) {
    for(int j = 0; j < (1 << k); ++j ) {
      // Valid when all bits are covered
      if( (i | j ) != ((1 << k) - 1)) continue;
      if(dis[i][n-1] == -1) dis[i ][n-1] = KInf;
      if(dis[j][n-1] == -1) dis[j ][n-1] = KInf;
      int time = max(dis[i ][n-1], dis[j ][n-1]);
      if(time < answer) {
        answer = time;
      }
    }
  }

  // Print result
  cout << answer << endl;
  return EXIT_SUCCESS;
}
