import java.util.Scanner;

public class Main {

  public static long MOD_VALUE = 1000000007;

  public static void main(String[] args) {
    //Creation of all posibles combinations for all posibles lenghts with PD
    long sum, permutations[], result[], combinations[] = new long[1001];
    combinations[0] = 1;
    for ( int i = 1; i < combinations.length; i++ ) {
      for ( int j = 1; j <= 4; j++ ) {
        if ( j > i ) continue;
        combinations[i] += combinations[ i - j ];
        combinations[i] %= MOD_VALUE;
      }
    }

    Scanner in = new Scanner( System.in );
    int n, m, t = in.nextInt();
    while ( t-- > 0) {
      n = in.nextInt();
      m = in.nextInt();
      //Calculate the number of permutations for each piece size until n
      permutations = new long[m + 1];
      result = new long[m + 1];
      for ( int i = 1; i <= m; i++ ) {
        //if I use math.pow to calculate the pow this will be grater than the max long value, then I will do it with a for cycle
        permutations[i] = 1;
        for ( int j = 1; j <= n; j++ ) {
          permutations[i] *= combinations[i];
          permutations[i] %= MOD_VALUE;
        }
      }
      //Calculate the number of permutations that allow how to break the wall
      //basically is the number of permutation and substract it the posible combinations of the lower blocks
      for ( int i = 1; i <= m; i++ ) {
        result[i] = permutations[i];
        sum  = 0;
        for ( int j = 1; j < i; j++ ) {
          sum += ( result[j] * permutations[ i - j ] );
          sum %= MOD_VALUE;
        }
        result[i] += MOD_VALUE;
        result[i] -= sum;
        result[i] %= MOD_VALUE;
      }
      System.out.println(result[m]);
    }
    in.close();
  }

}
