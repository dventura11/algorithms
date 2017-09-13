import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    StringBuilder r = new StringBuilder();
    int n = in.nextInt();
    int k = in.nextInt();
    int g = in.nextInt();
    int b = in.nextInt();
    char gc = 'G';
    char bc = 'B';
    if ( b > g ) {
      gc = 'B';
      bc = 'G';
      int temp = g;
      g = b;
      b = temp;
    }
    int div = g%k == 0 ? g/k : g/k+1;
    int bt = div > 2 ? b/(div-1) : b/div;
    //System.out.println(div + " - " + bt);
    if ( bt == 0 && !( n == k && n == g ) ) {
      System.out.println("NO");
      in.close();
      return;
    }
    while ( g > 0 || b > 0 ) {
      if ( g > 0 ) {
        for ( int i = 0; i < k && g > 0; i++ ) {
          r.append(gc);
          g--;
        }
      }
      if ( b <= 0 ) {
        continue;
      }
      for ( int i = 0; i < bt && b > 0; i++ ) {
        r.append(bc);
        b--;
      }
    }
    System.out.println(r);
    in.close();
  }
}
