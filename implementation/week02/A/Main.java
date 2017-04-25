import java.util.Scanner;
import java.util.TreeMap;

public class Main {

  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long temp, k = in.nextLong();
    TreeMap<Long,Integer> prices = new TreeMap<Long, Integer>();
    while ( n-- > 0 ) {
      temp = in.nextLong();
      if ( ! prices.containsKey(temp) ) {
        prices.put(temp, 0);
      }
      prices.put(temp, prices.get(temp) + 1);
    }
    long min = prices.firstKey();
    long sum = 0;
    prices.remove(min);
    for (Long key : prices.keySet() ) {
      if ( (key - min) % k == 0) {
        sum += ( ( key - min ) / k ) * prices.get(key);
      } else {
        sum = -1;
        break;
      }
    }
    System.out.println(sum);
    in.close();
  }
}
