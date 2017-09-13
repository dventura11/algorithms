import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 3;
    int[] v = new int[3];
    for ( int i = 0; i < 3; i++) {
      String s = in.next();
      switch (s) {
        case "A>B":
        case "B<A":
          v[0]++;
          break;
        case "A>C":
        case "C<A":
          v[0]++;
          break;
        case "B>C":
        case "C<B":
          v[1]++;
          break;
        case "A<B":
        case "B>A":
          v[1]++;
          break;
        case "A<C":
        case "C>A":
          v[2]++;
          break;
        case "B<C":
        case "C>B":
          v[2]++;
          break;
      }
    }
    int a = v[0];
    int b = v[1];
    int c = v[2];
    if ( a == b || a == c || b == a) {
      System.out.println("Impossible");
    } else if ( a < b && a < c) {
      System.out.println( b < c ? "ABC" : "ACB");
    } else if ( b < a && b < c) {
      System.out.println( a < c ? "BAC" : "BCA");
    } else if ( c < a && c < b) {
      System.out.println( a < b ? "CAB" : "CBA");
    } else {
      System.out.println("Impossible");
    }
    in.close();
  }

}
