import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int temp, max, min, n, result, t = in.nextInt();
    Set<Integer> v;
    while ( t-- > 0 ) {
      v = new HashSet<>();
      result = 0;
      min = Integer.MAX_VALUE;
      max = Integer.MIN_VALUE;
      n = in.nextInt();
      while ( n-- > 0 ) {
        temp = in.nextInt();
        min = Math.min(min, temp);
        max = Math.max(max, temp);
        if (result == 0 && v.contains(temp)) {
          result = temp;
        }
        v.add(temp);
      }
      result = ( result == 0 ) ? (v.contains(min+1)) ? max : min : result;
      System.out.println(result);
    }
    in.close();
  }
}
