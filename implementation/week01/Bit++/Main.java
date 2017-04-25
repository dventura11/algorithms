import java.util.Scanner;

public class Main {
  public static void main(String ... a) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int x = 0;
    while ( n-- > 0 ) {
      switch (in.next()) {
        case "++X":
        case "X++":
          x++;
          break;
        case "--X":
        case "X--":
          x--;
          break;
      }
    }
    System.out.println(x);
    in.close();
  }
}
