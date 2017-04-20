import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class PathNode implements Comparable<PathNode>{
  int id;
  long value;
  PathNode (int id, long value) {
    this.id = id;
    this.value = value;
  }
  public int compareTo( PathNode n ) {
    return this.value > n.value ? 1 : -1;
  }
}

public class Main {

  public static void main (String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] line;
    int t, n, k, x, m, s, a, b, c;
    Map<Integer, Long> cities;
    t = Integer.parseInt(in.readLine());
    Map<Integer,Map<Integer,Integer>> graph;
    Queue<PathNode> vertexs;
    while ( t-- > 0 ) {
      line = in.readLine().split(" ");
      n = Integer.parseInt(line[0]);
      k = Integer.parseInt(line[1]);
      x = Integer.parseInt(line[2]);
      m = Integer.parseInt(line[3]);
      s = Integer.parseInt(line[4]);
      s--;
      cities = new HashMap<Integer, Long>();
      vertexs = new PriorityQueue<PathNode>();
      graph = new HashMap<Integer, Map<Integer, Integer>>();
      for (int i = 0; i < n; i++ ) {
        Map<Integer,Integer> paths = new HashMap<Integer,Integer>();
        for (int j = 0; i < k && j < k ; j++ ) {
          if ( i == j) continue;
          paths.put(j, x);
        }
        graph.put(i,paths);
      }
      while ( m-- > 0 ) {
        line = in.readLine().split(" ");
        a = Integer.parseInt(line[0]);
        b = Integer.parseInt(line[1]);
        c = Integer.parseInt(line[2]);
        a--;
        b--;
        graph.get(a).put(b, c);
        graph.get(b).put(a, c);
      }
      vertexs.add( new PathNode(s,0) );
      while ( ! vertexs.isEmpty() ) {
        PathNode closest = vertexs.poll();
        if (cities.containsKey(closest.id)) continue;
        cities.put(closest.id, closest.value);
        if (cities.size() == n) break;
        for (int key : graph.get(closest.id).keySet() ) {
          if (cities.containsKey(key)) continue;
          vertexs.add( new PathNode(key, closest.value + graph.get(closest.id).get(key)) );
        }
      }
      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", cities.get(i));
      }
      System.out.println("");
    }
    in.close();
  }
}
