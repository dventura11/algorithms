import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] coins = {1, 5, 10, 25, 50};
        long[] changeWays = new long[7490];
        changeWays[0] = 1;
        for (int coin : coins) {
            for(int i = coin; i < changeWays.length; i++) {
                changeWays[i] += changeWays[ i - coin ];
            }
        }

        while (in.hasNext()) {
            System.out.println( changeWays[in.nextInt()] );
        }
        in.close();
    }

}

