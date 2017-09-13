import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int lemmons = in.nextInt();
    int apples = in.nextInt();
    int pears = in.nextInt();
    int max = Math.min(lemmons, apples/2);
    max = Math.min(max, pears/4);
    max *= 7;
    System.out.println(max);
    in.close();
  }
}
