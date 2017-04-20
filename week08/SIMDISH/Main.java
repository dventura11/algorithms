import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int sum, i, t = in.nextInt();
    Set<String> set = new HashSet<String>();
    while ( t-- > 0 ) {
      for ( i = 0; i < 4; i++) {
        set.add(in.next());
      }
      sum = 0;
      for ( i = 0; i < 4; i++) {
        if (set.contains(in.next())) {
          sum++;
        }
      }
      System.out.println( sum > 1 ? "similar" : "dissimilar" );
    }
    in.close();
  }
}
