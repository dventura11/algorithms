import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long last, max = 0;
    long x = in.nextLong();
    long y = in.nextLong();
    long l = in.nextLong();
    long r = in.nextLong();
    Set<Long> unlucky = new TreeSet<Long>();
    unlucky.add(r+1);
    for (long current = 1; current > 0 && current < r; current *= x) {
      if ( current != 1 && current%x != 0) break;
      for (long second = 1; second > 0 && (current + second) <= r; second *= y) {
        if ( second != 1 && second%y != 0) break;
        if ( (current + second) < l) continue;
        unlucky.add(current+second);
      }
    }
    last = l-1;
    for (long current : unlucky) {
      if ( last + 1 != current) {
        max = Math.max(max, current -1 - last);
      }
      last = current;
    }
    System.out.println(max);
    in.close();
  }
}
