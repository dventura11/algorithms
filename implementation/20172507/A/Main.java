import java.util.Scanner;
import java.util.TreeSet;

public class Main {
  private static long MOD_VAL = 1000000007;
  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long sum = 0, combinations, diff;
    TreeSet<Long> hacked = new TreeSet<Long>();
    while ( n-- > 0 ) hacked.add(in.nextLong());
    Long[] data = hacked.toArray(new Long[hacked.size()]);
    for (int i = data.length - 1; i > 0; i--) {
      combinations = 1;
      for (int j = i - 1; j >= 0; j-- ) {
        diff = data[i] - data[j];
        //System.out.println(max + " - " + min + " = " + diff);
        //System.out.println(diff + " * " + combinations);
        //System.out.println(diff*combinations);
        sum += diff * combinations;
        combinations <<= 1;

        combinations %= MOD_VAL;
        sum %= MOD_VAL;
      }
    }
    System.out.println(sum);
    in.close();
  }
}
