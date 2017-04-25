import java.util.Scanner;

public class Main {
  public static void main(String ... a) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    in.close();
    int sum = 0;
    char last = s.charAt(0) == '1' ? '0' : '1';
    for ( char c : s.toCharArray() ) {
      if ( c == last) {
        sum++;
      } else {
        sum = 1;
        last = c;
      }
      if (sum == 7 ) {
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}
