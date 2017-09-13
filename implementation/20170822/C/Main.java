import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int x1 = in.nextInt();
    int x2 = in.nextInt();

    int t1 = in.nextInt();
    int t2 = in.nextInt();

    int p = in.nextInt();
    int d = in.nextInt();

    int total1 = Math.abs(x1 - x2) * t2;
    int total2 =
      d == 1 ? //el tren va a la derecha`
      x2 > x1 ? // igor va a la derecha
      p <= x1 ? // el tren esta atras de igor
      x2 - p
      : // el tren esta despues de igor
      s - p + s + x2
      : //igor va a la izquierda
      s - p + s - x2
      : // el tren va a la izquierda
      x2 > x1 ? // igor va a la derecha
      p + x2
      : // igor va a la izquierda
      p >= x1 ? // el tren esta detras de igor
      p - x2
      : // el tren esta delante de igor
      p + s + s - x2
      ;
    total2 *= t1;
    System.out.println( Math.min(total1, total2) );
    in.close();
  }
}
