import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  private static Set<Character> vowels;
  static {
    vowels = new HashSet<Character>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    vowels.add('y');
  }
  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    s = s.toLowerCase();
    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray() ) {
      if ( vowels.contains(c)) continue;
      result.append(".");
      result.append(c);
    }
    System.out.println(result);
    in.close();
  }
}
