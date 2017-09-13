import java.util.Scanner;

public class Main {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    long sum = 0;
    while ( !"1".equals(s) ) {
      //el numero solo contiene 1...0
      if ( s.indexOf("1",1) == -1) {
        sum += s.length() - 1;
        break;
      }
      //si es par acaba en 0
      if ( s.charAt(s.length() - 1) == '0' ) {
        //recorremos haste encontrar un 1
        sum += s.length() - s.lastIndexOf('1') - 1;
        s = s.substring(0, s.lastIndexOf('1') + 1);
      } else {
        //es impar.debemos sumar un 1 y recorrer hasta esa pocision
        sum += s.length() - s.indexOf('1', s.lastIndexOf('0'));
        s = s.substring(0,s.indexOf('0') == -1 ? 0 : s.lastIndexOf('0'));
        s += '1';
        sum++;
      }
    }
    System.out.println(sum);
    in.close();
  }
}
