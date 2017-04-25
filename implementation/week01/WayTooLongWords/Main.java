import java.util.Scanner;

public class Main {

  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    int n = in .nextInt();
    String s;
    while ( n-- > 0) {
      s = in.next();
      if ( s.length() > 10 ) {
        s = s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt( s.length() - 1 );
      }
      System.out.println(s);
    }
    in.close();
  }

}
