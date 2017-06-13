import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int curr = 3;
    int prev = 1;
    int temp, mod = 1000000007;
    for (int i = 2; i < n; i++) {
      temp = curr;
      curr += prev;
      prev = temp;
      curr %= mod;
    }
    System.out.println(curr);
    in.close();
  }
}
