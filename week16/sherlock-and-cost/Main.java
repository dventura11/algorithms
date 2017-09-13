import java.util.Scanner;

public class Main {
  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int i, size;
    long sum;
    int[] data;
    int[][] dp;
    while ( n-- > 0 ) {
      size = in.nextInt();
      data = new int[size];
      dp = new int[size][2];
      for ( i = 0; i < size; i++ ) {
        data[i] = in.nextInt();
      }
      String s1 = "0";
      String s2 = "0";
      String s3 = String.valueOf(data[0]);
      for ( i = 1; i < size; i++ ) {
        dp[i][0] = dp[i-1][1];
        dp[i][1] = dp[i-1][0];
        if ( data[i-1] - 1 < data[i] - data[i-1]) {
          dp[i][0] += Math.max(data[i] - 1, data[i-1] - data[i]);
          dp[i][1] += Math.max(data[i] - 1, data[i-1] - data[i]);
        } else {
          dp[i][0] += data[i] - 1;
          dp[i][1] += data[i-1] - 1;
        }
        s1 += "\t" + dp[i][0];
        s2 += "\t" + dp[i][1];
        s3 += "\t" + data[i];
      }
      System.out.println( "============================");
      System.out.println(s3);
      System.out.println(s1);
      System.out.println(s2);
      System.out.println( Math.max(dp[size-1][0], dp[size-1][1]) );
    }
    in.close();
  }
}
