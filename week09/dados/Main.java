import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String ... a) {
    Scanner in = new Scanner(System.in);
    int nDados = in.nextInt();
    int lados[] = new int[nDados];
    while ( nDados-- > 0 ) lados[nDados] = in.nextInt();
    Arrays.sort(lados);
    long result[] = new long[lados[lados.length-1]];
    result[result.length-1] = 0;
    for (int i = lados.length-1; i >= 0; i--) {
      for (int j = lados[i]-1; j >=0 ; j--) {
        if ( result[j] == 0) result[j] = 1;
        if ( j == lados[i] - 1 ) continue;
        result[j] += result[j+1];
      }
    }
    System.out.println(result[0]);
    in.close();
  }
}
