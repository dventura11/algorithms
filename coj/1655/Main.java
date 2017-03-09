import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println( isSubsequence(in.next(), in.next()) ? "Yes" : "No" );
        }
        in.close();
    }

    private static boolean isSubsequence(String s, String t) {
        return maxSubsequenceLength(s, t) == s.length();
    }

    private static int maxSubsequenceLength(String s, String t) {
        int[][] subsequent = new int[s.length()+1][t.length()+1];
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                subsequent[i][j] = (s.charAt(i-1) == t.charAt(j-1)) ?
                    subsequent[i-1][j-1] + 1 :
                    Math.max(subsequent[i-1][j], subsequent[i][j-1]);
            }
        }
        return subsequent[s.length()][t.length()];
    }
}
