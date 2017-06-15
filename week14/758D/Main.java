import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    in.nextLine();
    String k = in.nextLine();
    int size = String.valueOf(n).length();
    long result = 0, exp = 1;
    String sub;
    for (int i = k.length(); i > 0; i-=size) {
      sub = k.substring(i - size >= 0 ? i - size : 0, i);
      long temp = Long.parseLong( sub );
      if (temp >= n) {
        sub = k.substring( i - size + 1, i);
        i++;
      }
      while ( sub.length() > 1 && sub.charAt(0) == '0') {
        sub = sub.substring(1);
        i++;
      }
      temp = Long.parseLong( sub );
      result += temp * exp;
      exp *= n;
    }
    System.out.println(result);
    in.close();
  }
}
