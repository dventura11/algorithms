import java.util.Scanner;

public class Main {

  public static void main(String[] s) {
    Scanner in = new Scanner(System.in);
    long sum1 = 0, sum2 = 0;
    int n, i, j, temp, testCases = in.nextInt();
    while ( testCases-- > 0 ) {
      sum1 = 0;
      sum2 = 0;
      n = in.nextInt();
      for( i = 0; i < 2; i++) {
        for(j = 0; j < n; j++) {
          if ( (i+j)%2 == 0) {
            sum1 += in.nextInt();
          } else {
            sum2 += in.nextInt();
          }
        }
      }
      System.out.println(Math.min(sum1, sum2));
    }
    in.close();
  }
}
