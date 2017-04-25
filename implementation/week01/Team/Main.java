import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int result = 0;
    while ( n-- > 0) {
      result += (in.nextInt() + in.nextInt() + in.nextInt() > 1 ) ? 1 : 0;
    }
    System.out.println(result);
    in.close();
  }
}
