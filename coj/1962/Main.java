import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int i, j;
        long tempCost;
        int n = in.nextInt();
        int m = in.nextInt();
        long[] min = new long[n];
        int[] cows = new int[n];
        int[] cost = new int[m];

        for (i = 0; i < n; i++) cows[i] = in.nextInt();
        Arrays.sort(cows);
        for (j = 0; j < m; j++) cost[j] = in.nextInt();

        for (i = m - 1; i > 0; i--)
            if ( cost[i] < cost[i-1])
                cost[i-1] = cost[i];

        for (i = 0; i < n; i++) {
            min[i] = cost[cows[i] - cows[0]];
            for ( j = 0; j < i; j++) {
                tempCost = min[j] + cost[cows[i] - cows[j+1]];
                min[i] = Math.min(min[i], tempCost);
            }
        }
        System.out.println(min[n - 1]);

        in.close();
    }
}

