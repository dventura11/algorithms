import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.nextLine();
    StringBuilder encoded = new StringBuilder(in.next());
    if ( encoded.length() <= 1 ) {
      System.out.println(encoded);
      in.close();
      return;
    }
    StringBuilder decoded = new StringBuilder( encoded.substring(encoded.length() - 2) );
    encoded.deleteCharAt(encoded.length() - 1);
    encoded.deleteCharAt(encoded.length() - 1);
    while (encoded.length() > 0 ) {
      char next = encoded.charAt(encoded.length() - 1);
      encoded.deleteCharAt(encoded.length() - 1);
      decoded.insert(decoded.length()/2, next);
    }
    System.out.println(decoded);
    in.close();
  }
}
