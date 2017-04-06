import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static class CacheValue {
        private char c;
        private List<String> list;
        CacheValue(char c, List<String> list) {
            this.c = c;
            this.list = list;
        }

        public int hashCode() {
            return String.format("%d%d", c, list.hashCode() ).hashCode();
        }

        public boolean equals(Object o) {
            if (o instanceof CacheValue) {
                CacheValue v = (CacheValue) o;
                return v.c == this.c && this.list.equals(v.list);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int size;
        while ( cases-- > 0 ) {
            size = in.nextInt();
            List<String> words = new ArrayList<String>();
            while ( size-- > 0 ) {
                words.add(in.next());
            }
            System.out.println( maxString(' ', words, new HashMap<CacheValue,Integer>() ) );
        }
        in.close();
    }

    private static int maxString(char startWith, List<String> words, Map<CacheValue,Integer> cache) {
        int max = 0;
        CacheValue testCase = new CacheValue(startWith, words);
        if (cache.containsKey(testCase)) {
            return cache.get(testCase);
        }
        for (String current : words) {
            if ( startWith == ' ' || current.charAt(0) == startWith) {
                List<String> wordsCopy = new ArrayList<String>(words);
                wordsCopy.remove(current);
                max = Math.max(max, current.length() + maxString( current.charAt(current.length() - 1), wordsCopy, cache));
            }
        }
        cache.put(testCase, max);
        return max;
    }

}
