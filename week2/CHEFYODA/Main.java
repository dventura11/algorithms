import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int paths, win;

    private static int[] X1 = new int[]{ 1, 0,-1, 0};
    private static int[] Y1 = new int[]{ 0, 1, 0,-1};
    private static int[] X2 = new int[]{ 1, 1,-1,-1};
    private static int[] Y2 = new int[]{ 1,-1, 1,-1};

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while ( cases-- > 0 ) {
            System.out.printf("%.6f\n",calculate(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
        }
        in.close();
    }

    private static double calculate(int n, int m, int p, int k) {
        boolean[][] grid = new boolean[n][m];
        paths = 0;
        win = 0;
        calculateRule(grid, 0, 0, X1, Y1, 0);
        double posibility = (win*1.0)/(paths*1.0);
        paths = 0;
        win = 0;
        calculateRule(grid, 0, 0, X2, Y2, 0);
        posibility += (win*1.0)/(paths*1.0);
        posibility /= 2;
        double necessary = (p*1.0)/(k*1.0);
        //System.out.printf("\n paths:%d\twin:%d\tposibility:%f\tnecessary:%f  \n", paths, win, posibility, necessary);
        return (posibility)/necessary;
    }

    private static void calculateRule(final boolean[][] grid, int x, int y, int[] X, int[] Y,final int step) {
        int i, xr, yr;
        boolean[][] gridClone = new boolean[grid.length][grid[0].length];
        for (i = 0; i < grid.length; i++) {
            gridClone[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        gridClone[x][y] = true;
        //System.out.printf("\n%s tira en:\tx:%d\ty:%d\t le toca a %s\n", step%2==0? "yoda": "chef", x, y, step%2==1? "yoda": "chef");
        //printArray(gridClone);
        boolean endOfGame = true;
        for (i = 0; i < X.length; i++) {
            xr = x + X[i];
            yr = y + Y[i];
            if (xr < 0 || yr < 0 || xr >= gridClone.length || yr >= gridClone[0].length || gridClone[xr][yr]) continue;
            endOfGame = false;
            calculateRule(gridClone, xr, yr, X, Y, step + 1);
        }
        if (endOfGame) {
            paths++;
            win += step%2;
            //System.out.println("ends in step: " + step + " " + (step%2==0? "yoda": "chef") + " gana");
        }
    }

    private static void printArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(boolean b : arr[i]){
                System.out.print(b ? "X" : "0");
            }
            System.out.println("");
        }
        System.out.println("-----------");
    }

}
