import java.util.Scanner;

public class Main {

  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    in.nextLine();
    String[] r = in.nextLine().split(" ");
    if ( r[k-1].equals("0") ) {
      while ( --k >= 0 && r[k].equals("0") );
      k++;
    } else {
      for (; k < n && r[k].equals(r[k-1]) ;k++);
    }
    System.out.println(k);
    in.close();
  }
}
