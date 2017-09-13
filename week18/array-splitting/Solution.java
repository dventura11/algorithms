import java.io.File;
import java.util.Scanner;

public class Solution {

  public static void main (String ... args) throws Exception{
    //Scanner in = new Scanner(System.in);
    Scanner in = new Scanner(new File("in.txt"));
    int cases = in.nextInt();
    int n, result;
    long leftsum, rightSum;
    while ( cases-- > 0 ) {
      n = in.nextInt();
      int[] data = new int[n];
      result = 0;
      leftsum = 0;
      rightSum = 0;
      while ( n-- > 0 ) {
        data[n] = in.nextInt();
        leftsum += data[n];
      }
      System.out.println("initial leftsum: "+ leftsum);
      if ( leftsum == 0 ) {
        System.out.println(data.length - 1);
        continue;
      }
      for ( int i = data.length - 1; i > 0; i-- ) {
        rightSum += data[i];
        leftsum -= data[i];
        System.out.println("i: " + i + ", data[i]: " + data[i] + ", leftsum = " + leftsum + ", rightSum = " + rightSum);
        if ( leftsum == rightSum ) {
          System.out.println("i: " + i + ", leftsum = " + leftsum + ", rightSum = " + rightSum);
          rightSum = 0;
          result++;
          continue;
        }
        //if ( rightSum > leftsum ) {
        //break;
        //}
      }
      System.out.println(result);
    }
    in.close();
  }

}

