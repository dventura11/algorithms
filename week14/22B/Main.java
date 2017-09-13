import java.util.Scanner;
import java.util.Stack;

public class Main {

  static class MinNode {
    int value;
    int times;
    MinNode(int v) {
      this.value = v;
      this.times = 1;
    }
  }
  static class MinStack extends Stack<Integer> {

    private static final long serialVersionUID = 8799656478674716638L;

    private Stack<MinNode> stack = new Stack<MinNode>();

    @Override
    public Integer pop() {
      Integer popValue = super.pop();
      if ( popValue.intValue() == stack.peek().value ) {
        stack.peek().times--;
        if (stack.peek().times == 0) {
          stack.pop();
        }
      }
      return popValue;
    }

    @Override
    public Integer push(Integer v) {
      if (stack.isEmpty() || v < stack.peek().value) {
        MinNode mn = new MinNode(v);
        stack.push(mn);
      } else if ( v == stack.peek().value) {
        stack.peek().times++;
      }
      return super.push(v);
    }

    public int min() {
      return stack.peek().value;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int i, x, y, w, max = 0;
    int n = in.nextInt();
    int m = in.nextInt();
    int[][][] office = new int[m][n][4];
    String line;
    for (y = 0; y < n; y++) {
      line = in.next();
      for (x = 0; x < m; x++) {
        office[x][y][0] = line.charAt(x) - '0';
        office[x][y][1] =  office[x][y][0] == 1 ? 0 : y == 0 ? 1 : office[x][y-1][1] + 1;
        office[x][y][2] =  office[x][y][0] == 1 ? 0 : x == 0 ? 1 : office[x-1][y][2] + 1;
        if ( office[x][y][0] == 1) continue;
        MinStack stack = new MinStack();
        for (i = x; i >= 0 && office[i][y][0] == 0 ; i--) {
          stack.push(office[i][y][1]);
        }
        w = office[x][y][2];
        while (!stack.isEmpty()) {
          office[x][y][3] = Math.max(office[x][y][3] , (w+stack.min())<<1);
          w--;
          stack.pop();
        }
        max = Math.max(max, office[x][y][3]);
      }
    }

    for (i = 0; i < 3; i++) {
      for (y = 0; y < n; y++) {
        for (x = 0; x < m; x++) {
          System.out.print(office[x][y][i] + ",");
        }
        System.out.println("");
      }
      System.out.println("=====================");
    }
    System.out.println(max);
    in.close();
  }

}
