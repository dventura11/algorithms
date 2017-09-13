import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (char c : s.toCharArray() ) {
      if ( !map.containsKey(c) ) {
        map.put(c, 0);
      }
      map.put(c, map.get(c) + 1);
    }
    long sum = 0;
    for ( Integer v : map.values() ) {
      sum += 1l * v * v;
    }
    System.out.println(sum);
    in.close();
  }
}
