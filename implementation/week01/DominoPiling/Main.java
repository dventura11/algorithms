import java.util.Scanner;

public class Main {

  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    if ( n > m) {
      int temp = m;
      m = n;
      n = temp;
    }
    int r = m * (n/2);
    r += n%2 == 0 ? 0 : m/2;
    System.out.println(r);
    in.close();
  }
}
