import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int a, b, temp, max = 0;
    Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
    int cliqueMin = 0, cliqueMax = 0, i, val;
    while ( m-- > 0 ) {
      a = in.nextInt();
      b = in.nextInt();
      if (a > b) {
        temp = a;
        a = b;
        b = temp;
      }
      if ( !graph.containsKey(a) ) graph.put(a, new HashSet<Integer>());
      graph.get(a).add(b);
    }
    for (i = n-1; i >= 0; i-- ) {
      if ( i == 0 ) {
        max = Math.max(max, cliqueMax - cliqueMin + 1);
        break;
      }
      if (graph.containsKey(i-1) && graph.get(i-1).contains(i) ) {
        for (val = cliqueMin; val <= cliqueMax; val++) {
          if ( !graph.get(i-1).contains(val) )  {
            max = Math.max(max, cliqueMax - cliqueMin + 1);
            cliqueMax = val;
            break;
          }
        }
        if (cliqueMax == 0) {
          cliqueMax = i;
        }
        cliqueMin = i-1;
      } else {
        max = Math.max(max, cliqueMax - cliqueMin + 1);
        cliqueMax = 0;
        cliqueMin = 0;
      }
      graph.remove(i);
    }
    System.out.println(max);
    in.close();
  }

}
