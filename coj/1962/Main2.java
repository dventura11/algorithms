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

        for (j = 0; j < m; j++) System.out.println(j + ": " + cost[j]);

        System.out.println("primer vaca: " + cows[0]);
        for (i = 0; i < n; i++) {
            System.out.println("Calculando minimo para "+(i+1)+" vacas");
            System.out.println("vaca actual: " + cows[i]);
            System.out.println("Bloque: " + (cows[i] - cows[0] + 1) );
            min[i] = cost[cows[i] - cows[0]];
            System.out.println("minimo : " + min[i]);
            for ( j = 0; j < i; j++) {
                System.out.println("min["+j+"]: " + min[j]);
                System.out.println("cows ["+i+"] - ["+(j+1)+"] = " + cows[i] + " - " + cows[j+1]);
                System.out.println("cost[" + (cows[i] - cows[j+1]) + "] = " +  (cost[cows[i] - cows[j+1]]));
                tempCost = min[j] + cost[cows[i] - cows[j+1]];
                System.out.println("tempCost : " + tempCost);
                min[i] = Math.min(min[i], tempCost);
            }
            System.out.println("minimo : " + min[i]);
            System.out.println("===========================");
        }
        System.out.println(min[n - 1]);

        in.close();
    }
}

