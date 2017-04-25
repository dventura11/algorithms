import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in .nextLong();
    long m = in .nextLong();
    long a = in .nextLong();
    long r = n / a + ( n % a == 0 ? 0 : 1 );
    r *= m / a + ( m % a == 0 ? 0 : 1 );
    System.out.println(r);
    in.close();
  }
}
