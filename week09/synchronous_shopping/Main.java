import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class ShopVertex {
  int mask, cost;
  Map<Integer, Integer> paths;
  ShopVertex(int mask) {
    this(mask, 0);
  }
  ShopVertex(int mask, int cost) {
    this(mask, cost, new HashMap<Integer, Integer>());
  }
  ShopVertex(int mask, int cost, Map<Integer, Integer> paths) {
    this.mask = mask;
    this.cost = cost;
    this.paths = paths;
  }
}
public class Main {
  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    //number of shops
    int n = in.nextInt();
    Map<Integer, ShopVertex> graph = new HashMap<Integer, ShopVertex>();
    Queue<ShopVertex> queue = new LinkedList<ShopVertex>();
    Map<Integer, Integer> distance = new HashMap<Integer, Integer>();
    Map<Integer, Integer> result = new HashMap<Integer, Integer>();
    //nmber of roads
    int m = in.nextInt();
    //number of types of fishes
    int k = in.nextInt();
    //read fishes that sale each shop
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ShopVertex(0));
      for (int t = in.nextInt(); t > 0; t--) {
        graph.get(i).mask |=  1 << (in.nextInt() - 1 );
      }
    }
    //read the paths
    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      int z = in.nextInt();
      graph.get(x).paths.put(y, z);
      graph.get(y).paths.put(x, z);
    }
    //generate bits mask
    queue.add(graph.get(1));
    distance.put(graph.get(1).mask, graph.get(1).cost);
    while ( !queue.isEmpty() ) {
      ShopVertex current = queue.poll();
      Integer cmask = new Integer(current.mask);
      //System.out.println("current: " +  cmask);
      for ( int to : current.paths.keySet() ) {
        int nmask = current.mask | graph.get(to).mask;
        int ndistance = current.cost + current.paths.get(to);
        if ( to == n && ( !result.containsKey(nmask) || ndistance < result.get(nmask) ) )  {
          result.put(nmask, ndistance);
        } else if ( !distance.containsKey(nmask) || distance.get(nmask) > ndistance) {
          distance.put(nmask, ndistance);
          queue.add(new ShopVertex(nmask, ndistance, graph.get(to).paths ));
        }
      }
    }
    int expected = 1 << n;
    expected--;
    int min = Integer.MAX_VALUE;
    for ( int mask1 : result.keySet() ) {
      for ( int mask2 : result.keySet() ) {
        int rmask = mask1 | mask2;
        int cost = Math.max(result.get(mask1), result.get(mask2));
        if ( rmask == expected && cost < min) {
          //System.out.println("Ganadora: " +  mask1 + ", " + mask2);
          //System.out.println("costo: " +  result.get(mask1) + ", " + result.get(mask2));
          min = cost;
        }
      }
    }
    System.out.println(min);
    in.close();
  }
}
