import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i, j, sum = 0, n = in.nextInt();
        long min, max, ml, mr;
        long l = in.nextLong();
        long r = in.nextLong();
        long[] edges = new long[n];
        for (i = 0; i < n; i++) edges[i] = in.nextLong();
        for (i = 0; i < n; i++) {
            for (j = n - 1; j > i; j--) {
                min = Math.min(edges[i],edges[j]);
                max = Math.max(edges[i],edges[j]);
                ml = max - min + 1;
                mr = max + min - 1;
                if ( mr < ml ) continue;
                if (ml <= l && mr >= r) {
                    System.out.println(r-l+sum+1);
                    return;
                }
                if (mr >= l && mr < r) {
                    mr++;
                    sum += mr - l;
                    l = mr;
                } else if (ml <= r && ml > l) {
                    ml--;
                    sum += r - ml;
                    r = ml;
                }
                if (r < l) {
                    System.out.println(sum);
                    return;
                }
            }
        }
        System.out.println(sum);
        in.close();
    }

}
