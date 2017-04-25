import java.util.Scanner;

public class Main {

  private static final int[] X = {1,-1,0,0};
  private static final int[] Y = {0,0,1,-1};

  private static void fillGrid(int xi, int yi, int[][] grid, int v) {
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 0; i < X.length; i++) {
      int x = xi + X[i];
      int y = yi + Y[i];
      while ( x >= 0 && x < m && y >= 0 && y < n && grid[y][x] == 0) {
        grid[y][x] = v;
        x += X[i];
        y += Y[i];
      }
    }
  }
  public static void main(String ... args) {
    Scanner in = new Scanner(System.in);
    int ix=0, iy=0, fx=0, fy=0, temp = 0;
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] grid = new int[n][m];
    String line;
    for (int i = 0; i < n; i++) {
      line = in.next();
      for (int j = 0; j < m; j++) {
        switch (line.charAt(j)) {
          case '.':
            temp = 0;
            break;
          case 'S':
            temp = 1;
            ix = j;
            iy = i;
            break;
          case 'T':
            temp = 2;
            fx = j;
            fy = i;
            break;
          case '*':
            temp = -1;
            break;
        }
        grid[i][j] = temp;
      }
    }
    fillGrid(ix,iy,grid,1);
    fillGrid(fx,fy,grid,2);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if ( grid[i][j] != 1 ) continue;
        for (int f = 0; f < X.length; f++) {
          int x = j + X[f];
          int y = i + Y[f];
          while ( x >= 0 & x < m && y >= 0 && y < n && grid[y][x] >= 0) {
            if ( grid[y][x] == 2) {
              System.out.println("YES");
              in.close();
              return;
            }
            if ( grid[y][x] == 1) break;
            x += X[f];
            y += Y[f];
          }
        }
      }
    }
    System.out.println("NO");
    in.close();
  }

}
