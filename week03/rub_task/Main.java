import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static class Point implements Comparable<Point> {
        int x, y;
        long cost;
        Point(int x, int y,long cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Point p) {
            return this.cost == p.cost ? 0 : this.cost > p.cost ? 1 : -1;
        }
    }

    private static int[] X = { 1, 0,-1, 0};
    private static int[] Y = { 0,-1, 0, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x, y, i;
        int n = in.nextInt();
        int m = in.nextInt();
        int[][]cost = new int[n][m];
        long[][]min = new long[n][m];
        Queue<Point> queue = new PriorityQueue<Point>();
        Point current, temp;
        for( y = 0; y < n; y++ ) {
            for( x = 0; x < m; x++ ) {
                cost[y][x] = in.nextInt();
                min[y][x] = x == 0 ? cost[y][x] : Long.MAX_VALUE;
                if (x == 0) {
                    queue.offer(new Point(x, y, cost[y][x]));
                }
            }
        }

        while (! queue.isEmpty()) {
            current = queue.poll();
            if (current.x == m-1) {
                System.out.println(current.cost);
                break;
            }
            for (i = 0; i < X.length; i++) {
                x = current.x + X[i];
                y = current.y + Y[i];
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    temp = new Point(x, y, current.cost + cost[y][x]);
                    if (temp.cost < min[y][x]) {
                        min[y][x] = temp.cost;
                        queue.offer(temp);
                    }
                }
            }
        }

        in.close();
    }
}
