import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n, m, ti, tf, time = 0, r = -1;
    n = in.nextInt();
    while ( n-- > 0 ) time += in.nextInt();
    m = in.nextInt();
    while ( m-- > 0 ) {
      ti = in.nextInt();
      tf = in.nextInt();
      if (ti <= time && time <= tf) {
        r = time;
        break;
      }
      if (ti >= time ) {
        r = r == -1 ? ti : ti < r ? ti : r;
      }
    }
    System.out.println(r);
    in.close();
  }
}
